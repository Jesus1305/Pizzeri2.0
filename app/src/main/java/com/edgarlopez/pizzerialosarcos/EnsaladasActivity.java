package com.edgarlopez.pizzerialosarcos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EnsaladasActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names,detalle;
    TextView tensalada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensalada);
        setTitle("Ensaladas");
        listView=(ListView)findViewById(R.id.elistView);
        tensalada=(TextView) findViewById(R.id.tensaladaView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Ensalada Los Arcos");
        names.add("Ensalada de verduras");

        detalle = new ArrayList<String>();
        detalle.add("Ensalada de verduras con pechugade pollo a la plancha y crutones.");
        detalle.add("Lechuga, tomate, coliflor,pepino y zanahoria.");




        //adaptador de la forma visual
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        //enazar el adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(EnsaladasActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EnsaladasActivity.this, EdetallesActivity.class);
                tensalada.setText(names.get(position));
                String name = tensalada.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);
    }
}