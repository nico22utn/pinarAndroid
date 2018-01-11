package com.nicolas.pinar.model;

import java.util.List;

/**
 * Created by User on 10/01/2018.
 */

public class DTOPantalla {
    public String documento;
    public List<String> informes;
    public byte[] foto;
    public DTOPantalla(){

    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<String> getInformes() {
        return informes;
    }

    public void setInformes(List<String> informes) {
        this.informes = informes;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
