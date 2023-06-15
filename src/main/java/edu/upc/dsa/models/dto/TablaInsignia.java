package edu.upc.dsa.models.dto;

public class TablaInsignia {
    int id;
    String correo;

    String nombreinsignia;

    int cantidad;


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TablaInsignia(int id, String correo, String nombreinsignia, int cantidad) {
        this.id = id;
        this.correo = correo;
        this.nombreinsignia = nombreinsignia;
        this.cantidad=cantidad;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreinsignia() {
        return nombreinsignia;
    }

    public void setNombreinsignia(String nombreinsignia) {
        this.nombreinsignia = nombreinsignia;
    }

    public TablaInsignia(){}
}
