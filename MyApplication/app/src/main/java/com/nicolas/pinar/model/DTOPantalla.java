package com.nicolas.pinar.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10/01/2018.
 */

public class DTOPantalla {
    private String nombrePaciente;
    private String dniPaciente;
    private String fotoPaciente;
    private List<ListInforme> listInformes= null;

    public DTOPantalla(){

    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getFotoPaciente() {
        return fotoPaciente;
    }

    public void setFotoPaciente(String fotoPaciente) {
        this.fotoPaciente = fotoPaciente;
    }

    public List<ListInforme> getListInformes() {
        return listInformes;
    }

    public void setListInformes(List<ListInforme> listInformes) {
        this.listInformes = listInformes;
    }
}
