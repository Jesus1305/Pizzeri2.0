package com.edgarlopez.pizzerialosarcos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edgarlopez.pizzerialosarcos.ui.MenuNavigationActivity;

public class PodetalleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText pocomentarios;
    String poselect, pocantidad, posub;

    private TextView poextraView;
    private TextView ponames;
    private TextView pototal;
    private TextView potot;
    private TextView posubtotal;
    private TextView pocantidades;
    Spinner pospinner, pospinner2;
    Button pobtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podetalle);

        setTitle("Postre");

        pocomentarios = (EditText) findViewById(R.id.pocomentariosText);
        posubtotal = (TextView) findViewById(R.id.posubtotalView);
        pototal = (TextView) findViewById(R.id.pofinalView);
        posub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        pototal.setText(posub);
        //  poextraView = (TextView) findViewById(R.id.pextraView);
        porecibirDatos();
        pocargarTotal();
        ArrayAdapter<CharSequence> adapter;
        ArrayAdapter<CharSequence> adapter2;
        switch (ponames.getText().toString()) {
            case "Pastel de chocolate con nieve":
            case "Pay de queso con nieve":
            case "Pay de nuez con nieve":
                pospinner = findViewById(R.id.poingredienteSpiner);

                adapter = ArrayAdapter.createFromResource(this, R.array.posabor, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pospinner.setAdapter(adapter);
                pospinner.setOnItemSelectedListener(this);


                pospinner2 = findViewById(R.id.pocantidadspinner);
                /// hspinner2.setVisibility(View.INVISIBLE);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pospinner2.setAdapter(adapter2);
                pospinner2.setOnItemSelectedListener(this);
                break;

            case "Pastel de chocolate":
            case "Pay de queso":
            case "Pay de nuez":

                pospinner = findViewById(R.id.poingredienteSpiner);
                pospinner.setVisibility(View.INVISIBLE);

                TextView poextraView = (TextView) findViewById(R.id.poextra0View);
                poextraView.setText("");
                TextView sabor = (TextView) findViewById(R.id.poingredienteextraView);
                sabor.setVisibility(View.INVISIBLE);
                // poextraView.setVisibility(View.INVISIBLE);
                pospinner2 = findViewById(R.id.pocantidadspinner);
                /// hspinner2.setVisibility(View.INVISIBLE);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pospinner2.setAdapter(adapter2);
                pospinner2.setOnItemSelectedListener(this);
                /**/

                break;

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.pocantidadspinner:
                int subto, val, sum;
                String s, to;

                // select = parent.getItemAtPosition(position).toString();

                pocantidad = parent.getItemAtPosition(position).toString();
                // Toast.makeText(this, cantidad, Toast.LENGTH_LONG).show();

                pocantidades = (TextView) findViewById(R.id.pocantidadesView);
                pocantidades.setText(pocantidad);

                pototal = (TextView) findViewById(R.id.pofinalView);
                potot = (TextView) findViewById(R.id.posubtotalView);
                subto = Integer.parseInt(potot.getText().toString());
                //val=10;
                val = Integer.parseInt(pocantidades.getText().toString());
                sum = subto * val;
                s = String.valueOf(sum);
                pototal.setText(s);

            case R.id.poingredienteSpiner:
                poselect = parent.getItemAtPosition(position).toString();
                poextraView = (TextView) findViewById(R.id.poextra0View);
                poextraView.setText(poselect);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void porecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        ponames = (TextView) findViewById(R.id.ponombre);
        ponames.setText(name);

    }
    private void pocargarTotal() {

        switch (ponames.getText().toString()){

            case "Pastel de chocolate":
                posubtotal = (TextView) findViewById(R.id.posubtotalView);
                posubtotal.setText("25");
                break;

            case "Pastel de chocolate con nieve":
                posubtotal = (TextView) findViewById(R.id.posubtotalView);
                posubtotal.setText("35");
                break;
            case"Pay de queso":
                posubtotal = (TextView) findViewById(R.id.posubtotalView);
                posubtotal.setText("22");
                break;
            case "Pay de queso con nieve":
                posubtotal = (TextView) findViewById(R.id.posubtotalView);
                posubtotal.setText("32");
                break;
            case "Pay de nuez":
                posubtotal = (TextView) findViewById(R.id.posubtotalView);
                posubtotal.setText("20");
                break;
            case "Pay de nuez con nieve":
                posubtotal = (TextView) findViewById(R.id.posubtotalView);
                posubtotal.setText("30");
                break;



        }

    }
    public void poagregar(View t) {
        Toast.makeText(this, "no jala", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(PodetalleActivity.this, MenuNavigationActivity.class);


        String name = ponames.getText().toString();
        String cantidad=pocantidades.getText().toString();
        String tamano = poextraView.getText().toString();
        String extra = "";
        String extra2 =  "";
        String extra3 =  "";
        String comentario =pocomentarios.getText().toString();
        String totales = pototal.getText().toString();
        Toast.makeText(this, totales, Toast.LENGTH_LONG).show();

        intent.putExtra("name", name);
        intent.putExtra("tamano", tamano);
        intent.putExtra("cantidad", cantidad);
        intent.putExtra("extra", extra);
        intent.putExtra("extra2", extra2);
        intent.putExtra("extra3", extra3);
        intent.putExtra("comentario", comentario);
        intent.putExtra("totales",totales);

        startActivity(intent);

    }

}