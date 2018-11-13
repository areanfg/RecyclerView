package com.example.a988.seccion06;

import android.graphics.drawable.Drawable;

public class Contacto {

    private String nombre;
    private int telefono;
    private int foto;

    public Contacto(String nombre, int telefono, int foto){
        this.nombre = nombre;
        this.telefono = telefono;
        this.foto = foto;
    }

    public String getNombre(){
        return nombre;
    }
    public int getTelefono(){
        return telefono;
    }
    public int getFoto(){
        return foto;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    public void setFoto(int foto){
        this.foto = foto;
    }

}
