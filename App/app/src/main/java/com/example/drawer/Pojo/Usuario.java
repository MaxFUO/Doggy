package com.example.drawer.Pojo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class Usuario {

    private Integer ID_Usuario;
    private String NombreUsu;
    private String ApellidoUsu;
    private Integer EdadUsu;
    private Integer NumeroTelefonoUsu;
    private String CorreoElectronicoUsu;
    private Integer MonedasUsu;
    private String PasswordUsu;
    private Bitmap ImagenUsu;
    private String RutaImgUsu;
    private String dato;

    public Usuario() {

    }

    public Usuario(Integer ID_Usuario, String nombreUsu, String apellidoUsu, Integer edadUsu, Integer numeroTelefonoUsu, String correoElectronicoUsu, Integer monedasUsu, String passwordUsu, Bitmap imagenUsu, String rutaImgUsu, String dato) {
        this.ID_Usuario = ID_Usuario;
        NombreUsu = nombreUsu;
        ApellidoUsu = apellidoUsu;
        EdadUsu = edadUsu;
        NumeroTelefonoUsu = numeroTelefonoUsu;
        CorreoElectronicoUsu = correoElectronicoUsu;
        MonedasUsu = monedasUsu;
        PasswordUsu = passwordUsu;
        ImagenUsu = imagenUsu;
        RutaImgUsu = rutaImgUsu;
        this.dato = dato;
    }

    public Integer getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(Integer ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombreUsu() {
        return NombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        NombreUsu = nombreUsu;
    }

    public String getApellidoUsu() {
        return ApellidoUsu;
    }

    public void setApellidoUsu(String apellidoUsu) {
        ApellidoUsu = apellidoUsu;
    }

    public Integer getEdadUsu() {
        return EdadUsu;
    }

    public void setEdadUsu(Integer edadUsu) {
        EdadUsu = edadUsu;
    }

    public Integer getNumeroTelefonoUsu() {
        return NumeroTelefonoUsu;
    }

    public void setNumeroTelefonoUsu(Integer numeroTelefonoUsu) {
        NumeroTelefonoUsu = numeroTelefonoUsu;
    }

    public String getCorreoElectronicoUsu() {
        return CorreoElectronicoUsu;
    }

    public void setCorreoElectronicoUsu(String correoElectronicoUsu) {
        CorreoElectronicoUsu = correoElectronicoUsu;
    }

    public Integer getMonedasUsu() {
        return MonedasUsu;
    }

    public void setMonedasUsu(Integer monedasUsu) {
        MonedasUsu = monedasUsu;
    }

    public String getPasswordUsu() {
        return PasswordUsu;
    }

    public void setPasswordUsu(String passwordUsu) {
        PasswordUsu = passwordUsu;
    }

    public Bitmap getImagenUsu() {
        return ImagenUsu;
    }

    public void setImagenUsu(Bitmap imagenUsu) {
        ImagenUsu = imagenUsu;
    }

    public String getRutaImgUsu() {
        return RutaImgUsu;
    }

    public void setRutaImgUsu(String rutaImgUsu) {
        RutaImgUsu = rutaImgUsu;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
        try {
            byte[] bytecode = Base64.decode(dato, Base64.DEFAULT);
            ImagenUsu = BitmapFactory.decodeByteArray(bytecode, 0, bytecode.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID_Usuario=" + ID_Usuario +
                ", NombreUsu='" + NombreUsu + '\'' +
                ", ApellidoUsu='" + ApellidoUsu + '\'' +
                ", EdadUsu=" + EdadUsu +
                ", NumeroTelefonoUsu=" + NumeroTelefonoUsu +
                ", CorreoElectronicoUsu='" + CorreoElectronicoUsu + '\'' +
                ", MonedasUsu=" + MonedasUsu +
                ", PasswordUsu='" + PasswordUsu + '\'' +
                ", ImagenUsu=" + ImagenUsu +
                ", RutaImgUsu='" + RutaImgUsu + '\'' +
                ", dato='" + dato + '\'' +
                '}';
    }
}
