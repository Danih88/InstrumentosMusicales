package com.danih.instrumentosmusicales;

import java.io.Serializable;

public class Instrumento implements Serializable {

    private String nombre;
    private String descripcion;
    private int imagen;


    public Instrumento(String nombre, String descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen= imagen;
    }


    public String getNombre() {

        return nombre;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public int getImagen() {

        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
