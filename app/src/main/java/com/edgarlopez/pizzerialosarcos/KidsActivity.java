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

public class KidsActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> names,detalle;
    TextView tkids;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);

        setTitle("Kids");

        listView=(ListView)findViewById(R.id.klistView);
        tkids=(TextView) findViewById(R.id.tkidsView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Nuggets");
        names.add("Hot dog");
        names.add("Sandwich");
        names.add("Hamburgesa Steak");


        detalle = new ArrayList<String>();
        detalle.add("");
        detalle.add("");
        detalle.add("");
        detalle.add("");



        //adaptador de la forma visual
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        //enazar el adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(KidsActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(KidsActivity.this, KdetalleActivity.class);
                tkids.setText(names.get(position));
                String name = tkids.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);

    }
}