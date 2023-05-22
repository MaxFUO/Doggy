package com.example.drawer.ui.Albergue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawer.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ContactoAlbergue extends Fragment {

    TextView txtNombreAlbergue, txtUbicacionAlbergue, txtDescripcionAlbergue, txtNumeroContacto, txtCorreoElectronico;
    EditText edtIdAlbergue;
    Button btnConsultarAlbergue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacto_albergue, container, false);

        txtNombreAlbergue = view.findViewById(R.id.txtNombreAlbergue);
        txtUbicacionAlbergue = view.findViewById(R.id.txtUbicacionAlbergue);
        txtDescripcionAlbergue = view.findViewById(R.id.txtDescripcionAlbergue);
        txtNumeroContacto = view.findViewById(R.id.txtNumeroContacto);
        txtCorreoElectronico = view.findViewById(R.id.txtCorreoElectronico);
        edtIdAlbergue = view.findViewById(R.id.edtIdAlbergue);
        btnConsultarAlbergue = view.findViewById(R.id.btnConsultarAlbergue);

        btnConsultarAlbergue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idAlbergue = edtIdAlbergue.getText().toString().trim();
                if (!idAlbergue.isEmpty()) {
                    buscarInformacionAlbergue(idAlbergue);
                } else {
                    Toast.makeText(getActivity(), "Ingrese el ID del albergue", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void buscarInformacionAlbergue(String idAlbergue) {
        String url = "http://192.168.0.28:80/doggy/buscar_informacion_albergue.php?idAlbergue=" + idAlbergue;

        JsonObjectRequest request = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String nombre = response.getString("NombreAlb");
                            String ubicacion = response.getString("DireccionAlb");
                            String descripcion = response.getString("DescripcionAlb");
                            String numeroContacto = response.getString("NumeroTelfAlb");
                            String correoElectronico = response.getString("CorreoElectronicoAlb");

                            txtNombreAlbergue.setText(nombre);
                            txtUbicacionAlbergue.setText(ubicacion);
                            txtDescripcionAlbergue.setText(descripcion);
                            txtNumeroContacto.setText(numeroContacto);
                            txtCorreoElectronico.setText(correoElectronico);
                        } catch (JSONException e) {
                            Toast.makeText(getActivity(), "Error al procesar la respuesta", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Error de conexión", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}
