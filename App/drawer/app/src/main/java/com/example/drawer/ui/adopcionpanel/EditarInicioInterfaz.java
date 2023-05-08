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

import com.example.drawer.R;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EditarInicioInterfaz extends Fragment {

    EditText edtUsuario, edtEditarNombre, edtEditarNumero, edtEditarCorreo, edtEditarContraseña;
    Button btnVolver, btnGuardarCambios;

    String url = "http://192.168.163.1:80/doggy/actualizar_datos_usuarios.php";

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editar_inicio_interfaz, container, false);


        edtUsuario = view.findViewById(R.id.edtIdUsuario);
        edtEditarNombre = view.findViewById(R.id.edtEditarNombre);
        edtEditarNumero = view.findViewById(R.id.edtEditarNumero);
        edtEditarCorreo = view.findViewById(R.id.edtEditarCorreo);
        edtEditarContraseña = view.findViewById(R.id.edtEditarContraseña);
        btnGuardarCambios = view.findViewById(R.id.btnGuardarCambios);
        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarInformacionUsuario("http://192.168.163.1:80/doggy/actualizar_datos_usuarios.php?idUsuario="+edtUsuario.getText()+"");
                /* 192.168.1.19:80*/
            }
        });
        return view;
    }
    private void editarInformacionUsuario(String URL) {
        try {
            URL obj = new URL(url);

            // Inicializar una conexión HTTP
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Especificar que se va a enviar una solicitud POST
            con.setRequestMethod("POST");

            // Especificar los parámetros a enviar en la solicitud
            String urlParameters = "IDUsuario=" + edtUsuario.getText() + "&NombreUsu=" + edtEditarNombre.getText() + "&NumeroTelefonoUsu=" + edtEditarNumero.getText() + "&CorreoElectronicoUsu=" + edtEditarCorreo.getText() + "&ContraseñaUsu=" + edtEditarContraseña.getText();

            // Enviar los parámetros en el cuerpo de la solicitud
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            // Leer la respuesta del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Mostrar la respuesta del servidor en un mensaje de texto
            Toast.makeText(getContext(), response.toString(), Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}