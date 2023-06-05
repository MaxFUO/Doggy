package com.example.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Bienvenidos extends AppCompatActivity implements View.OnClickListener {

    Button btnIniciarSecion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenidos);

        btnIniciarSecion=findViewById(R.id.btnIniciarSecion);
        btnIniciarSecion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(Bienvenidos.this, IniciarSesion.class);
        startActivity(i);
    }

    public void llamar_CreateAcount(View view){
        Intent x = new Intent(Bienvenidos.this, CrearCuenta.class);
        startActivity(x);

    }

}