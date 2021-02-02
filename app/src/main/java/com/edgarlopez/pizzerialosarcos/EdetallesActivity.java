package com.edgarlopez.pizzerialosarcos;

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

import androidx.appcompat.app.AppCompatActivity;

public class EdetallesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText ecomentarios;
    String eselect,ecantidad,esub;

    private TextView eextraView;
    private TextView eextra2View;
    private TextView eextra3View;
    private TextView enames;
    private TextView etotal;
    private TextView etot;
    private TextView esubtotal;
    private TextView ecantidades;
    Spinner espinner,espinner2;
    Button ebtn;
    ImageButton eeliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edetalles);
        ecomentarios = (EditText) findViewById(R.id.ecomentariosText);

        esubtotal = (TextView) findViewById(R.id.esubtotalView);
        etotal = (TextView) findViewById(R.id.efinalView);
        esub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        etotal.setText(esub);
        eeliminar=(ImageButton) findViewById(R.id.eeliminarButton);
        eeliminar.setVisibility(View.INVISIBLE);
        eextraView = (TextView) findViewById(R.id.eextraView);
        eextra2View = (TextView) findViewById(R.id.eextra2View);
        eextra3View = (TextView) findViewById(R.id.eextra3View);
        TextView eextra0View = (TextView) findViewById(R.id.eextra0View);
        eeliminar.setVisibility(View.INVISIBLE);
        erecibirDatos();
        ecargarTotal();
        eeliminar=(ImageButton) findViewById(R.id.eeliminarButton);
        eeliminar.setVisibility(View.INVISIBLE);
        espinner = findViewById(R.id.eingredienteSpiner);
        // hspinner.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.eextras, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        espinner.setAdapter(adapter);
        espinner.setOnItemSelectedListener(this);
        //spinner.setOnItemClickListener(multiplicar());

        espinner2 = findViewById(R.id.ecantidadspinner);
        /// hspinner2.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        espinner2.setAdapter(adapter2);
        espinner2.setOnItemSelectedListener(this);






    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId())
        {

            case R.id.ecantidadspinner:
                int subto,val,sum;
                String s,to;

                // select = parent.getItemAtPosition(position).toString();

                ecantidad = parent.getItemAtPosition(position).toString();
                // Toast.makeText(this, cantidad, Toast.LENGTH_LONG).show();

                ecantidades = (TextView) findViewById(R.id.ecantidadesView);
                ecantidades.setText(ecantidad);

                etotal = (TextView) findViewById(R.id.efinalView);
                etot = (TextView) findViewById(R.id.esubtotalView);
                subto = Integer.parseInt(etot.getText().toString());
                //val=10;
                val=Integer.parseInt(ecantidades.getText().toString());
                sum=subto*val;
                s = String.valueOf(sum);
                etotal.setText(s);

                //to=total.getText().toString();
                //  Toast.makeText(this, to, Toast.LENGTH_LONG).show();

                // tot = (TextView) findViewById(R.id.finalView);

                //  subto = Integer.parseInt(tot.getText().toString());

                //Toast.makeText(this, subto, Toast.LENGTH_LONG).show();
                //val = Integer.parseInt(cantidades.getText().toString());
                //sum=subto*val;
                //s = String.valueOf(sum);
                // tot.setText(s);

                /*    */


                break;
            case R.id.eingredienteSpiner:
                eselect = parent.getItemAtPosition(position).toString();
                TextView extraView = (TextView) findViewById(R.id.eextraView);
                TextView extra2View = (TextView) findViewById(R.id.eextra2View);
                TextView extra3View = (TextView) findViewById(R.id.eextra3View);
                TextView extra0View = (TextView) findViewById(R.id.eextra0View);


                if (extraView.getText().toString().isEmpty())
                {
                    esumaingredientes();
                    extraView.setText(eselect);
                    //Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                    eeliminar.setVisibility(View.VISIBLE);
                    // spinner.setSelection(0);
                }
                else
                {
                    if (extra2View.getText().toString().isEmpty())
                    {
                        esumaingredientes();
                        extra2View.setText(eselect);
                        // Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                        //spinner.setSelection(0);
                    }
                    else
                    {
                        if (extra3View.getText().toString().isEmpty())
                        {
                            esumaingredientes();
                            extra3View.setText(eselect);
                            // Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                            // spinner.setSelection(0);
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
    private void esumaingredientes() {
        int subtotal,valor,suma,h;
        String s;
        switch (eselect){

            case "Champinones ($12)":
            case "Queso ($12)":
            case "Jamon($12)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotal = Integer.parseInt(etotal.getText().toString());
                valor=12;
                h = Integer.parseInt(ecantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;


            case "Tocino ($25)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotal = Integer.parseInt(etotal.getText().toString());
                valor=25;
                h = Integer.parseInt(ecantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;

            case "Pechuga de pollo ($15)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotal = Integer.parseInt(etotal.getText().toString());
                valor=15;
                h = Integer.parseInt(ecantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;

            case "Aderezo ($5)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotal = Integer.parseInt(etotal.getText().toString());
                valor=5;
                h = Integer.parseInt(ecantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;


            case "Aguacate ($8)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotal = Integer.parseInt(etotal.getText().toString());
                valor=8;
                h = Integer.parseInt(ecantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;
        }
    }
    public void eeliminar(View t) {
        Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        if (!eextra3View.getText().toString().isEmpty())
        {
            erestaingredientes();
            eextra3View.setText("");
            //spinner.setSelection(0);
        }
        else
        {
            if (!eextra2View.getText().toString().isEmpty())
            {

                erestaingredientes();
                eextra2View.setText("");
                //spinner.setSelection(0);
            }
            else
            {
                if (!eextraView.getText().toString().isEmpty())
                {
                    erestaingredientes();
                    eextraView.setText("");
                    eeliminar.setVisibility(View.INVISIBLE);
                    //  spinner.setSelection(0);
                }
                else
                {

                    Toast.makeText(this, "No tienes ingredientes extra", Toast.LENGTH_LONG).show();
                }
            }
        }


    }
    private void erestaingredientes() {
        int subtotales,valor,suma;
        String s;
        switch (eselect){

            case "Champinones ($12)":
            case "Queso ($12)":
            case "Jamon($12)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotales = Integer.parseInt(etotal.getText().toString());
                valor=12;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;

            case "Tocino ($25)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotales = Integer.parseInt(etotal.getText().toString());
                valor=25;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;

            case "Pechuga de pollo ($15)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotales = Integer.parseInt(etotal.getText().toString());
                valor=15;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;

            case "Aderezo ($5)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotales = Integer.parseInt(etotal.getText().toString());
                valor=5;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;

            case "Aguacate ($8)":
                etotal = (TextView) findViewById(R.id.efinalView);
                subtotales = Integer.parseInt(etotal.getText().toString());
                valor=8;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                etotal.setText(s);
                break;


        }
    }
    private void erecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        enames = (TextView) findViewById(R.id.enombre);
        enames.setText(name);

    }
    private void ecargarTotal() {

        switch (enames.getText().toString()){

            case "Ensalada Los Arcos":
                esubtotal = (TextView) findViewById(R.id.esubtotalView);
                esubtotal.setText("45");
                break;

            case "Ensalada de verduras":

                esubtotal = (TextView) findViewById(R.id.esubtotalView);
                esubtotal.setText("35");

                break;


        }

    }
    public void eagregar(View t) {
        Toast.makeText(this, "no jala", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(EdetallesActivity.this, RegistroUsuarios2Activity.class);


        String name = enames.getText().toString();
        String tamano = "x";
        String cantidad=ecantidades.getText().toString();
        String extra = eextraView.getText().toString();
        String comentario =ecomentarios.getText().toString();
        String totales = etotal.getText().toString();
        String extra2 = eextra2View.getText().toString();
        String extra3 = eextra3View.getText().toString();

     /*
     Toast.makeText(this, cantidad, Toast.LENGTH_LONG).show();
        Toast.makeText(this, tamano, Toast.LENGTH_LONG).show();
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
        Toast.makeText(this, extra2, Toast.LENGTH_LONG).show();
        Toast.makeText(this, extra3, Toast.LENGTH_LONG).show();
        Toast.makeText(this, extra, Toast.LENGTH_LONG).show();
         //Toast.makeText(this, totales, Toast.LENGTH_LONG).show();
       // Toast.makeText(this, comentario, Toast.LENGTH_LONG).show();
      */

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