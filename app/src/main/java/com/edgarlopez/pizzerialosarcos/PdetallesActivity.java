package com.edgarlopez.pizzerialosarcos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

import com.edgarlopez.pizzerialosarcos.ui.MenuNavigationActivity;

public class PdetallesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText comentarios;
    String select,cantidad,sub;

    private TextView extraView;
    private TextView extra2View;
    private TextView extra3View;
    private TextView names;
    private TextView total;
    private TextView tot;
    private TextView size;
    private TextView subtotal;
    private TextView cantidades;
    Spinner spinner,spinner2;
    Button btn;
    Button chica;
    Button mediana;
    Button grande;
    ImageButton eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdetallea);


        comentarios =(EditText)findViewById(R.id.comentariosText);
        size = (TextView) findViewById(R.id.sizeView);
        size.setText("grande");
        subtotal = (TextView) findViewById(R.id.subtotalView);
        total=(TextView)findViewById(R.id.finalView);
        sub="1";
        //Toast.makeText(this,sub,Toast.LENGTH_LONG).show();
        total.setText(sub);
        chica = (Button) findViewById(R.id.chicaView);
        mediana = (Button) findViewById(R.id.medianaView);
        grande = (Button) findViewById(R.id.grandeView);
        eliminar=(ImageButton) findViewById(R.id.eliminarButton);
        eliminar.setVisibility(View.INVISIBLE);
        extraView = (TextView) findViewById(R.id.extraView);
        extra2View = (TextView) findViewById(R.id.extra2View);
        extra3View = (TextView) findViewById(R.id.extra3View);
        TextView extra0View = (TextView) findViewById(R.id.extra0View);
        eliminar.setVisibility(View.INVISIBLE);
        recibirDatos();
        cargarTotal();
        spinner = findViewById(R.id.ingredienteSpiner);
        spinner.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pextras, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //spinner.setOnItemClickListener(multiplicar());

        spinner2 = findViewById(R.id.cantidadspinner);
        spinner2.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

    }

    public void Chicas(View t) {
        Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        //chica.setBackgroundColor(Color.red(2));
        //chica.setTextColor(Color.parseColor("#ff0000"));
        spinner.setVisibility(View.VISIBLE);
        spinner2.setVisibility(View.VISIBLE);
        size = (TextView) findViewById(R.id.sizeView);
        size.setText("chica");
        cargarTotal();
        restaingredientes();
        extra3View.setText("");
        restaingredientes();
        extra2View.setText("");
        restaingredientes();
        extraView.setText("");
        total = (TextView) findViewById(R.id.finalView);
        total.setText(subtotal.getText());
        total = (TextView) findViewById(R.id.finalView);
        total.setText(subtotal.getText());
        chica.setBackgroundColor(Color.parseColor("#A2845E"));
        mediana.setBackgroundColor(Color.parseColor("#F4E8C3"));
        grande.setBackgroundColor(Color.parseColor("#F4E8C3"));
        spinner2.setSelection(0);
        eliminar.setVisibility(View.INVISIBLE);

    }
    public void Medianas(View t) {
        String sub;
        //Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        size = (TextView) findViewById(R.id.sizeView);
        size.setText("mediana");
        spinner.setVisibility(View.VISIBLE);
        spinner2.setVisibility(View.VISIBLE);
        //chica.setBackgroundColor(Color.red(2));
        //chica.setTextColor(Color.parseColor("#ff0000"));
        cargarTotal();
        total = (TextView) findViewById(R.id.finalView);
        total.setText(subtotal.getText());
        restaingredientes();
        extra3View.setText("");
        restaingredientes();
        extra2View.setText("");
        restaingredientes();
        extraView.setText("");
        total = (TextView) findViewById(R.id.finalView);
        total.setText(subtotal.getText());
        mediana.setBackgroundColor(Color.parseColor("#A2845E"));
        chica.setBackgroundColor(Color.parseColor("#F4E8C3"));
        grande.setBackgroundColor(Color.parseColor("#F4E8C3"));
        spinner2.setSelection(0);
        eliminar.setVisibility(View.INVISIBLE);
    }
    public void Grandes(View t) {
        //Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        spinner.setVisibility(View.VISIBLE);
        spinner2.setVisibility(View.VISIBLE);
        //Dar valor de size
        size = (TextView) findViewById(R.id.sizeView);
        size.setText("grande");
        //chica.setBackgroundColor(Color.red(2));
        //chica.setTextColor(Color.parseColor("#ff0000"));

        //vuelves a poner el total de la carga
        cargarTotal();
        grande.setBackgroundColor(Color.parseColor("#A2845E"));
        mediana.setBackgroundColor(Color.parseColor("#F4E8C3"));
        chica.setBackgroundColor(Color.parseColor("#F4E8C3"));
        total = (TextView) findViewById(R.id.finalView);
        subtotal=(TextView) findViewById(R.id.subtotalView);
        total.setText(subtotal.getText());
        restaingredientes();
        extra3View.setText("");
        restaingredientes();
        extra2View.setText("");
        restaingredientes();
        extraView.setText("");
        spinner2.setSelection(0);
        eliminar.setVisibility(View.INVISIBLE);


    }
    public void eliminar(View t) {
        Toast.makeText(this, "buton", Toast.LENGTH_LONG).show();
        if (!extra3View.getText().toString().isEmpty())
        {
            restaingredientes();
            extra3View.setText("");
            //spinner.setSelection(0);
        }
        else
        {
            if (!extra2View.getText().toString().isEmpty())
            {

                restaingredientes();
                extra2View.setText("");
                //spinner.setSelection(0);
            }
            else
            {
                if (!extraView.getText().toString().isEmpty())
                {
                    restaingredientes();
                    extraView.setText("");
                    eliminar.setVisibility(View.INVISIBLE);
                    //  spinner.setSelection(0);
                }
                else
                {

                    Toast.makeText(this, "No tienes ingredientes extra", Toast.LENGTH_LONG).show();
                }
            }
        }


    }
    public void menu(View t) {
        Intent intent = new Intent(PdetallesActivity.this, MenuNavigationActivity.class);

        String name = names.getText().toString();
        String tamano = size.getText().toString();
        String cantidad=cantidades.getText().toString();
        String extra = extraView.getText().toString();
        String extra2 = extra2View.getText().toString();
        String extra3 = extra3View.getText().toString();
        String comentario =comentarios.getText().toString();
        String totales = total.getText().toString();
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId())
        {

            case R.id.cantidadspinner:
                int subto,val,sum;
                String s,to;

                // select = parent.getItemAtPosition(position).toString();

                cantidad = parent.getItemAtPosition(position).toString();
                // Toast.makeText(this, cantidad, Toast.LENGTH_LONG).show();

                cantidades = (TextView) findViewById(R.id.cantidadesView);
                cantidades.setText(cantidad);

                total = (TextView) findViewById(R.id.finalView);
                tot = (TextView) findViewById(R.id.subtotalView);
                subto = Integer.parseInt(tot.getText().toString());
                //val=10;
                val=Integer.parseInt(cantidades.getText().toString());
                sum=subto*val;
                s = String.valueOf(sum);
                total.setText(s);

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
            case R.id.ingredienteSpiner:
                select = parent.getItemAtPosition(position).toString();
                TextView extraView = (TextView) findViewById(R.id.extraView);
                TextView extra2View = (TextView) findViewById(R.id.extra2View);
                TextView extra3View = (TextView) findViewById(R.id.extra3View);
                TextView extra0View = (TextView) findViewById(R.id.extra0View);


                if (extraView.getText().toString().isEmpty())
                {
                    sumaingredientes();
                    extraView.setText(select);
                    //Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                    eliminar.setVisibility(View.VISIBLE);
                    // spinner.setSelection(0);
                }
                else
                {
                    if (extra2View.getText().toString().isEmpty())
                    {
                        sumaingredientes();
                        extra2View.setText(select);
                        // Toast.makeText(this, select, Toast.LENGTH_LONG).show();
                        //spinner.setSelection(0);
                    }
                    else
                    {
                        if (extra3View.getText().toString().isEmpty())
                        {
                            sumaingredientes();
                            extra3View.setText(select);
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
    private void recibirDatos() {
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("name");

        names = (TextView) findViewById(R.id.nombrepizza);
        names.setText(name);
        /*String lastname = extra.getString("lastname");
        lastnames=(TextView) findViewById(R.id.lastText);
        lastnames.setText(lastname);
        String email = extra.getString("email");
       emails=(TextView) findViewById(R.id.mail);
        emails.setText(email);
    }*/
    }
    private void cargarTotal() {

        switch (names.getText().toString()){

            case "Pizza Los arcos":

                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }

                break;

            case "Especial":
                switch (size.getText().toString()){
                    case"grande":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

            case "Vegetariana":
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

            case "Mexicana":
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

            case "Jamon con pina":
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

            case "Peperoni":
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

            case "Camarones":
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

            case "Salami":
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;
            case "Jamon de pavo" :
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

            case "Picadillo con chile":
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

            case "Salchicha de pavo con champinones":
                switch (size.getText().toString()){

                    case"grande":

                        subtotal.setText("134");
                        break;
                    case"mediana":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("106");
                        break;
                    case"chica":
                        subtotal = (TextView) findViewById(R.id.subtotalView);
                        subtotal.setText("73");
                        break; }
                break;

        }

    }
    private void sumaingredientes() {
        int subtotal,valor,suma;
        String s;
        switch (select){

            case "Peperoni ($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Jamon ($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;


            case "Jamon de pavo  ($10)":
                total = (TextView) findViewById(R.id.finalView);
                Toast.makeText(this, "", Toast.LENGTH_LONG).show();
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Salami  ($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Queso ($20)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=20;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Tocino ($20)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=20;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Camarones ($20)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=20;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Pimiento morron($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;
            case "Champinones($10)" :
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Cebolla ($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Tomate ($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;
            case "Pina ($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Topping especial ($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;
            case "Frijoles ($10)":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;
            case "Jalapenios ($10":
                total = (TextView) findViewById(R.id.finalView);
                subtotal = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotal+valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;


        }
    }
    private void restaingredientes() {
        int subtotales,valor,suma;
        String s;
        switch (select){

            case "Peperoni ($10)":
            case "Jamon ($10)":
            case "Jamon de pavo  ($10)":
            case "Salami  ($10)":
            case "Pimiento morron($10)":
            case "Champinones($10)" :
            case "Cebolla ($10)":
            case "Tomate ($10)":
            case "Pina ($10)":
            case "Topping especial ($10)":
            case "Frijoles ($10)":
            case "Jalapenios ($10":
                total = (TextView) findViewById(R.id.finalView);
                subtotales = Integer.parseInt(total.getText().toString());
                valor=10;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;

            case "Queso ($20)":
            case "Tocino ($20)":
            case "Camarones ($20)":
                total = (TextView) findViewById(R.id.finalView);
                subtotales = Integer.parseInt(total.getText().toString());
                valor=20;
                suma=subtotales-valor;
                s = String.valueOf(suma);
                total.setText(s);
                break;
        }


    }

}