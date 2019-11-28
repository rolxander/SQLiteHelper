package com.example.segundoparcialsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Buscar extends AppCompatActivity implements View.OnClickListener{

    EditText campoNombre,campoApellido,campoCI,campoLatitud,campoLongitud;
    Button btnActualizar,btnEliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        campoNombre = (EditText) findViewById(R.id.txtNombreBuscar);
        campoApellido = (EditText) findViewById(R.id.txtNombreBuscar);
        campoCI = (EditText) findViewById(R.id.txtNombreBuscar);
        campoLatitud = (EditText) findViewById(R.id.txtNombreBuscar);
        campoLongitud = (EditText) findViewById(R.id.txtNombreBuscar);
        btnActualizar = (Button) findViewById(R.id.btnActulizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnActulizar:{
                Toast.makeText(getApplicationContext(),"Hiciste click en el boton Actlizar ", Toast.LENGTH_SHORT).show();
            }
            case R.id.btnEliminar:{
                Toast.makeText(getApplicationContext(),"Hiciste click en el boton Eliminar", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
