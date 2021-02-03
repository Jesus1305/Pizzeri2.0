package com.edgarlopez.pizzerialosarcos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NdetalleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText ncomentarios;
    String nselect, ncantidad, nsub;

    private TextView nextraView;
    private TextView nnames;
    private TextView ntotal;
    private TextView ntot;
    private TextView nsubtotal;
    private TextView ncantidades;
    Spinner nspinner, nspinner2;
    Button nbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndetalle);
        setTitle("Nieves y Malteadas");

        ncomentarios = (EditText) findViewById(R.id.ncomentariosText);
        nsubtotal = (TextView) findViewById(R.id.nsubtotalView);
        ntotal = (TextView) findViewById(R.id.nfinalView);
        nsub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        ntotal.setText(nsub);
        nextraView = (TextView) findViewById(R.id.nextra0View);
        nrecibirDatos();
        ncargarTotal();


        ArrayAdapter<CharSequence> adapter;
        ArrayAdapter<CharSequence> adapter2;
        switch (nnames.getText().toString()) {


            case "Malteadas":

                nspinner = findViewById(R.id.ningredienteSpiner);

                adapter = ArrayAdapter.createFromResource(this, R.array.msabor, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                nspinner.setAdapter(adapter);
                nspinner.setOnItemSelectedListener(this);


                nspinner2 = findViewById(R.id.ncantidadspinner);

                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                nspinner2.setAdapter(adapter2);
                nspinner2.setOnItemSelectedListener(this);
                break;


            case "Nieve chica (118 ml.)":
            case "Nieve mediana (236 ml.)":
            case "Nieve grande (355 ml.)":
                nspinner = findViewById(R.id.ningredienteSpiner);

                adapter = ArrayAdapter.createFromResource(this, R.array.posabor, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                nspinner.setAdapter(adapter);
                nspinner.setOnItemSelectedListener(this);


                nspinner2 = findViewById(R.id.ncantidadspinner);

                adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                nspinner2.setAdapter(adapter2);
                nspinner2.setOnItemSelectedListener(this);
                break;


        }

    }

    private void ncargarTotal() {
        switch (nnames.getText().toString()){
            case "Malteadas":

                nsubtotal = (TextView) findViewById(R.id.nsubtotalView);
                nsubtotal.setText("18");
                break;

            case "Nieve chica (118 ml.)":
                nsubtotal = (TextView) findViewById(R.id.nsubtotalView);
                nsubtotal.setText("10");

                break;

            case "Nieve mediana (236 ml.)":
                nsubtotal = (TextView) findViewById(R.id.nsubtotalView);
                nsubtotal.setText("12");
                break;

            case "Nieve grande (355 ml.)":
                nsubtotal = (TextView) findViewById(R.id.nsubtotalView);
                nsubtotal.setText("14");
                break;


        }
    }
    public void nagregar(View t) {
        Intent intent = new Intent( NdetalleActivity.this, RegistroUsuarios2Activity.class);

        String name = nnames.getText().toString();
        String tamano = nextraView.getText().toString();
        String cantidad=ncantidades.getText().toString();
        String extra = "";
        String extra2 =  "";
        String extra3 =  "";
        String comentario =ncomentarios.getText().toString();
        String totales = ntotal.getText().toString();
        //Toast.makeText(this, totales, Toast.LENGTH_LONG).show();

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
    private void nrecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        nnames = (TextView) findViewById(R.id.nnombre);
        nnames.setText(name);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.ncantidadspinner:
                int subto, val, sum;
                String s, to;


                ncantidad = parent.getItemAtPosition(position).toString();


                ncantidades = (TextView) findViewById(R.id.ncantidadesView);
                ncantidades.setText(ncantidad);

                ntotal = (TextView) findViewById(R.id.nfinalView);
                ntot = (TextView) findViewById(R.id.nsubtotalView);
                subto = Integer.parseInt(ntot.getText().toString());

                val = Integer.parseInt(ncantidades.getText().toString());
                sum = subto * val;
                s = String.valueOf(sum);
                ntotal.setText(s);


                break;
            case R.id.ningredienteSpiner:
                nselect = parent.getItemAtPosition(position).toString();


                nextraView = (TextView) findViewById(R.id.nextra0View);
                nextraView.setText(nselect);


                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}