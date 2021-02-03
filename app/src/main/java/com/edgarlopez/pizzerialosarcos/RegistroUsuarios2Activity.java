package com.edgarlopez.pizzerialosarcos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.edgarlopez.pizzerialosarcos.utilidades.Utilidades;

import java.util.Random;

public class RegistroUsuarios2Activity extends AppCompatActivity {
    EditText campoId,campoNombre, campoTotal, campoSize, campoCantidad, campoExtra, campoComentarios;
    Random random;
    String cambio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios2);
        campoId= (EditText) findViewById(R.id.campoId);
        campoNombre= (EditText) findViewById(R.id.campoNombre);
        campoCantidad= (EditText) findViewById(R.id.campoCantidad);
        campoComentarios= (EditText) findViewById(R.id.campoComentarios);
        campoExtra= (EditText) findViewById(R.id.campoExtra);
        campoSize= (EditText) findViewById(R.id.campoSize);
        campoTotal= (EditText) findViewById(R.id.campoTotal);

        recibirDatos();
        registrarUsuarios();
        carritoView();
       finish();
    }

    private void recibirDatos() {

            Bundle extra = getIntent().getExtras();


            String name = extra.getString("name");
            String size = extra.getString("tamano");
            String cantidad = extra.getString("cantidad");
            String extras = extra.getString("extra");
            String comentario = extra.getString("comentario");
            String total = extra.getString("totales");

            campoNombre.setText(name);
            campoSize.setText(size);
            campoCantidad.setText(cantidad);
            campoExtra.setText(extras);
            campoComentarios.setText(comentario);
            campoTotal.setText(total);
            random=new Random();

        int cambio =random.nextInt(2500);
         campoId.setText(String.valueOf(cambio));







        /*String lastname = extra.getString("lastname");
        lastnames=(TextView) findViewById(R.id.lastText);
        lastnames.setText(lastname);
        String email = extra.getString("email");
       emails=(TextView) findViewById(R.id.mail);
        emails.setText(email);
    }*/

    }


    public void onClick(View view) {

        //registrarUsuariosSql();
    }

    private void carritoView() {
        Intent i = new Intent(RegistroUsuarios2Activity.this, ListaPersonas2Recycler.class);
        startActivity(i);
    }

    private void registrarUsuariosSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (id,nombre,telefono) values (123,'Cristian','85665223')

        String insert="INSERT INTO "+ Utilidades.TABLA_USUARIO
                +" ( " +Utilidades.CAMPO_ID+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_TOTAL+")" +
                " VALUES ("+campoId.getText().toString()+", '"+campoNombre.getText().toString()+"','"
                +campoTotal.getText().toString()+"')";

        db.execSQL(insert);


        db.close();
    }


    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();



        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_CANTIDAD,campoCantidad.getText().toString());
        values.put(Utilidades.CAMPO_COMENTARIO ,campoComentarios.getText().toString());
        values.put(Utilidades.CAMPO_EXTRA,campoExtra.getText().toString());
        values.put(Utilidades.CAMPO_SIZE,campoSize.getText().toString());
        values.put(Utilidades.CAMPO_TOTAL,campoTotal .getText().toString());



        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

       // Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();

        db.close();
    }
}