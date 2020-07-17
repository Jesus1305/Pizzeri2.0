package com.edgarlopez.pizzerialosarcos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edgarlopez.pizzerialosarcos.R;

public class MdetallesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText mcomentarios;
    String mselect,mcantidad,msub;

    private TextView mextraView;
    private TextView mextra2View;
    private TextView mextra3View;
    private TextView mnames;
    private TextView mtotal;
    private TextView mtot;
    private TextView msubtotal;
    private TextView mcantidades;
    Spinner mspinner,mspinner2;
    Button mbtn;

    ImageButton meliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdetalles);
        setTitle("Mariscos");

        mcomentarios = (EditText) findViewById(R.id.mcomentariosText);

        msubtotal = (TextView) findViewById(R.id.msubtotalView);
        mtotal = (TextView) findViewById(R.id.mfinalView);
        msub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        mtotal.setText(msub);
        meliminar=(ImageButton) findViewById(R.id.meliminarButton);
        meliminar.setVisibility(View.INVISIBLE);
        mextraView = (TextView) findViewById(R.id.mextraView);
        mextra2View = (TextView) findViewById(R.id.mextra2View);
        mextra3View = (TextView) findViewById(R.id.mextra3View);
        TextView extra0View = (TextView) findViewById(R.id.extra0View);
        //meliminar.setVisibility(View.INVISIBLE);
        mrecibirDatos();
        mcargarTotal();
        //meliminar=(ImageButton) findViewById(R.id.meliminarButton);
        //meliminar.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter;
        ArrayAdapter<CharSequence> adapter2;
        switch (mnames.getText().toString()) {


            case "Coctel de camaron (Grande)":
            case "Coctel de camaron (chico)":

                mspinner = findViewById(R.id.mingredienteSpiner);
                // hspinner.setVisibility(View.INVISIBLE);
                adapter = ArrayAdapter.createFromResource(this, R.array.mextras, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mspinner.setAdapter(adapter);
                mspinner.setOnItemSelectedListener(this);
                //spinner.setOnItemClickListener(multiplicar());

                mspinner2 = findViewById(R.id.mcantidadspinner);
                /// hspinner2.setVisibility(View.INVISIBLE);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mspinner2.setAdapter(adapter2);
                mspinner2.setOnItemSelectedListener(this);

                Toast.makeText(this, "baras",Toast.LENGTH_LONG).show();
                break;

            case "Filete empanizado (grande)":
            case "Filete empanizado (chico)":
            case "Camarones Rancheros":
            case "Filete a la veracruzana":
            case "Filete en chipotle":
                Toast.makeText(this, "caros",Toast.LENGTH_LONG).show();
                mspinner = findViewById(R.id.mingredienteSpiner);
                // hspinner.setVisibility(View.INVISIBLE);
                adapter = ArrayAdapter.createFromResource(this, R.array.mextras2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mspinner.setAdapter(adapter);
                mspinner.setOnItemSelectedListener(this);
                //spinner.setOnItemClickListener(multiplicar());

                mspinner2 = findViewById(R.id.mcantidadspinner);
                /// hspinner2.setVisibility(View.INVISIBLE);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mspinner2.setAdapter(adapter2);

                break;

        }



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.mcantidadspinner:
                int subto, val, sum;
                String s, to;

                mextraView = (TextView) findViewById(R.id.mextraView);
                mextra2View = (TextView) findViewById(R.id.mextra2View);
                mextra3View = (TextView) findViewById(R.id.mextra3View);
                mextraView.setText("");
                mextra2View.setText("");
                mextra3View.setText("");
                mcantidad = parent.getItemAtPosition(position).toString();


                mcantidades = (TextView) findViewById(R.id.mcantidadesView);
                mcantidades.setText(mcantidad);

                mtotal = (TextView) findViewById(R.id.mfinalView);
                mtot = (TextView) findViewById(R.id.msubtotalView);
                subto = Integer.parseInt(mtot.getText().toString());

                val = Integer.parseInt(mcantidades.getText().toString());
                sum = subto * val;
                s = String.valueOf(sum);
                mtotal.setText(s);



                break;
            case R.id.mingredienteSpiner:
                mselect = parent.getItemAtPosition(position).toString();
                mextraView = (TextView) findViewById(R.id.mextraView);
                mextra2View = (TextView) findViewById(R.id.mextra2View);
                mextra3View = (TextView) findViewById(R.id.mextra3View);
                //hextra0View = (TextView) findViewById(R.id.hextra0View);


                if (mextraView.getText().toString().isEmpty())
                {
                    msumaingredientes();
                    mextraView.setText(mselect);
                    meliminar.setVisibility(View.VISIBLE);

                }
                else
                {
                    if (mextra2View.getText().toString().isEmpty())
                    {
                        msumaingredientes();
                        mextra2View.setText(mselect);
                    }
                    else
                    {
                        if (mextra3View.getText().toString().isEmpty())
                        {
                            msumaingredientes();
                            mextra3View.setText(mselect);
                        }
                        else
                        {
                            Toast.makeText(this, "Solo puedes tener 3 ingredientes extra", Toast.LENGTH_LONG).show();

                        }
                    }


                }

                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void msumaingredientes() {
        int subtotal,valor,suma,h;
        String s;
        switch (mselect){

            case "Camarones ($25)":
                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotal = Integer.parseInt(mtotal.getText().toString());
                valor=25;
                h = Integer.parseInt(mcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Pan ($5)":

                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotal = Integer.parseInt(mtotal.getText().toString());
                valor=5;
                h = Integer.parseInt(mcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Aguacate ($8)":

                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotal = Integer.parseInt(mtotal.getText().toString());
                valor=8;
                h = Integer.parseInt(mcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Arroz ($15)":


                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotal = Integer.parseInt(mtotal.getText().toString());
                valor=15;
                h = Integer.parseInt(mcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Papas francesas ($11)":


                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotal = Integer.parseInt(mtotal.getText().toString());
                valor=11;
                h = Integer.parseInt(mcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Frijoles ($10)":
            case "Verdura ($10)":

                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotal = Integer.parseInt(mtotal.getText().toString());
                valor=10;
                h = Integer.parseInt(mcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;


        }
    }
    private void mrecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        mnames = (TextView) findViewById(R.id.mnombre);
        mnames.setText(name);

    }
    private void mcargarTotal() {

        switch (mnames.getText().toString()){

            case "Coctel de camaron (Grande)":
            case "Camarones Rancheros":
                msubtotal = (TextView) findViewById(R.id.msubtotalView);
                msubtotal.setText("70");
                break;

            case "Coctel de camaron (chico)":

                msubtotal = (TextView) findViewById(R.id.msubtotalView);
                msubtotal.setText("52");

                break;

            case "Filete empanizado (grande)":

                msubtotal = (TextView) findViewById(R.id.msubtotalView);
                msubtotal.setText("72");
                break;


            case "Filete a la veracruzana":
                msubtotal = (TextView) findViewById(R.id.msubtotalView);
                msubtotal.setText("68");

                break;
            case "Filete en chipotle":
                msubtotal = (TextView) findViewById(R.id.msubtotalView);
                msubtotal.setText("75");
                break;

            case "Filete empanizado (chico)":
                msubtotal = (TextView) findViewById(R.id.msubtotalView);
                msubtotal.setText("48");
                break;
        }

    }
    public void meliminar(View t) {
        Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        if (!mextra3View.getText().toString().isEmpty())
        {
            mrestaingredientes();
            mextra3View.setText("");
            //spinner.setSelection(0);
        }
        else
        {
            if (!mextra2View.getText().toString().isEmpty())
            {

                mrestaingredientes();
                mextra2View.setText("");
                //spinner.setSelection(0);
            }
            else
            {
                if (!mextraView.getText().toString().isEmpty())
                {
                    mrestaingredientes();
                    mextraView.setText("");
                    meliminar.setVisibility(View.INVISIBLE);
                    //  spinner.setSelection(0);
                }
                else
                {

                    Toast.makeText(this, "No tienes ingredientes extra", Toast.LENGTH_LONG).show();
                }
            }
        }


    }
    private void mrestaingredientes() {
        int subtotales,valor,suma;
        String s;
        switch (mselect){


            case "Camarones ($25)":
                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotales = Integer.parseInt(mtotal.getText().toString());
                valor=25;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Pan ($5)":

                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotales = Integer.parseInt(mtotal.getText().toString());
                valor=5;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Aguacate ($8)":

                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotales = Integer.parseInt(mtotal.getText().toString());
                valor=8;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Arroz ($15)":


                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotales = Integer.parseInt(mtotal.getText().toString());
                valor=15;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Papas francesas ($11)":

                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotales = Integer.parseInt(mtotal.getText().toString());
                valor=11;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;

            case "Frijoles ($10)":
            case "Verdura ($10)":
                mtotal = (TextView) findViewById(R.id.mfinalView);
                subtotales = Integer.parseInt(mtotal.getText().toString());
                valor=10;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                mtotal.setText(s);
                break;


        }
    }
    public void magregar(View t) {
        Intent intent = new Intent(MdetallesActivity.this, MenuNavigationActivity.class);

        String name = mnames.getText().toString();
        String tamano = "x";
        String cantidad=mcantidades.getText().toString();
        String extra = mextraView.getText().toString();
        String extra2 = mextra2View.getText().toString();
        String extra3 = mextra3View.getText().toString();
        String comentario =mcomentarios.getText().toString();
        String totales = mtotal.getText().toString();
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