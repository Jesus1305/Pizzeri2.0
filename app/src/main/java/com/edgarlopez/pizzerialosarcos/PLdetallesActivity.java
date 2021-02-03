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

public class PLdetallesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText plcomentarios;
    String plselect,plcantidad,plsub;

    private TextView plextraView;
    private TextView plextra2View;
    private TextView plextra3View;
    private TextView plnames;
    private TextView pltotal;
    private TextView pltot;
    private TextView plsubtotal;
    private TextView plcantidades;
    Spinner plspinner,plspinner2;
    Button plbtn;

    ImageButton pleliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_ldetalles);

        setTitle("Platillos");

        plcomentarios = (EditText) findViewById(R.id.plcomentariosText);

        plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
        pltotal = (TextView) findViewById(R.id.plfinalView);
        plsub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        pltotal.setText(plsub);
        pleliminar=(ImageButton) findViewById(R.id.pleliminarButton);
        pleliminar.setVisibility(View.INVISIBLE);
        plextraView = (TextView) findViewById(R.id.plextraView);
        plextra2View = (TextView) findViewById(R.id.plextra2View);
        plextra3View = (TextView) findViewById(R.id.plextra3View);
        TextView extra0View = (TextView) findViewById(R.id.plextra0View);
        //meliminar.setVisibility(View.INVISIBLE);
        plrecibirDatos();
        plcargarTotal();
        //meliminar=(ImageButton) findViewById(R.id.meliminarButton);
        //meliminar.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter;
        ArrayAdapter<CharSequence> adapter2;
        switch (plnames.getText().toString()) {


            case "Fajitas de arrachera":
            case "Fajitas de pollo":
            case "Pechuga empanizada":
            case "Pechuga al chipotle":

                plspinner = findViewById(R.id.plingredienteSpiner);
                // hspinner.setVisibility(View.INVISIBLE);
                adapter = ArrayAdapter.createFromResource(this, R.array.plextras, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                plspinner.setAdapter(adapter);
                plspinner.setOnItemSelectedListener(this);
                //spinner.setOnItemClickListener(multiplicar());

                plspinner2 = findViewById(R.id.plcantidadspinner);
                /// hspinner2.setVisibility(View.INVISIBLE);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                plspinner2.setAdapter(adapter2);
                plspinner2.setOnItemSelectedListener(this);

                Toast.makeText(this, "baras",Toast.LENGTH_LONG).show();
                break;
            case "Espagueti":

                plspinner = findViewById(R.id.plingredienteSpiner);
                // hspinner.setVisibility(View.INVISIBLE);
                adapter = ArrayAdapter.createFromResource(this, R.array.plextras2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                plspinner.setAdapter(adapter);
                plspinner.setOnItemSelectedListener(this);
                //spinner.setOnItemClickListener(multiplicar());

                plspinner2 = findViewById(R.id.plcantidadspinner);
                /// hspinner2.setVisibility(View.INVISIBLE);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                plspinner2.setAdapter(adapter2);
                plspinner2.setOnItemSelectedListener(this);

                Toast.makeText(this, "baras",Toast.LENGTH_LONG).show();

                break;

            case "Sopa de tortilla":

                plspinner = findViewById(R.id.plingredienteSpiner);
                // hspinner.setVisibility(View.INVISIBLE);
                adapter = ArrayAdapter.createFromResource(this, R.array.plextras3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                plspinner.setAdapter(adapter);
                plspinner.setOnItemSelectedListener(this);
                //spinner.setOnItemClickListener(multiplicar());

                plspinner2 = findViewById(R.id.plcantidadspinner);
                /// hspinner2.setVisibility(View.INVISIBLE);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                plspinner2.setAdapter(adapter2);
                plspinner2.setOnItemSelectedListener(this);

                Toast.makeText(this, "baras",Toast.LENGTH_LONG).show();

                break;
            case "Enchiladas 'los arcos' (4)":
            case "Enchiladas de colorado (4)":
            case "Enchiladas en salsa verde (4)":
            case "Tacos de picadillo (4)":
            case "Flautas (5)":

                plspinner = findViewById(R.id.plingredienteSpiner);
                // hspinner.setVisibility(View.INVISIBLE);
                adapter = ArrayAdapter.createFromResource(this, R.array.plextras4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                plspinner.setAdapter(adapter);
                plspinner.setOnItemSelectedListener(this);
                //spinner.setOnItemClickListener(multiplicar());

                plspinner2 = findViewById(R.id.plcantidadspinner);
                /// hspinner2.setVisibility(View.INVISIBLE);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                plspinner2.setAdapter(adapter2);
                plspinner2.setOnItemSelectedListener(this);

                Toast.makeText(this, "baras",Toast.LENGTH_LONG).show();

                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.plcantidadspinner:
                int subto, val, sum;
                String s, to;

                plextraView = (TextView) findViewById(R.id.plextraView);
                plextra2View = (TextView) findViewById(R.id.plextra2View);
                plextra3View = (TextView) findViewById(R.id.plextra3View);
                plextraView.setText("");
                plextra2View.setText("");
                plextra3View.setText("");
                plcantidad = parent.getItemAtPosition(position).toString();


                plcantidades = (TextView) findViewById(R.id.plcantidadesView);
                plcantidades.setText(plcantidad);

                pltotal = (TextView) findViewById(R.id.plfinalView);
                pltot = (TextView) findViewById(R.id.plsubtotalView);
                subto = Integer.parseInt(pltot.getText().toString());

                val = Integer.parseInt(plcantidades.getText().toString());
                sum = subto * val;
                s = String.valueOf(sum);
                pltotal.setText(s);



                break;
            case R.id.plingredienteSpiner:
                plselect = parent.getItemAtPosition(position).toString();
                plextraView = (TextView) findViewById(R.id.plextraView);
                plextra2View = (TextView) findViewById(R.id.plextra2View);
                plextra3View = (TextView) findViewById(R.id.plextra3View);
                //hextra0View = (TextView) findViewById(R.id.hextra0View);


                if (plextraView.getText().toString().isEmpty())
                {
                    plsumaingredientes();
                    plextraView.setText(plselect);
                    //Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                    pleliminar.setVisibility(View.VISIBLE);
                    // spinner.setSelection(0);
                }
                else
                {
                    if (plextra2View.getText().toString().isEmpty())
                    {
                        plsumaingredientes();
                        plextra2View.setText(plselect);
                        // Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                        //spinner.setSelection(0);
                    }
                    else
                    {
                        if (plextra3View.getText().toString().isEmpty())
                        {
                            plsumaingredientes();
                            plextra3View.setText(plselect);
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

    private void plsumaingredientes() {
        int subtotal,valor,suma,h;
        String s;
        switch (plselect){

            case "Verdura ($10)":
            case "Frijoles ($10)":
            case "Salsa ($10)":

                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotal = Integer.parseInt(pltotal.getText().toString());
                valor=10;
                h = Integer.parseInt(plcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Queso ($15)":
            case "Aguacate ($15)":
            case "Arroz ($15)":
            case "Pechuga de pollo ($15)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotal = Integer.parseInt(pltotal.getText().toString());
                valor=15;
                h = Integer.parseInt(plcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Tocino ($25)":


                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotal = Integer.parseInt(pltotal.getText().toString());
                valor=25;
                h = Integer.parseInt(plcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Pan ($6)":

                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotal = Integer.parseInt(pltotal.getText().toString());
                valor=6;
                h = Integer.parseInt(plcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Camarones ($20)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotal = Integer.parseInt(pltotal.getText().toString());
                valor=20;
                h = Integer.parseInt(plcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case " Tortillas ($0)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotal = Integer.parseInt(pltotal.getText().toString());
                valor=0;
                h = Integer.parseInt(plcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;
            case "Rajas ($8)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotal = Integer.parseInt(pltotal.getText().toString());
                valor=8;
                h = Integer.parseInt(plcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Papas francesas ($11)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotal = Integer.parseInt(pltotal.getText().toString());
                valor=11;
                h = Integer.parseInt(plcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

        }
    }
    public void pleliminar(View t) {
        Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        if (!plextra3View.getText().toString().isEmpty())
        {
            plrestaingredientes();
            plextra3View.setText("");
            //spinner.setSelection(0);
        }
        else
        {
            if (!plextra2View.getText().toString().isEmpty())
            {

                plrestaingredientes();
                plextra2View.setText("");
                //spinner.setSelection(0);
            }
            else
            {
                if (!plextraView.getText().toString().isEmpty())
                {
                    plrestaingredientes();
                    plextraView.setText("");
                    pleliminar.setVisibility(View.INVISIBLE);
                    //  spinner.setSelection(0);
                }
                else
                {

                    Toast.makeText(this, "No tienes ingredientes extra", Toast.LENGTH_LONG).show();
                }
            }
        }


    }
    private void plrestaingredientes() {
        int subtotales,valor,suma;
        String s;
        switch (plselect){


            case "Verdura ($10)":
            case "Frijoles ($10)":
            case "Salsa ($10)":

                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotales = Integer.parseInt(pltotal.getText().toString());
                valor=10;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Queso ($15)":
            case "Aguacate ($15)":
            case "Arroz ($15)":
            case "Pechuga de pollo ($15)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotales = Integer.parseInt(pltotal.getText().toString());
                valor=15;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Tocino ($25)":


                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotales = Integer.parseInt(pltotal.getText().toString());
                valor=25;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Pan ($6)":

                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotales = Integer.parseInt(pltotal.getText().toString());
                valor=6;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Camarones ($20)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotales = Integer.parseInt(pltotal.getText().toString());
                valor=20;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case " Tortillas ($0)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotales = Integer.parseInt(pltotal.getText().toString());
                valor=0;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;
            case "Rajas ($8)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotales = Integer.parseInt(pltotal.getText().toString());
                valor=8;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

            case "Papas francesas ($11)":
                pltotal = (TextView) findViewById(R.id.plfinalView);
                subtotales = Integer.parseInt(pltotal.getText().toString());
                valor=11;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                pltotal.setText(s);
                break;

        }
    }
    private void plrecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        plnames = (TextView) findViewById(R.id.plnombre);
        plnames.setText(name);

    }
    private void plcargarTotal() {

        switch (plnames.getText().toString()){

            case "Fajitas de arrachera":
                plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
                plsubtotal.setText("98");
                break;

            case "Fajitas de pollo":

                plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
                plsubtotal.setText("72");

                break;

            case "Pechuga empanizada":
                plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
                plsubtotal.setText("69");
                break;

            case "Pechuga al chipotle":

                plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
                plsubtotal.setText("75");

                break;
            case "Espagueti":
                plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
                plsubtotal.setText("42");
                break;

            case "Sopa de tortilla":
            case "Enchiladas 'los arcos' (4)":
                plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
                plsubtotal.setText("68");

                break;
            case "Enchiladas de colorado (4)":
            case "Enchiladas en salsa verde (4)":
                plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
                plsubtotal.setText("64");
                break;

            case "Tacos de picadillo (4)":
            case "Flautas (5))":
                plsubtotal = (TextView) findViewById(R.id.plsubtotalView);
                plsubtotal.setText("50");
                break;
        }

    }
    public void plagregar(View t) {
        Intent intent = new Intent(PLdetallesActivity.this, RegistroUsuarios2Activity.class);

        String name = plnames.getText().toString();
        String tamano = "x";
        String cantidad=plcantidades.getText().toString();
        String extra = plextraView.getText().toString();
        String extra2 = plextra2View.getText().toString();
        String extra3 = plextra3View.getText().toString();
        String comentario =plcomentarios.getText().toString();
        String totales = pltotal.getText().toString();
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
        finish();
    }


}