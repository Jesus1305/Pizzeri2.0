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

public class NieveActivity extends AppCompatActivity {


    private ListView listView;
    private List<String> names,detalle;
    TextView tnieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieve);
        setTitle("Nieves y Malteadas");

        listView=(ListView)findViewById(R.id.nlistView);
        tnieve=(TextView) findViewById(R.id.tnieveView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Malteadas");
        names.add("Nieve chica (118 ml.)");
        names.add("Nieve mediana (236 ml.)");
        names.add("Nieve grande (355 ml.)");

        detalle = new ArrayList<String>();
        detalle.add("(473 ml.)");
        detalle.add(" ");
        detalle.add(" ");
        detalle.add(" ");



        //adaptador de la forma visual
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        //enazar el adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(NieveActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NieveActivity.this, NdetalleActivity.class);
                tnieve.setText(names.get(position));
                String name = tnieve.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);
    }
}