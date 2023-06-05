package com.example.drawer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawer.Pojo.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IniciarSesion extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener, View.OnClickListener {

    EditText edtUsuario, edtPassword;
    Button btnCrearCuenta;

    String usuario, contraseña, idUsuario;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        edtUsuario = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnCrearCuenta.setOnClickListener(this);

        request = Volley.newRequestQueue(this);


    }


    public void crearCuenta(View view) {
        Intent intent = new Intent(this, CrearCuenta.class);
        startActivity(intent);
    }

    private void cargarLogin() {
        progreso = new ProgressDialog(this);
        progreso.setMessage("Consultando datos");
        progreso.show();
        String url = "http://140.84.189.249/consultarlogin.php?CorreoElectronicoUsu=" + edtUsuario.getText().toString();
        url = url.replace(" ", "%20");
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }


    @Override
    public void onResponse(JSONObject response) {
        progreso.hide();
        Usuario miusuario = new Usuario();
        JSONArray json = response.optJSONArray("usuario");
        JSONObject jsonObject = null;
        try {
            jsonObject = json.getJSONObject(0);

            miusuario.setID_Usuario(jsonObject.getInt("ID_Usuario"));
            miusuario.setCorreoElectronicoUsu(jsonObject.optString("CorreoElectronicoUsu"));
            miusuario.setPasswordUsu(jsonObject.optString("PasswordUsu"));

            usuario = miusuario.getCorreoElectronicoUsu();
            contraseña = miusuario.getPasswordUsu();

            if (usuario.equals(edtUsuario.getText().toString())&& contraseña.equals(edtPassword.getText().toString())) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrecto.", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            progreso.hide();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        cargarLogin();
    }
}