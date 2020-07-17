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

public class PizzaActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> names,detalle;
    TextView tpizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        listView=(ListView)findViewById(R.id.listView);
        tpizza=(TextView) findViewById(R.id.tpizzaView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Pizza Los arcos");
        names.add("Especial");
        names.add("Vegetariana");
        names.add("Mexicana");
        names.add("Jamon con pina");
        names.add("Peperoni");
        names.add("Camarones");
        names.add("Salami");
        names.add("Jamon de pavo");
        names.add("Picadillo con chile");
        names.add("Salchicha de pavo con champinones");

        detalle = new ArrayList<String>();
        detalle.add("Jamon, salami, jamon de pavo y pimiento morron.");
        detalle.add("Jamon, salami champinones, topping especial y pimiento morron");
        detalle.add("Champinones, pimiento morron, cebolla tomate y pina");
        detalle.add("Fijoles, peperoni y jalapenios");
        detalle.add("");
        detalle.add("");
        detalle.add("");
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
                Toast.makeText(PizzaActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PizzaActivity.this, PdetallesActivity.class);
                tpizza.setText(names.get(position));
                String name = tpizza.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);


    }
}