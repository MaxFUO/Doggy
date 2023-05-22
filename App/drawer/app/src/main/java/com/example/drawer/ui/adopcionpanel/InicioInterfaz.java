package com.example.drawer.ui.adopcionpanel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawer.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InicioInterfaz extends Fragment {

    ImageView imgFotoPerfil;
    TextView txtUsuario, txtCorreo, txtMonedas;
    Button btnBuscarUsuario;

    EditText edtBuscarUsuario;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio_interfaz, container, false);
        txtUsuario = view.findViewById(R.id.txtUsuario);
        txtCorreo = view.findViewById(R.id.txtCorreo);
        txtMonedas = view.findViewById(R.id.txtMonedas);
        btnBuscarUsuario = view.findViewById(R.id.btnBuscarUsuario);
        edtBuscarUsuario = view.findViewById(R.id.edtBuscarUsuario);

        btnBuscarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarUsuarios("http://192.168.1.9:80/doggy/buscar_usuarios.php?idUsuario="+edtBuscarUsuario.getText()+"");
               /* 192.168.1.19:80*/
            }
        });


        return view;
    }

    private void buscarUsuarios(String URL) {
        JsonRequest jsonRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        edtBuscarUsuario.setText(jsonObject.getString("IDUsuario"));

                        // Obtener el nombre y apellido del usuario
                        String nombreUsuario = jsonObject.getString("NombreUsu");
                        String apellidoUsuario = jsonObject.getString("ApellidoUsu");

                        // Concatenar el nombre y apellido
                        String nombreCompleto = nombreUsuario + " " + apellidoUsuario;

                        // Mostrar el nombre completo en el TextView
                        txtUsuario.setText(nombreCompleto);
                        txtCorreo.setText(jsonObject.getString("CorreoElectronicoUsu"));
                        txtMonedas.setText(jsonObject.getString("MonedasUsu"));

                        // Obtener la imagen y decodificarla
                        String imagenBase64 = jsonObject.getString("ImagenUsu");
                        byte[] imagenBytes = Base64.decode(imagenBase64, Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(imagenBytes, 0, imagenBytes.length);

                        // Mostrar la imagen en el ImageView
                        ImageView imgFotoPerfil = getView().findViewById(R.id.imgFotoPerfil);
                        imgFotoPerfil.setImageBitmap(bitmap);
                    } catch (JSONException e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonRequest);
    }

}
