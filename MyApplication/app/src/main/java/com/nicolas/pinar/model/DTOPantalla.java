package com.nicolas.pinar.model;

import java.util.List;

/**
 * Created by User on 10/01/2018.
 */

public class DTOPantalla {

    private String dni;
    private List<String> informes = null;
    private Object foto;

    /**
     * No args constructor for use in serialization
     *
     */
    public DTOPantalla() {
    }

    /**
     *
     * @param informes
     * @param foto
     * @param dni
     */
    public DTOPantalla(String dni, List<String> informes, Object foto) {
        super();
        this.dni = dni;
        this.informes = informes;
        this.foto = foto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<String> getInformes() {
        return informes;
    }

    public void setInformes(List<String> informes) {
        this.informes = informes;
    }

    public Object getFoto() {
        return foto;
    }

    public void setFoto(Object foto) {
        this.foto = foto;
    }

}
