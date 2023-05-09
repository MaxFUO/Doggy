package com.example.drawer.Entidades;

import android.graphics.Bitmap;

public class Animales {
    private Integer IDAnimal;
    private String NombreAni;
    private String GeneroAni;
    private String CuidadosEspeciales;
    private String AlimentoFavorito;
    private Float PesoAni;
    private String RazaAni;
    private Integer FuerzaAni;
    private Integer VelocidadAni;
    private Integer BuffAni;
    private String DesBuffAni;
    private String DebilidadAni;
    private Bitmap ImagenAnim;
    private String RutaImagen;
    private String DescripcionAnim;

    public Animales(String s) {
    }

    public Animales(Integer IDAnimal, String nombreAni, String generoAni, String cuidadosEspeciales, String alimentoFavorito, Float pesoAni, String razaAni, Integer fuerzaAni, Integer velocidadAni, Integer buffAni, String desBuffAni, String debilidadAni, Bitmap imagenAnim, String rutaImagen, String descripcionAnim) {
        this.IDAnimal = IDAnimal;
        NombreAni = nombreAni;
        GeneroAni = generoAni;
        CuidadosEspeciales = cuidadosEspeciales;
        AlimentoFavorito = alimentoFavorito;
        PesoAni = pesoAni;
        RazaAni = razaAni;
        FuerzaAni = fuerzaAni;
        VelocidadAni = velocidadAni;
        BuffAni = buffAni;
        DesBuffAni = desBuffAni;
        DebilidadAni = debilidadAni;
        ImagenAnim = imagenAnim;
        RutaImagen = rutaImagen;
        DescripcionAnim = descripcionAnim;
    }

    public Integer getIDAnimal() {
        return IDAnimal;
    }

    public void setIDAnimal(Integer IDAnimal) {
        this.IDAnimal = IDAnimal;
    }

    public String getNombreAni() {
        return NombreAni;
    }

    public void setNombreAni(String nombreAni) {
        NombreAni = nombreAni;
    }

    public String getGeneroAni() {
        return GeneroAni;
    }

    public void setGeneroAni(String generoAni) {
        GeneroAni = generoAni;
    }

    public String getCuidadosEspeciales() {
        return CuidadosEspeciales;
    }

    public void setCuidadosEspeciales(String cuidadosEspeciales) {
        CuidadosEspeciales = cuidadosEspeciales;
    }

    public String getAlimentoFavorito() {
        return AlimentoFavorito;
    }

    public void setAlimentoFavorito(String alimentoFavorito) {
        AlimentoFavorito = alimentoFavorito;
    }

    public Float getPesoAni() {
        return PesoAni;
    }

    public void setPesoAni(Float pesoAni) {
        PesoAni = pesoAni;
    }

    public String getRazaAni() {
        return RazaAni;
    }

    public void setRazaAni(String razaAni) {
        RazaAni = razaAni;
    }

    public Integer getFuerzaAni() {
        return FuerzaAni;
    }

    public void setFuerzaAni(Integer fuerzaAni) {
        FuerzaAni = fuerzaAni;
    }

    public Integer getVelocidadAni() {
        return VelocidadAni;
    }

    public void setVelocidadAni(Integer velocidadAni) {
        VelocidadAni = velocidadAni;
    }

    public Integer getBuffAni() {
        return BuffAni;
    }

    public void setBuffAni(Integer buffAni) {
        BuffAni = buffAni;
    }

    public String getDesBuffAni() {
        return DesBuffAni;
    }

    public void setDesBuffAni(String desBuffAni) {
        DesBuffAni = desBuffAni;
    }

    public String getDebilidadAni() {
        return DebilidadAni;
    }

    public void setDebilidadAni(String debilidadAni) {
        DebilidadAni = debilidadAni;
    }

    public Bitmap getImagenAnim() {
        return ImagenAnim;
    }

    public void setImagenAnim(Bitmap imagenAnim) {
        ImagenAnim = imagenAnim;
    }

    public String getRutaImagen() {
        return RutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        RutaImagen = rutaImagen;
    }

    public String getDescripcionAnim() {
        return DescripcionAnim;
    }

    public void setDescripcionAnim(String descripcionAnim) {
        DescripcionAnim = descripcionAnim;
    }

    @Override
    public String toString() {
        return "Animales{" +
                "IDAnimal=" + IDAnimal +
                ", NombreAni='" + NombreAni + '\'' +
                ", GeneroAni='" + GeneroAni + '\'' +
                ", CuidadosEspeciales='" + CuidadosEspeciales + '\'' +
                ", AlimentoFavorito='" + AlimentoFavorito + '\'' +
                ", PesoAni=" + PesoAni +
                ", RazaAni='" + RazaAni + '\'' +
                ", FuerzaAni=" + FuerzaAni +
                ", VelocidadAni=" + VelocidadAni +
                ", BuffAni=" + BuffAni +
                ", DesBuffAni='" + DesBuffAni + '\'' +
                ", DebilidadAni='" + DebilidadAni + '\'' +
                ", ImagenAnim=" + ImagenAnim +
                ", RutaImagen='" + RutaImagen + '\'' +
                ", DescripcionAnim='" + DescripcionAnim + '\'' +
                '}';
    }
}
