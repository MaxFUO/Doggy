package com.example.drawer.ui.adopcionpanel;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawer.R;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EditarInicioInterfaz extends Fragment {

    EditText edtUsuario, edtEditarNombre, edtEditarApellidos, edtEditarEdad, edtEditarNumero, edtEditarCorreo, edtEditarContraseña;
    Button btnVolver, btnGuardarCambios;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editar_inicio_interfaz, container, false);

        edtUsuario = view.findViewById(R.id.edtIdUsuario);
        edtEditarNombre = view.findViewById(R.id.edtEditarNombre);
        edtEditarApellidos = view.findViewById(R.id.edtEditarApellidos);
        edtEditarEdad = view.findViewById(R.id.edtEditarEdad);
        edtEditarNumero = view.findViewById(R.id.edtEditarNumero);
        edtEditarCorreo = view.findViewById(R.id.edtEditarCorreo);
        edtEditarContraseña = view.findViewById(R.id.edtEditarContraseña);
        btnVolver = view.findViewById(R.id.btnVolver);
        btnGuardarCambios = view.findViewById(R.id.btnGuardarCambios);

        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtUsuario.getText().toString();
                String nombre = edtEditarNombre.getText().toString();
                String apellidos = edtEditarApellidos.getText().toString();
                String edad = edtEditarEdad.getText().toString();
                String numero = edtEditarNumero.getText().toString();
                String correo = edtEditarCorreo.getText().toString();
                String contraseña = edtEditarContraseña.getText().toString();

                String url = "http://192.168.1.9:80/doggy/insertar_datos.php?id=" + id +
                        "&nombre=" + nombre +
                        "&apellido=" + apellidos +
                        "&edad=" + edad +
                        "&telefono=" + numero +
                        "&correo=" + correo +
                        "&contrasena=" + contraseña;

                actualizarUsuario(url);
            }
        });

        return view;
    }

    private void actualizarUsuario(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "Actualización exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(stringRequest);
    }
}

