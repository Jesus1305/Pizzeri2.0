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

import com.edgarlopez.pizzerialosarcos.ui.DdetalleActivity;

import java.util.ArrayList;
import java.util.List;

public class DesayunoActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> names,detalle;
    TextView tdesayuno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desayuno);

        setTitle("desayuno");
        listView=(ListView)findViewById(R.id.dlistView);
        tdesayuno=(TextView) findViewById(R.id.tdesayunoView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Desayuno Americano");
        names.add("Desayuno 'Los Arcos'");
        names.add("Desayuno especial");
        names.add("Huevos divorciados");
        names.add("Huevos rancheros");
        names.add("Huevos a la mexicana");
        names.add("Huevos con chilaquiles");
        names.add("Desayuno norteno");
        names.add("Montadas (rajas o verdes)");
        names.add("Huevos");
        names.add("Machaca co huevo");
        names.add("Omelette 'Los Arcos'");
        names.add("Omelette Jamon y queso");
        names.add("Omelette con rajas");
        names.add("Omelette Champinones y queso ");
        names.add("Hot cakes 'Mickey Mouse'");
        names.add("'Triple combo' Hot cakes");
        names.add("'Mini hot cakes'");
        names.add("Hot cakes");
        names.add("Sandwich 'BLT plus'");
        names.add("Sandwich de pollo");
        names.add("Avena");


        detalle = new ArrayList<String>();

        detalle.add("Su eleccion de hevos revueltos o estrellados, dos hot cakes con mantequilla y dos tiras de tocino.");
        detalle.add("Huevos revueltos o estrellados, rajas con crema, fajitas de pollo y torta de papa.");
        detalle.add("Huevos revueltos o estrellados chuleta ahumada, torta de papa y frijoles refritos.");
        detalle.add("Dos huevos estrellados, uno banado con una rica salsa verde y el otro con salsa roja y chilaquiles.");
        detalle.add("Dos huevos estrellados banados en una rica salsa, sobre tortilla ligeramente fritos.");
        detalle.add("Huevos revueltos con chile jalapeno, tomate y cebolla. Servidos con tocino y jamon.");
        detalle.add("Dos huevos (revuetos o estrellados) y chilaquiles (ROJOS O VERDES).");
        detalle.add("Huevos revueltos o estrellados, fajitas de arrachera y torta de papa.");
        detalle.add("Dos huevos estrellados encima de tres exquisitas enchiladas(queso, picadillo o pollo) Servidas con torta de papa.");
        detalle.add("Dos huevos revueltos o estrellados. Con tocino, jamon o chorizo");
        detalle.add("");
        detalle.add("Camarones, tocino y queso.");
        detalle.add("");
        detalle.add("");
        detalle.add("");
        detalle.add("Concienta a sus peuqenos con la nueva version de hot cakes con figura de Mickey");
        detalle.add("Tres exquisitos hotcakes (uno con nuez, otro con pasas y otro con platano).");
        detalle.add("Orden de pequenos hot cakes con riquisimas chispas de chocolate.");
        detalle.add("");
        detalle.add("Delicioso sandwich con tocino, lechuga,tomate y jamon");
        detalle.add("Riquisimo sandwich de pollo con tocino, lechuga,tomate y jamon.");
        detalle.add("");

        //adaptador de la forma visual
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        //enazar el adaptador
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(DesayunoActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DesayunoActivity.this, DdetalleActivity.class);
                tdesayuno.setText(names.get(position));
                String name = tdesayuno.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);
    }
}