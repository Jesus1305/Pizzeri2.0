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

public class DdetalleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText dcomentarios;
    String dselect,dcantidad,dsub;

    private TextView dextraView;
    private TextView dextra2View;
    private TextView dextra3View;
    private TextView dnames;
    private TextView dtotal;
    private TextView dtot;
    private TextView dsubtotal;
    private TextView dcantidades;
    Spinner dspinner,dspinner2;
    Button dbtn;

    ImageButton deliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddetalle);
        setTitle("Desayuno");

        dcomentarios = (EditText) findViewById(R.id.dcomentariosText);

        dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
        dtotal = (TextView) findViewById(R.id.dfinalView);
        dsub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        dtotal.setText(dsub);
        deliminar=(ImageButton) findViewById(R.id.deliminarButton);
        deliminar.setVisibility(View.INVISIBLE);
        dextraView = (TextView) findViewById(R.id.dextraView);
        dextra2View = (TextView) findViewById(R.id.dextra2View);
        dextra3View = (TextView) findViewById(R.id.dextra3View);
        TextView extra0View = (TextView) findViewById(R.id.dextra0View);
        //deliminar.setVisibility(View.INVISIBLE);
        drecibirDatos();
        dcargarTotal();
        //deliminar=(ImageButton) findViewById(R.id.heliminarButton);
        //deliminar.setVisibility(View.INVISIBLE);
        dspinner = findViewById(R.id.dingredienteSpiner);
        // hspinner.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dextras, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dspinner.setAdapter(adapter);
        dspinner.setOnItemSelectedListener(this);
        //spinner.setOnItemClickListener(multiplicar());

        dspinner2 = findViewById(R.id.dcantidadspinner);
        /// hspinner2.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dspinner2.setAdapter(adapter2);
        dspinner2.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.dcantidadspinner:
                int subto, val, sum;
                String s, to;

                dextraView = (TextView) findViewById(R.id.dextraView);
                dextra2View = (TextView) findViewById(R.id.dextra2View);
                dextra3View = (TextView) findViewById(R.id.dextra3View);
                dextraView.setText("");
                dextra2View.setText("");
                dextra3View.setText("");
                dcantidad = parent.getItemAtPosition(position).toString();


                dcantidades = (TextView) findViewById(R.id.dcantidadesView);
                dcantidades.setText(dcantidad);

                dtotal = (TextView) findViewById(R.id.dfinalView);
                dtot = (TextView) findViewById(R.id.dsubtotalView);
                subto = Integer.parseInt(dtot.getText().toString());

                val = Integer.parseInt(dcantidades.getText().toString());
                sum = subto * val;
                s = String.valueOf(sum);
                dtotal.setText(s);



                break;
            case R.id.dingredienteSpiner:
                dselect = parent.getItemAtPosition(position).toString();
                dextraView = (TextView) findViewById(R.id.dextraView);
                dextra2View = (TextView) findViewById(R.id.dextra2View);
                dextra3View = (TextView) findViewById(R.id.dextra3View);
                //hextra0View = (TextView) findViewById(R.id.hextra0View);


                if (dextraView.getText().toString().isEmpty())
                {
                    dsumaingredientes();
                    dextraView.setText(dselect);
                    //Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                    deliminar.setVisibility(View.VISIBLE);
                    // spinner.setSelection(0);
                }
                else
                {
                    if (dextra2View.getText().toString().isEmpty())
                    {
                        dsumaingredientes();
                        dextra2View.setText(dselect);
                        //Toast.makeText(this, select, Toast.LENGTH_LONG).show();

                        // spinner.setSelection(0);
                    }
                    else
                    {
                        if (dextra3View.getText().toString().isEmpty())
                        {
                            dsumaingredientes();
                            dextra3View.setText(dselect);
                            //Toast.makeText(this, select, Toast.LENGTH_LONG).show();

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


    private void dsumaingredientes() {
        int subtotal,valor,suma,h;
        String s;
        switch (dselect){


            case "Chilaquiles rojos ($10)":
            case "Chilaquiles verdes ($10)":
            case "Frijoles ($10)":
                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotal = Integer.parseInt(dtotal.getText().toString());
                valor=10;
                h = Integer.parseInt(dcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;

            case "Torta de papa ($8)":
            case "Rajas ($8)":
            case"Tocino ($8)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotal = Integer.parseInt(dtotal.getText().toString());
                valor=8;
                h = Integer.parseInt(dcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;

            case "Jamon($5)":
            case "Huevo extra ($5)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotal = Integer.parseInt(dtotal.getText().toString());
                valor=5;
                h = Integer.parseInt(dcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Chuleta ahumada ($22)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotal = Integer.parseInt(dtotal.getText().toString());
                valor=22;
                h = Integer.parseInt(dcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Papas francesas ($11)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotal = Integer.parseInt(dtotal.getText().toString());
                valor=11;
                h = Integer.parseInt(dcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Arroz ($15)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotal = Integer.parseInt(dtotal.getText().toString());
                valor=15;
                h = Integer.parseInt(dcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Fajita de res ($40)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotal = Integer.parseInt(dtotal.getText().toString());
                valor=40;
                h = Integer.parseInt(dcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Hotcacke ($20)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotal = Integer.parseInt(dtotal.getText().toString());
                valor=20;
                h = Integer.parseInt(dcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;

        }
    }
    public void deliminar(View t) {
        Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        if (!dextra3View.getText().toString().isEmpty())
        {
            drestaingredientes();
            dextra3View.setText("");
            //spinner.setSelection(0);
        }
        else
        {
            if (!dextra2View.getText().toString().isEmpty())
            {

                drestaingredientes();
                dextra2View.setText("");
                //spinner.setSelection(0);
            }
            else
            {
                if (!dextraView.getText().toString().isEmpty())
                {
                    drestaingredientes();
                    dextraView.setText("");
                    deliminar.setVisibility(View.INVISIBLE);
                    //  spinner.setSelection(0);
                }
                else
                {

                    Toast.makeText(this, "No tienes ingredientes extra", Toast.LENGTH_LONG).show();
                }
            }
        }


    }
    private void drestaingredientes() {
        int subtotales,valor,suma;
        String s;
        switch (dselect){



            case "Chilaquiles rojos ($10)":
            case "Chilaquiles verdes ($10)":
            case "Frijoles ($10)":
                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotales = Integer.parseInt(dtotal.getText().toString());
                valor=10;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;

            case "Torta de papa ($8)":
            case "Rajas ($8)":
            case"Tocino ($8)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotales = Integer.parseInt(dtotal.getText().toString());
                valor=8;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;

            case "Jamon($5)":
            case "Huevo extra ($5)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotales = Integer.parseInt(dtotal.getText().toString());
                valor=5;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Chuleta ahumada ($22)":
                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotales = Integer.parseInt(dtotal.getText().toString());
                valor=22;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Papas francesas ($11)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotales = Integer.parseInt(dtotal.getText().toString());
                valor=11;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Arroz ($15)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotales = Integer.parseInt(dtotal.getText().toString());
                valor=15;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Fajita de res ($40)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotales = Integer.parseInt(dtotal.getText().toString());
                valor=40;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;


            case "Hotcacke ($20)":

                dtotal = (TextView) findViewById(R.id.dfinalView);
                subtotales = Integer.parseInt(dtotal.getText().toString());
                valor=20;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                dtotal.setText(s);
                break;



        }
    }
    private void drecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        dnames = (TextView) findViewById(R.id.dnombre);
        dnames.setText(name);

    }
    private void dcargarTotal() {

        switch (dnames.getText().toString()){

            case "Desayuno Americano":
            case"Huevos a la mexicana":
                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("65");
                break;

            case "Desayuno 'Los Arcos'":
            case"Desayuno especial":
                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("70");
                break;

            case "Huevos divorciados":

                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("63");
                break;

            case "Huevos rancheros":
                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("58");
                break;



            case "Huevos con chilaquiles":
            case"Hot cakes 'Mickey Mouse'":
                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("55");
                break;

            case "Desayuno norteno":

                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("80");
                break;

            case"Montadas (rajas o verdes)":
                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("75");
                break;

            case"Huevos":
            case"'Triple combo' Hot cakes":
                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("60");
                break;

            case"Machaca co huevo":
            case"Omelette Jamon y queso":
            case"Omelette con rajas":
            case"Omelette Champinones y queso ":
                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("68");
                break;


            case "Omelette 'Los Arcos'":

                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("78");
                break;
            case "'Mini hot cakes'":
            case"Sandwich de pollo":

                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("48");
                break;

            case "Hot cakes'":

                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("52");
                break;

            case "Sandwich 'BLT plus'":

                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("38");
                break;

            case "Avena'":

                dsubtotal = (TextView) findViewById(R.id.dsubtotalView);
                dsubtotal.setText("30");
                break;




        }

    }
    public void dagregar(View t) {
        Intent intent = new Intent(DdetalleActivity.this, MenuNavigationActivity.class);

        String name = dnames.getText().toString();
        String tamano = "x";
        String cantidad=dcantidades.getText().toString();
        String extra = dextraView.getText().toString();
        String extra2 = dextra2View.getText().toString();
        String extra3 = dextra3View.getText().toString();
        String comentario =dcomentarios.getText().toString();
        String totales = dtotal.getText().toString();
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