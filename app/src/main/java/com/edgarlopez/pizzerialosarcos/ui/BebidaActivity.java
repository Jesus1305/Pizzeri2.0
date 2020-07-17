package com.edgarlopez.pizzerialosarcos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.edgarlopez.pizzerialosarcos.Padapter;
import com.edgarlopez.pizzerialosarcos.R;

import java.util.ArrayList;
import java.util.List;

public class BebidaActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names,detalle;
    TextView tbebida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebida);

        setTitle("Bebidas");

        listView=(ListView)findViewById(R.id.blistView);
        tbebida=(TextView) findViewById(R.id.tbebidaView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Refrescos (355 ml.)");
        names.add("Fuze tea (600 ml.)");
        names.add("Jugo de naranja (natural), Vaso");
        names.add("Juego de naranja (natural), Jarra");
        names.add("Agua purificada (600 ml.)");
        names.add("Limonada con agua natural, Vaso");
        names.add("Limonada con agua natural, Jarra");
        names.add("Limonada con agua mineral, Vaso");
        names.add("Limonada con agua mineral, Jarra");
        names.add("Cafe");
        names.add("Cappuccino");
        names.add("Chocolate");
        names.add("Licuado");
        names.add("Leche");

        detalle = new ArrayList<String>();
        detalle.add("Coca cola, sprite, fresca, sidral mundet, naranja, coca cola ligth o coca cola sin azucar");
        detalle.add(" ");
        detalle.add("355 ml.");
        detalle.add("1,597 ml.");
        detalle.add("");
        detalle.add("355 ml.");
        detalle.add("1,597 ml.");
        detalle.add("355 ml.");
        detalle.add("1,597 ml.");
        detalle.add("355 ml.");
        detalle.add("Vainilla (355 ml.)");
        detalle.add("Frio o caliente (355 ml.)");
        detalle.add("Nuez, platano o mixto (355 ml.)");
        detalle.add("Vaso (355 ml.)");



        //adaptador de la forma visual
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        //enazar el adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(BebidaActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BebidaActivity.this, BdetalleActivity.class);
                tbebida.setText(names.get(position));
                String name = tbebida.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);


    }
}