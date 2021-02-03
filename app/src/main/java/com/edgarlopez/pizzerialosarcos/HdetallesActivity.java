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

public class HdetallesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText hcomentarios;
    String hselect,hcantidad,hsub;

    private TextView hextraView;
    private TextView hextra2View;
    private TextView hextra3View;
    private TextView hnames;
    private TextView htotal;
    private TextView htot;
    private TextView hsubtotal;
    private TextView hcantidades;
    Spinner hspinner,hspinner2;
    Button hbtn;

    ImageButton heliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hdetalles);

        setTitle("Hamburgesas");
        hcomentarios = (EditText) findViewById(R.id.hcomentariosText);

        hsubtotal = (TextView) findViewById(R.id.hsubtotalView);
        htotal = (TextView) findViewById(R.id.hfinalView);
        hsub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        htotal.setText(hsub);
        heliminar=(ImageButton) findViewById(R.id.heliminarButton);
        heliminar.setVisibility(View.INVISIBLE);
        hextraView = (TextView) findViewById(R.id.hextraView);
        hextra2View = (TextView) findViewById(R.id.hextra2View);
        hextra3View = (TextView) findViewById(R.id.hextra3View);
        TextView extra0View = (TextView) findViewById(R.id.extra0View);
        heliminar.setVisibility(View.INVISIBLE);
        hrecibirDatos();
        hcargarTotal();
        heliminar=(ImageButton) findViewById(R.id.heliminarButton);
        heliminar.setVisibility(View.INVISIBLE);
        hspinner = findViewById(R.id.hingredienteSpiner);
        // hspinner.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hextras, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hspinner.setAdapter(adapter);
        hspinner.setOnItemSelectedListener(this);
        //spinner.setOnItemClickListener(multiplicar());

        hspinner2 = findViewById(R.id.hcantidadspinner);
        /// hspinner2.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hspinner2.setAdapter(adapter2);
        hspinner2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.hcantidadspinner:
                int subto, val, sum;
                String s, to;

                hextraView = (TextView) findViewById(R.id.hextraView);
                hextra2View = (TextView) findViewById(R.id.hextra2View);
                hextra3View = (TextView) findViewById(R.id.hextra3View);
                hextraView.setText("");
                hextra2View.setText("");
                hextra3View.setText("");
                hcantidad = parent.getItemAtPosition(position).toString();


                hcantidades = (TextView) findViewById(R.id.hcantidadesView);
                hcantidades.setText(hcantidad);

                htotal = (TextView) findViewById(R.id.hfinalView);
                htot = (TextView) findViewById(R.id.hsubtotalView);
                subto = Integer.parseInt(htot.getText().toString());

                val = Integer.parseInt(hcantidades.getText().toString());
                sum = subto * val;
                s = String.valueOf(sum);
                htotal.setText(s);



                break;
            case R.id.hingredienteSpiner:
                hselect = parent.getItemAtPosition(position).toString();
                hextraView = (TextView) findViewById(R.id.hextraView);
                hextra2View = (TextView) findViewById(R.id.hextra2View);
                hextra3View = (TextView) findViewById(R.id.hextra3View);
                //hextra0View = (TextView) findViewById(R.id.hextra0View);


                if (hextraView.getText().toString().isEmpty())
                {
                    hsumaingredientes();
                    hextraView.setText(hselect);
                    //Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                    heliminar.setVisibility(View.VISIBLE);
                    // spinner.setSelection(0);
                }
                else
                {
                    if (hextra2View.getText().toString().isEmpty())
                    {
                        hsumaingredientes();
                        hextra2View.setText(hselect);
                        // Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                        //spinner.setSelection(0);
                    }
                    else
                    {
                        if (hextra3View.getText().toString().isEmpty())
                        {
                            hsumaingredientes();
                            hextra3View.setText(hselect);
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
    private void hsumaingredientes() {
        int subtotal,valor,suma,h;
        String s;
        switch (hselect){

            case "Carne de res ($10)":
            case "Carne de pollo ($10)":
                htotal = (TextView) findViewById(R.id.hfinalView);
                subtotal = Integer.parseInt(htotal.getText().toString());
                valor=10;
                h = Integer.parseInt(hcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                htotal.setText(s);
                break;

            case "Queso ($5)":
            case "Jamon($5)":
                htotal = (TextView) findViewById(R.id.hfinalView);
                subtotal = Integer.parseInt(htotal.getText().toString());
                valor=5;
                h = Integer.parseInt(hcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                htotal.setText(s);
                break;

            case "Pina ($8)":

                htotal = (TextView) findViewById(R.id.hfinalView);
                subtotal = Integer.parseInt(htotal.getText().toString());
                valor=8;
                h = Integer.parseInt(hcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                htotal.setText(s);
                break;

            case "Tocino (2 tiras) ($15)":

                htotal = (TextView) findViewById(R.id.hfinalView);
                subtotal = Integer.parseInt(htotal.getText().toString());
                valor=15;
                h = Integer.parseInt(hcantidades.getText().toString());
                valor=valor*h;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                htotal.setText(s);
                break;


        }
    }
    public void heliminar(View t) {
        Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        if (!hextra3View.getText().toString().isEmpty())
        {
            hrestaingredientes();
            hextra3View.setText("");
            //spinner.setSelection(0);
        }
        else
        {
            if (!hextra2View.getText().toString().isEmpty())
            {

                hrestaingredientes();
                hextra2View.setText("");
                //spinner.setSelection(0);
            }
            else
            {
                if (!hextraView.getText().toString().isEmpty())
                {
                    hrestaingredientes();
                    hextraView.setText("");
                    heliminar.setVisibility(View.INVISIBLE);
                    //  spinner.setSelection(0);
                }
                else
                {

                    Toast.makeText(this, "No tienes ingredientes extra", Toast.LENGTH_LONG).show();
                }
            }
        }


    }
    private void hrestaingredientes() {
        int subtotales,valor,suma;
        String s;
        switch (hselect){

            case "Carne de res ($10)":
            case "Carne de pollo ($10)":
                htotal = (TextView) findViewById(R.id.hfinalView);
                subtotales = Integer.parseInt(htotal.getText().toString());
                valor=10;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                htotal.setText(s);
                break;

            case "Queso ($5)":
            case "Jamon($5)":
                htotal = (TextView) findViewById(R.id.finalView);
                subtotales = Integer.parseInt(htotal.getText().toString());
                valor=5;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                htotal.setText(s);
                break;

            case "Pina ($8)":
                htotal = (TextView) findViewById(R.id.finalView);
                subtotales = Integer.parseInt(htotal.getText().toString());
                valor=8;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                htotal.setText(s);
                break;

            case "Tocino (2 tiras) ($15)":
                htotal = (TextView) findViewById(R.id.finalView);
                subtotales = Integer.parseInt(htotal.getText().toString());
                valor=15;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                htotal.setText(s);
                break;


        }
    }
    private void hrecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        hnames = (TextView) findViewById(R.id.hnombre);
        hnames.setText(name);

    }
    private void hcargarTotal() {

        switch (hnames.getText().toString()){

            case "Hamburgesa especial":
                hsubtotal = (TextView) findViewById(R.id.hsubtotalView);
                hsubtotal.setText("39");
                break;

            case "hamburgesa combinada":

                hsubtotal = (TextView) findViewById(R.id.hsubtotalView);
                hsubtotal.setText("54");

                break;

            case "Hamburgesa sensilla":
            case "Hamburgesa de pollo":
                hsubtotal = (TextView) findViewById(R.id.hsubtotalView);
                hsubtotal.setText("34");
                break;

            case "hamburgesa doble":
            case "hamburgesa de pollo doble":
                hsubtotal = (TextView) findViewById(R.id.hsubtotalView);
                hsubtotal.setText("44");

                break;
            case "Hamburgesa de filete":
                hsubtotal = (TextView) findViewById(R.id.hsubtotalView);
                hsubtotal.setText("35");
                break;

            case "hot dog":
                hsubtotal = (TextView) findViewById(R.id.hsubtotalView);
                hsubtotal.setText("22");

                break;
            case "Papas Francesas":
                hsubtotal = (TextView) findViewById(R.id.hsubtotalView);
                hsubtotal.setText("21");
                break;
        }

    }
    public void hagregar(View t) {
        Intent intent = new Intent(HdetallesActivity.this, RegistroUsuarios2Activity.class);

        String name = hnames.getText().toString();
        String tamano = "x";
        String cantidad=hcantidades.getText().toString();
        String extra = hextraView.getText().toString();
        String extra2 = hextra2View.getText().toString();
        String extra3 = hextra3View.getText().toString();
        String comentario =hcomentarios.getText().toString();
        String totales = htotal.getText().toString();
       // Toast.makeText(this, totales, Toast.LENGTH_LONG).show();

        intent.putExtra("name", name);
        intent.putExtra("tamano", tamano);
        intent.putExtra("cantidad", cantidad);
        intent.putExtra("extra", extra);
        intent.putExtra("extra2", extra2);
        intent.putExtra("extra3", extra3);
        intent.putExtra("comentario", comentario);
        intent.putExtra("totales",totales);
finish();
        startActivity(intent);
    }


}