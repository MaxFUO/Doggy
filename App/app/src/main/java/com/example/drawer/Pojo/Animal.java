package com.example.drawer.Pojo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class Animal {

    private int id;
    private String nombreAnimal;
    private String generoAnimal;
    private String cuidadosEspeciales;
    private String alimentoFavorito;
    private float pesoAni;
    private String razaAni;
    private int fuerza;
    private int velocidad;
    private int buff;
    private String desBuff;
    private String debilidad;
    private Bitmap imagen;
    private String dato; //ruta en si
    private String descripcionAnimal;

    public Animal() {
    }

    public Animal(int id, String nombreAnimal, String generoAnimal, String cuidadosEspeciales,
                  String alimentoFavorito, float pesoAni, String razaAni, int fuerza, int velocidad, int buff,
                  String desBuff, String debilidad, Bitmap imagen, String dato, String descripcionAnimal) {

        this.id = 0;
        this.nombreAnimal = "nnnn";
        this.generoAnimal = "nnnn";
        this.cuidadosEspeciales = "nnnn";
        this.alimentoFavorito = "nnnn";
        this.pesoAni = 0;
        this.razaAni = "nnnn";
        this.fuerza = 0;
        this.velocidad = 0;
        this.buff = 0;
        this.desBuff = "nnnn";
        this.debilidad = "nnnn";
        this.imagen = imagen;
        this.dato = dato;
        this.descripcionAnimal = "nnnn";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getGeneroAnimal() {
        return generoAnimal;
    }

    public void setGeneroAnimal(String generoAnimal) {
        this.generoAnimal = generoAnimal;
    }

    public String getCuidadosEspeciales() {
        return cuidadosEspeciales;
    }

    public void setCuidadosEspeciales(String cuidadosEspeciales) {
        this.cuidadosEspeciales = cuidadosEspeciales;
    }

    public String getAlimentoFavorito() {
        return alimentoFavorito;
    }

    public void setAlimentoFavorito(String alimentoFavorito) {
        this.alimentoFavorito = alimentoFavorito;
    }

    public float getPesoAni() {
        return pesoAni;
    }

    public void setPesoAni(float pesoAni) {
        this.pesoAni = pesoAni;
    }

    public String getRazaAni() {
        return razaAni;
    }

    public void setRazaAni(String razaAni) {
        this.razaAni = razaAni;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public String getDesBuff() {
        return desBuff;
    }

    public void setDesBuff(String desBuff) {
        this.desBuff = desBuff;
    }

    public String getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
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
            imagen = BitmapFactory.decodeByteArray(bytecode, 0, bytecode.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDescripcionAnimal() {
        return descripcionAnimal;
    }

    public void setDescripcionAnimal(String descripcionAnimal) {
        this.descripcionAnimal = descripcionAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombreAnimal='" + nombreAnimal + '\'' +
                ", generoAnimal='" + generoAnimal + '\'' +
                ", cuidadosEspeciales='" + cuidadosEspeciales + '\'' +
                ", alimentoFavorito='" + alimentoFavorito + '\'' +
                ", pesoAni=" + pesoAni +
                ", razaAni='" + razaAni + '\'' +
                ", fuerza=" + fuerza +
                ", velocidad=" + velocidad +
                ", buff=" + buff +
                ", desBuff='" + desBuff + '\'' +
                ", debilidad='" + debilidad + '\'' +
                ", imagen=" + imagen +
                ", dato='" + dato + '\'' +
                ", descripcionAnimal='" + descripcionAnimal + '\'' +
                '}';
    }
}
