package com.edgarlopez.pizzerialosarcos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CarritoActivity extends AppCompatActivity {
Button agregar;
    EditText campoName, campoTamano, campoCantidades, campoExtra, campoComentarios, campoTotales,campoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        campoId=(EditText) findViewById(R.id.campoId);
        campoName = (EditText) findViewById(R.id.campoName);
        campoTamano = (EditText) findViewById(R.id.campoTamano);
        campoCantidades = (EditText) findViewById(R.id.campoCantidad);
        campoExtra = (EditText) findViewById(R.id.campoExtra);
        campoComentarios = (EditText) findViewById(R.id.campoComentario);
        campoTotales = (EditText) findViewById(R.id.campoTotales);


    }


public  void onClick (View view){



}




}