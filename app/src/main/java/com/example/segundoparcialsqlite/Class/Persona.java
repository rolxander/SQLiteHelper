package com.example.segundoparcialsqlite.Class;

public class Persona {
    private String nombre;
    private String apellido;
    private String carnet_Identidad;
    private String latitud;
    private String longitud;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String carnet_Identidad, String latitud, String longitud) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet_Identidad = carnet_Identidad;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCarnet_Identidad() {
        return carnet_Identidad;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCarnet_Identidad(String carnet_Identidad) {
        this.carnet_Identidad = carnet_Identidad;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
