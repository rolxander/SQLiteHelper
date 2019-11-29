package com.example.segundoparcialsqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.segundoparcialsqlite.Class.ConexionSQLiteHelper;
import com.example.segundoparcialsqlite.Class.Utilidades;

public class Buscar extends AppCompatActivity implements View.OnClickListener{

    EditText campoNombre,campoApellido,campoCI,campoLatitud,campoLongitud,campoCIBuscador;
    Button btnActualizar,btnEliminar,btnCIBuscar;
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        conn =  new ConexionSQLiteHelper(getApplicationContext(),"bd_persona",null,1);
        campoNombre = (EditText) findViewById(R.id.txtNombreBuscar);
        campoApellido = (EditText) findViewById(R.id.txtApellidoBuscar);
        campoCI = (EditText) findViewById(R.id.txtCIBuscar);
        campoLatitud = (EditText) findViewById(R.id.txtLatitudBuscar);
        campoLongitud = (EditText) findViewById(R.id.txtLongitudBuscar);
        campoCIBuscador = (EditText) findViewById(R.id.txtCIBuscadorBuscar);
        btnActualizar = (Button) findViewById(R.id.btnActulizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnCIBuscar = (Button) findViewById(R.id.btnCIBuscadorBuscar);
        btnCIBuscar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnActulizar:{
                String[] args= {campoCI.getText().toString()};
                ContentValues content = new ContentValues();
                content.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
                content.put(Utilidades.CAMPO_APELLIDO,campoApellido.getText().toString());
                content.put(Utilidades.CAMPO_CU,campoCI.getText().toString());
                content.put(Utilidades.CAMPO_LATITUD,campoLatitud.getText().toString());
                content.put(Utilidades.CAMPO_LONGITUD,campoLongitud.getText().toString());
                SQLiteDatabase db = conn.getWritableDatabase();
                db.update(Utilidades.TABLA_USUARIO,content,Utilidades.CAMPO_CU+"=?",args);
                Toast.makeText(getApplicationContext(),"La tabla se actualizo ", Toast.LENGTH_SHORT).show();
            };break;
            case R.id.btnEliminar:{
                String[] argumento= {campoCI.getText().toString()};
                SQLiteDatabase db = conn.getWritableDatabase();
                db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_CU+" = ?",argumento);
                db.close();
                limpiar();
                Toast.makeText(getApplicationContext(),"Se elimino el archibo", Toast.LENGTH_SHORT).show();
            };break;
            case R.id.btnCIBuscadorBuscar:{
                //Toast.makeText(getApplicationContext(),"Hiciste click buscar",Toast.LENGTH_SHORT).show();
                consultar();
            };break;
        }
    }

    public void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros= {campoCIBuscador.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_APELLIDO,Utilidades.CAMPO_CU,Utilidades.CAMPO_LONGITUD,Utilidades.CAMPO_LATITUD};
        try {
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_CU+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            String nombre = cursor.getString(0);
            String apellido = cursor.getString(1);
            String ci = cursor.getString(2);
            String longitud = cursor.getString(4);
            String latitud = cursor.getString(3);
            campoNombre.setText(nombre);
            campoApellido.setText(apellido);
            campoCI.setText(ci);
            campoLatitud.setText(latitud);
            campoLongitud.setText(longitud);
            cursor.close();
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }
        
    }

    private void limpiar() {
        campoNombre.setText("");
        campoApellido.setText("");
        campoCI.setText("");
        campoLatitud.setText("");
        campoLatitud.setText("");
    }
}
