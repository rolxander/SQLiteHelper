package com.example.segundoparcialsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);
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
            listaPersonas.add(persona);
        }
        obtenerLista();
        cursor.close();
        db.close();

    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<>();
        for(int i = 0; i<listaPersonas.size();i++){
            listaInformacion.add(listaPersonas.get(i).getNombre() + " - " +listaPersonas.get(i).getCarnet_Identidad() );
        }

    }
}
