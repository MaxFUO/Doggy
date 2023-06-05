package com.example.drawer.Pojo;

public class Misiones {
    private int idUsuario;
    private int idMision;
    private String descripcion;
    private String estado;

    public Misiones() {
    }

    public Misiones(int idUsuario, int idMision, String descripcion, String estado) {
        this.idUsuario = idUsuario;
        this.idMision = idMision;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMision() {
        return idMision;
    }

    public void setIdMision(int idMision) {
        this.idMision = idMision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
