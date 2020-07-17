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

import com.edgarlopez.pizzerialosarcos.ui.MdetallesActivity;

import java.util.ArrayList;
import java.util.List;

public class MariscoActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> names,detalle;
    TextView tmarisco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marisco);

        setTitle("mariscos");

        listView=(ListView)findViewById(R.id.mlistview);
        tmarisco=(TextView) findViewById(R.id.tmariscoView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Coctel de camaron (Grande)");
        names.add("Coctel de camaron (chico)");
        names.add("Filete empanizado (grande)");
        names.add("Filete empanizado (chico)");
        names.add("Camarones Rancheros");
        names.add("Filete a la veracruzana");
        names.add("Filete en chipotle");

        detalle = new ArrayList<String>();
        detalle.add(" ");
        detalle.add(" ");
        detalle.add("Acompanado de arroz y porcion de verduras");
        detalle.add("Acompanado de arroz y porcion de verduras");
        detalle.add("");
        detalle.add("Acompanado de caldo de verduras ");
        detalle.add("Filete empanizado banado en crema de chipotle, apompanado de arroz y porcion de verduras");


        //adaptador de la forma visual
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        //enazar el adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MariscoActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MariscoActivity.this, MdetallesActivity.class);
                tmarisco.setText(names.get(position));
                String name = tmarisco.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);


    }
}