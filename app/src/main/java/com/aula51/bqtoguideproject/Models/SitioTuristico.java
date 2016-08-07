package com.aula51.bqtoguideproject.Models;

/**
 * Created by Rocketron on 07-08-2016.
 */
public class SitioTuristico {
    String nombre;

    public SitioTuristico(){
    }

    public SitioTuristico(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
