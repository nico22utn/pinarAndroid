package com.nicolas.pinar.model;

/**
 * Created by Nicolas on 15/4/2018.
 */

public class ListInforme {
    private String informe;
    private String fotoInforme;
    private Medico medico;

    public ListInforme() {
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public String getFotoInforme() {
        return fotoInforme;
    }

    public void setFotoInforme(String fotoInforme) {
        this.fotoInforme = fotoInforme;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
