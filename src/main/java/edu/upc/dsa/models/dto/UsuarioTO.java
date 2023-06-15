package edu.upc.dsa.models.dto;

import edu.upc.dsa.models.Objeto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTO {

    String nombre;
    String correo;
    String password;

    public UsuarioTO() {

    }

    public UsuarioTO(String correo, String password){
        this.setCorreo(correo);
        this.setPassword(password);
    }


    public UsuarioTO(String nombre, String correo, String password) {
        setNombre(nombre);
        setCorreo(correo);
        setPassword(password);
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

}
