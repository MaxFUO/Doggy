package com.example.drawer.Pojo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class Albergue {
    private int id;
    private String nombre;
    private String horaApertura;
    private String direccion;
    private String correoElectronico;
    private Bitmap imagen;
    private String dato;

    public Albergue() {

    }

    public Albergue(int id, String nombre, String horaApertura, String direccion, String correoElectronico, Bitmap imagen, String dato) {
        this.id = id;
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.imagen = imagen;
        this.dato = dato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
        try {
            byte[] bytecode = Base64.decode(dato, Base64.DEFAULT);
            //entonces en la propiedad imagen vamos a llamar a la clase Bitman |LLamas| objeto
            imagen = BitmapFactory.decodeByteArray(bytecode, 0, bytecode.length);//y con esta clase vamos a pdoer que invoque al metodo que permite codificar arrays
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


