package com.example.segundoparcialsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.segundoparcialsqlite.Class.ConexionSQLiteHelper;
import com.example.segundoparcialsqlite.Class.Utilidades;

public class Insert extends AppCompatActivity implements View.OnClickListener{
    Button btnGuardar;
    EditText campoNombre,campoApellido,campoCi,campoLogitud,campoLatitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        campoNombre = (EditText) findViewById(R.id.txtMainNombre);
        campoApellido = (EditText) findViewById(R.id.txtMainApellido);
        campoCi = (EditText) findViewById(R.id.txtMainCI);
        campoLogitud = (EditText) findViewById(R.id.txtMainLatitud);
        campoLatitud = (EditText) findViewById(R.id.txtMainLatitud);
        btnGuardar = (Button) findViewById(R.id.btnGuardarInsert);
        btnGuardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardarInsert: {
                Registrar();
            }
        }
    }
    public void Registrar(){
        ConexionSQLiteHelper conn =  new ConexionSQLiteHelper(this,"bd_persona",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDO,campoApellido.getText().toString());
        values.put(Utilidades.CAMPO_CU,campoCi.getText().toString());
        values.put(Utilidades.CAMPO_LONGITUD,campoLogitud.getText().toString());
        values.put(Utilidades.CAMPO_LATITUD,campoLatitud.getText().toString());
        Long idResutante = db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_CU,values);
        Toast.makeText(getApplicationContext(), "id Registro"+idResutante, Toast.LENGTH_SHORT).show();
        db.close();

    }
}
