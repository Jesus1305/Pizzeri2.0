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

public class PlatillosActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> names,detalle;
    TextView tplatillo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platillos);

        setTitle("Platillos");
        listView=(ListView)findViewById(R.id.plistView);
        tplatillo=(TextView) findViewById(R.id.tplatilloView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Fajitas de arrachera");
        names.add("Fajitas de pollo");
        names.add("Pechuga empanizada");
        names.add("Pechuga al chipotle");
        names.add("Espagueti");
        names.add("Sopa de tortilla");
        names.add("Enchiladas 'los arcos' (4)");
        names.add("Enchiladas de colorado (4)");
        names.add("Enchiladas en salsa verde (4)");
        names.add("Tacos de picadillo (4)");
        names.add("Flautas (5)");


        detalle = new ArrayList<String>();
        detalle.add("Acompanadas de verdura y frijoles ");
        detalle.add(" ");
        detalle.add("Acompanadas de papas a la francesa, rajas con crema, frijolitos y  porcion d verduras");
        detalle.add("Acompanadas de arroz, papas a la francesa y porcion de verduras");
        detalle.add("");
        detalle.add("Servida con aguacate y queso ");
        detalle.add("Con salsa de la casa, rellenas de picadillo, pollo o queso");
        detalle.add("Picadillo pollo o queso");
        detalle.add("Picadillo pollo o queso");
        detalle.add("");
        detalle.add("Acompanadas de verduras, rellenas de carne desebrada");


        //adaptador de la forma visual
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        //enazar el adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(PlatillosActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PlatillosActivity.this, PLdetallesActivity.class);
                tplatillo.setText(names.get(position));
                String name = tplatillo.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);
    }
}