package com.example.segundoparcialsqlite.Class;

public class Utilidades {

    //Constantes Campos tabla usuario
    public static final String TABLA_USUARIO = "PERSONA";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDO = "apellido";
    public static final String CAMPO_CU = "carnet_identidad";
    public static final String CAMPO_LATITUD = "latitud";
    public static final String CAMPO_LONGITUD = "longitud";
    public static final String CREAR_TABLA_PERSONA = "CREATE TABLE "+TABLA_USUARIO+"("+CAMPO_NOMBRE+" varchar(30),"+CAMPO_APELLIDO+" varchar(30), "+CAMPO_CU+" varchar(30), "+CAMPO_LATITUD+" varchar(30), "+CAMPO_LONGITUD+" varchar(30))";

}
