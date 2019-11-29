package com.example.segundoparcialsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.segundoparcialsqlite.Class.ConexionSQLiteHelper;
import com.example.segundoparcialsqlite.Class.Persona;
import com.example.segundoparcialsqlite.Class.Utilidades;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity {

    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Persona> listaPersonas;
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        listViewPersonas = (ListView) findViewById(R.id.ListaViewPersonas);
        conn =  new ConexionSQLiteHelper(this,"bd_persona",null,1);
        consultarListaPersonas();
    }

    private void consultarListaPersonas() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Persona persona = null;
        listaPersonas = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIO,null);
        while(cursor.moveToNext()){
            persona = new Persona();
            persona.setNombre(cursor.getString(0));
            persona.setApellido(cursor.getString(1));
            persona.setCarnet_Identidad(cursor.getString(2));
            persona.setLatitud(cursor.getString(3));
            persona.setLongitud(cursor.getString(4));


        }

    }
}
