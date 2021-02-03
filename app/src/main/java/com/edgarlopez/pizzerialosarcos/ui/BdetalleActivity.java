package com.edgarlopez.pizzerialosarcos.ui;

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

import androidx.appcompat.app.AppCompatActivity;

import com.edgarlopez.pizzerialosarcos.R;
import com.edgarlopez.pizzerialosarcos.RegistroUsuarios2Activity;

public class BdetalleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText bcomentarios;
    String bselect, bcantidad, bsub;

    private TextView bextraView;
    private TextView bnames;
    private TextView btotal;
    private TextView btot;
    private TextView bsubtotal;
    private TextView bcantidades;
    Spinner bspinner, bspinner2;
    Button bbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdetalle);
        setTitle("Bebidas");

        bcomentarios = (EditText) findViewById(R.id.bcomentariosText);
        bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
        btotal = (TextView) findViewById(R.id.bfinalView);
        bsub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        btotal.setText(bsub);
        bextraView = (TextView) findViewById(R.id.bextra0View);
        brecibirDatos();
        bcargarTotal();


        ArrayAdapter<CharSequence> adapter;
        ArrayAdapter<CharSequence> adapter2;
        switch (bnames.getText().toString()) {



            case "Refrescos (355 ml.)":

                bspinner = findViewById(R.id.bingredienteSpiner);

                adapter = ArrayAdapter.createFromResource(this, R.array.bsabor, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner.setAdapter(adapter);
                bspinner.setOnItemSelectedListener(this);


                bspinner2 = findViewById(R.id.bcantidadspinner);

                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner2.setAdapter(adapter2);
                bspinner2.setOnItemSelectedListener(this);
                break;

            case "Chocolate":

                bspinner = findViewById(R.id.bingredienteSpiner);

                adapter = ArrayAdapter.createFromResource(this, R.array.bsabor3, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner.setAdapter(adapter);
                bspinner.setOnItemSelectedListener(this);


                bspinner2 = findViewById(R.id.bcantidadspinner);

                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner2.setAdapter(adapter2);
                bspinner2.setOnItemSelectedListener(this);
                break;
            case "Licuado":

                bspinner = findViewById(R.id.bingredienteSpiner);

                adapter = ArrayAdapter.createFromResource(this, R.array.bsabor4, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner.setAdapter(adapter);
                bspinner.setOnItemSelectedListener(this);


                bspinner2 = findViewById(R.id.bcantidadspinner);

                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner2.setAdapter(adapter2);
                bspinner2.setOnItemSelectedListener(this);
                break;

            case "Fuze tea (600 ml.)":

                bspinner = findViewById(R.id.bingredienteSpiner);

                adapter = ArrayAdapter.createFromResource(this, R.array.bsabor2, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner.setAdapter(adapter);
                bspinner.setOnItemSelectedListener(this);


                bspinner2 = findViewById(R.id.bcantidadspinner);

                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner2.setAdapter(adapter2);
                bspinner2.setOnItemSelectedListener(this);
                break;

            case "Jugo de naranja (natural), Vaso":
            case"Juego de naranja (natural), Jarra":
            case"Agua purificada (600 ml.)":
            case"Limonada con agua natural, Vaso":
            case"Limonada con agua natural, Jarra":
            case"Limonada con agua mineral, Vaso":
            case "Limonada con agua mineral, Jarra":
            case"Cafe":
            case"Cappuccino":
            case"Leche":


                bspinner = findViewById(R.id.bingredienteSpiner);
                bspinner.setVisibility(View.INVISIBLE);
                bextraView.setText("");
                TextView bingredienteextraView = (TextView) findViewById(R.id.bingredienteextraView);
                bingredienteextraView.setVisibility(View.INVISIBLE);
                bspinner2 = findViewById(R.id.bcantidadspinner);

                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bspinner2.setAdapter(adapter2);
                bspinner2.setOnItemSelectedListener(this);
                break;


        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.bcantidadspinner:
                int subto, val, sum;
                String s, to;


                bcantidad = parent.getItemAtPosition(position).toString();


                bcantidades = (TextView) findViewById(R.id.bcantidadesView);
                bcantidades.setText(bcantidad);

                btotal = (TextView) findViewById(R.id.bfinalView);
                btot = (TextView) findViewById(R.id.bsubtotalView);
                subto = Integer.parseInt(btot.getText().toString());

                val = Integer.parseInt(bcantidades.getText().toString());
                sum = subto * val;
                s = String.valueOf(sum);
                btotal.setText(s);


                break;
            case R.id.bingredienteSpiner:
                bselect = parent.getItemAtPosition(position).toString();


                bextraView = (TextView) findViewById(R.id.bextra0View);
                bextraView.setText(bselect);
              /*  dextra2View = (TextView) findViewById(R.id.dextra2View);
                dextra3View = (TextView) findViewById(R.id.dextra3View);
                //hextra0View = (TextView) findViewById(R.id.hextra0View);


                if (dextraView.getText().toString().isEmpty()) {
                    dsumaingredientes();

                    //Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                    deliminar.setVisibility(View.VISIBLE);
                    // spinner.setSelection(0);
                } else {
                    if (dextra2View.getText().toString().isEmpty()) {
                        dsumaingredientes();
                        dextra2View.setText(dselect);
                        //Toast.makeText(this, select, Toast.LENGTH_LONG).show();

                        // spinner.setSelection(0);
                    } else {
                        if (dextra3View.getText().toString().isEmpty()) {
                            dsumaingredientes();
                            dextra3View.setText(dselect);
                            //Toast.makeText(this, select, Toast.LENGTH_LONG).show();

                            // spinner.setSelection(0);
                        } else {
                            Toast.makeText(this, "Solo puedes tener 3 ingredientes extra", Toast.LENGTH_LONG).show();

                        }
                    }


                }
 */

                break;
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void brecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        bnames = (TextView) findViewById(R.id.bnombre);
        bnames.setText(name);

    }
    private void bcargarTotal() {

        switch (bnames.getText().toString()){
            case "Refrescos (355 ml.)":
            case "Jugo de naranja (natural), Vaso":
                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("17");
                break;

            case "Fuze tea (600 ml.)":
            case "Cappuccino":
                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("20");

                break;

            case "Juego de naranja (natural), Jarra":
                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("75");
                break;

            case "Licuado":
                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("23");
                break;

            case "Leche":
                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("12");
                break;

            case "Agua purificada (600 ml.)":
            case "Limonada con agua natural, Vaso":
                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("10");

                break;
            case "Limonada con agua natural, Jarra":
                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("45");
                break;

            case "Limonada con agua mineral, Vaso":

                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("13");

                break;
            case "Limonada con agua mineral, Jarra":

                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("55");
                break;

            case "Cafe":
            case "Chocolate":
                bsubtotal = (TextView) findViewById(R.id.bsubtotalView);
                bsubtotal.setText("18");
                break;
        }

    }
    public void bagregar(View t) {
        Intent intent = new Intent(BdetalleActivity.this, RegistroUsuarios2Activity.class);

        String name = bnames.getText().toString();
        String tamano = bextraView.getText().toString();
        String cantidad=bcantidades.getText().toString();
        String extra = "";
        String extra2 =  "";
        String extra3 =  "";
        String comentario =bcomentarios.getText().toString();
        String totales = btotal.getText().toString();
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