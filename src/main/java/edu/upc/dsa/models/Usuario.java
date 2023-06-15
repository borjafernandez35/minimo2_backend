package edu.upc.dsa.models;

import edu.upc.dsa.models.dto.UsuarioTO;

public class Usuario {

    int id;
    String nombre;
    String correo;
    String password;
    //private List<Objeto> listaObjetosComprados = null;
    double dsacoins = 500;

    public Usuario() {

    }

    public Usuario (UsuarioTO usuarioTO){
        this.setId(id);
        this.setNombre(usuarioTO.getNombre());
        this.setCorreo(usuarioTO.getCorreo());
        this.setPassword(usuarioTO.getPassword());
        this.setDsacoins(500);
    }
    public Usuario(String correo, String password){
        this.setCorreo(correo);
        this.setPassword(password);
    }


  /*  public Usuario(String nombre, String apellido, String apellido2, String fecha, String correo, String password) {
        setNombre(nombre);
        setApellido(apellido);
        setApellido2(apellido2);
        setFecha(fecha);
        setCorreo(correo);
        setPassword(password);
        this.listaObjetosComprados = new ArrayList<>();
   }*/

    public Usuario(String nombre, String correo, String password) {
        setNombre(nombre);
        setCorreo(correo);
        setPassword(password);
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
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

/*    public List<Objeto> getListaObjetosComprados() {
        return listaObjetosComprados;
    }

    public void setListaObjetosComprados(List<Objeto> listaObjetosComprados) {
        this.listaObjetosComprados = listaObjetosComprados;
    }*/

    public double getDsacoins() {
        return dsacoins;
    }

    public void setDsacoins(double dsacoins) {
        this.dsacoins = dsacoins;
    }

}
