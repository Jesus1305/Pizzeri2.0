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

public class HamburgesaActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names,detalle;
    TextView thamburgesa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburgesa);

        setTitle("Hamburgesa");
        listView=(ListView)findViewById(R.id.hlistView);
        thamburgesa=(TextView) findViewById(R.id.hamburgesaView);

        //Datosa mostrar
        names = new ArrayList<String>();
        //List<String> names =new ArrayList<String>();
        names.add("Hamburgesa especial");
        names.add("hamburgesa combinada");
        names.add("Hamburgesa sensilla");
        names.add("hamburgesa doble");
        names.add("Hamburgesa de pollo");
        names.add("hamburgesa de pollo doble");
        names.add("Hamburgesa de filete");
        names.add("hot dog");
        names.add("Papas Francesas");

        detalle = new ArrayList<String>();
        detalle.add("Con jamon y tocino");
        detalle.add("De res y pollo");
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
                Toast.makeText(HamburgesaActivity.this,"clicked:  "+names.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(HamburgesaActivity.this, HdetallesActivity.class);
                thamburgesa.setText(names.get(position));
                String name = thamburgesa.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //enlazamos  con nuestr adaptador pernsoalisado (queda igual)
        Padapter padapter = new Padapter(this,R.layout.list_item,names,detalle);
        listView.setAdapter(padapter);
    }
}