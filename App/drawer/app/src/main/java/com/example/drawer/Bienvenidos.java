package com.example.drawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bienvenidos extends AppCompatActivity implements View.OnClickListener {

    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenidos);

        btnIniciarSesion = findViewById(R.id.btnIniciarSesionBienvenidos);
        btnIniciarSesion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, IniciarSesion.class);
        startActivity(intent);
    }

    public void llamar_CreateAcount(View view){
        Intent intent = new Intent(this, CrearCuenta.class);
        startActivity(intent);

    }



}
