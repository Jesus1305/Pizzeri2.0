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

public class KdetalleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText kcomentarios;
    String kselect, kcantidad, ksub;

    private TextView kextraView;
    private TextView knames;
    private TextView ktotal;
    private TextView ktot;
    private TextView ksubtotal;
    private TextView kcantidades;
    Spinner kspinner, kspinner2;
    Button kbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kdetalle);

        setTitle("Kids");

        kcomentarios = (EditText) findViewById(R.id.kcomentariosText);
        ksubtotal = (TextView) findViewById(R.id.ksubtotalView);
        ktotal = (TextView) findViewById(R.id.kfinalView);
        ksub = "1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        ktotal.setText(ksub);
        kextraView = (TextView) findViewById(R.id.kextra0View);
        krecibirDatos();
        kcargarTotal();


        // ArrayAdapter<CharSequence> adapter;
        ArrayAdapter<CharSequence> adapter2;

        //kspinner = findViewById(R.id.kingredienteSpiner);

        //adapter = ArrayAdapter.createFromResource(this, R.array.posabor, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //nspinner.setAdapter(adapter);
        //nspinner.setOnItemSelectedListener(this);


        kspinner2 = findViewById(R.id.kcantidadspinner);

        adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kspinner2.setAdapter(adapter2);
        kspinner2.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int subto, val, sum;
        String s, to;


        kcantidad = parent.getItemAtPosition(position).toString();


        kcantidades = (TextView) findViewById(R.id.kcantidadesView);
        kcantidades.setText(kcantidad);

        ktotal = (TextView) findViewById(R.id.kfinalView);
        ktot = (TextView) findViewById(R.id.ksubtotalView);
        subto = Integer.parseInt(ktot.getText().toString());

        val = Integer.parseInt(kcantidades.getText().toString());
        sum = subto * val;
        s = String.valueOf(sum);
        ktotal.setText(s);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void kcargarTotal() {
        switch (knames.getText().toString()){



            case "Nuggets":

                ksubtotal = (TextView) findViewById(R.id.ksubtotalView);
                ksubtotal.setText("34");
                break;

            case "Hot dog":
            case "Hamburgesa Steak":
            case "Sandwich":
                ksubtotal = (TextView) findViewById(R.id.ksubtotalView);
                ksubtotal.setText("32");
                break;




        }
    }
    public void kagregar(View t) {
        Intent intent = new Intent( KdetalleActivity.this, RegistroUsuarios2Activity.class);

        String name = knames.getText().toString();
        String tamano = "";
        String cantidad=kcantidades.getText().toString();
        String extra = "";
        String extra2 =  "";
        String extra3 =  "";
        String comentario =kcomentarios.getText().toString();
        String totales = ktotal.getText().toString();
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
    private void krecibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        knames = (TextView) findViewById(R.id.knombre);
        knames.setText(name);
    }

}