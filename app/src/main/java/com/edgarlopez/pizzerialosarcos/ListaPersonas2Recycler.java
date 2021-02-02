package com.edgarlopez.pizzerialosarcos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edgarlopez.pizzerialosarcos.adaptadores.ListaPersonasAdapter;
import com.edgarlopez.pizzerialosarcos.entidades.Usuario;
import com.edgarlopez.pizzerialosarcos.ui.MenuNavigationActivity;
import com.edgarlopez.pizzerialosarcos.utilidades.Utilidades;

import java.util.ArrayList;

public class ListaPersonas2Recycler extends AppCompatActivity {


    ArrayList<Usuario> listaUsuario;
    RecyclerView recyclerViewUsuarios;

    TextView id;
  ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas2_recycler);


       conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        id= (TextView) findViewById(R.id.IdEliminar);
        listaUsuario=new ArrayList<>();

        recyclerViewUsuarios= (RecyclerView) findViewById(R.id.recyclerPersonas);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));

        consultarListaPersonas();

        ListaPersonasAdapter adapter=new ListaPersonasAdapter(listaUsuario);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Seleccion: "+listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId(), Toast.LENGTH_SHORT).show();
                String idReal = listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId().toString();
                id.setText(idReal);
                // id.setText();

                //id.setText((CharSequence) listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId();
                // id.setText(listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId());
                mostrardialogo(v);

            }
        });
        recyclerViewUsuarios.setAdapter(adapter);


    }

private void mostrardialogo(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Los Arcos Inc")
                .setMessage("Desea eliminar platillo?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase db=conn.getWritableDatabase();
                        String[] parametros={id.getText().toString()};
                     // String comparable = id.getText().toString();
                     //   GlobalClass globalClass=(GlobalClass)getApplicationContext();
                     //Integer.parseInt(comparable.toString());
                     //   globalClass.setContadorid(++comparable);
                        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
                      //  Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario", Toast.LENGTH_LONG).show();
                        id.setText("");
                        //limpiar();
                        db.close();
                        finish();
                        startActivity(getIntent());
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

private void consultarListaPersonas() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setSize(cursor.getString(3));
            usuario.setCantidad(cursor.getString(4));
            usuario.setExtra(cursor.getString(5));
            usuario.setComentarios(cursor.getString(6));
            usuario.setTotal(cursor.getString(2));

            listaUsuario.add(usuario);
        }
    }
    public void pbackmenu(View t) {
        Intent intent = new Intent(ListaPersonas2Recycler.this, MenuNavigationActivity.class);
        startActivity(intent);
    }
}