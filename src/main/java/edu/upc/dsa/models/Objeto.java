package edu.upc.dsa.models;

public class Objeto {

    int id;
    String nombre;

    String descripcion;

    double precio;

    String fotoimagen;




    public Objeto() {
    }

    public Objeto( String nombre, String descripcion, double precio, String fotoimagen){
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setFotoimagen(fotoimagen);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFotoimagen() {
        return fotoimagen;
    }

    public void setFotoimagen(String fotoimagen) {
        this.fotoimagen = fotoimagen;
    }
}
