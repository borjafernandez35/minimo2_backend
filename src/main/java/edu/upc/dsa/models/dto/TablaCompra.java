package edu.upc.dsa.models.dto;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import io.swagger.models.auth.In;

public class TablaCompra {

    int id;
    String correo;

    String nombreobjeto;

    public TablaCompra(){}

    public TablaCompra(String correo, String nombreobjeto){
        this.setCorreo(correo);
        this.setNombreobjeto(nombreobjeto);
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

    public String getNombreobjeto() {
        return nombreobjeto;
    }

    public void setNombreobjeto(String nombreobjeto) {
        this.nombreobjeto = nombreobjeto;
    }
}
