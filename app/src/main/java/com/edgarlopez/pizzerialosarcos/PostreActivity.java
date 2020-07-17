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

public class PostreActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names,detalle;
    TextView tpostre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postre);

        setTitle("Postres");

        listView=(ListView)findViewById(R.id.polistView);
        tpostre=(TextView) findViewById(R.id.tpostreView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Pastel de chocolate");
        names.add("Pastel de chocolate con nieve");
        names.add("Pay de queso");
        names.add("Pay de queso con nieve");
        names.add("Pay de nuez");
        names.add("Pay de nuez con nieve");


        detalle = new ArrayList<String>();
        detalle.add(" ");
        detalle.add(" ");
        detalle.add(" ");
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
                Toast.makeText(PostreActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PostreActivity.this, PodetalleActivity.class);
                tpostre.setText(names.get(position));
                String name = tpostre.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);
    }
}