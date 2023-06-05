package com.example.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CrearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
    }

    public void llamarLogin(View view) {
        Intent intent = new Intent(CrearCuenta.this, IniciarSesion.class);
        startActivity(intent);
    }


}