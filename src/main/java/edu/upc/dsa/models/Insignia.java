package edu.upc.dsa.models;

public class Insignia {

   String nombre;

   String imagen;

    public Insignia(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }
    public Insignia(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
