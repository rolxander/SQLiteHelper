package com.example.segundoparcialsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.segundoparcialsqlite.Class.ConexionSQLiteHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInsertar,btnActulizar,btnBuscar,btnMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConexionSQLiteHelper conn =  new ConexionSQLiteHelper(this,"bd_persona",null,1);
        //Instanciacion del boton
        btnInsertar =(Button) findViewById(R.id.btnInsertMain);
        btnActulizar=(Button) findViewById(R.id.btnActulizarMain);
        btnBuscar = (Button) findViewById(R.id.btnBuscarMain);
        btnMostrar= (Button) findViewById(R.id.btnMostrarMain);
        //Manejador de evento Click
        btnInsertar.setOnClickListener(this);
        btnActulizar.setOnClickListener(this);
        btnBuscar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInsertMain:{
                Intent intent = new Intent(this,Insert.class);
                startActivity(intent);
            };break;
            case R.id.btnActulizarMain:{
                Toast.makeText(getApplicationContext(),"Actualizar",Toast.LENGTH_SHORT).show();
            };break;
            case R.id.btnBuscarMain:{
                Intent intent = new Intent(this,Buscar.class);
                startActivity(intent);
            };break;
            case R.id.btnMostrarMain:{
                Toast.makeText(getApplicationContext(),"Mostrar",Toast.LENGTH_SHORT).show();
            };break;

        }
    }
}
