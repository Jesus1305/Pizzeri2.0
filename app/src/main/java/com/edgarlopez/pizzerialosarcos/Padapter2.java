package com.edgarlopez.pizzerialosarcos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class Padapter2 extends BaseAdapter {


    private Context icontext;
    private int layout;
    private List<String> iname;
    private List<String> isize;
    private List<String> icantidad;
    private List<String> iextra;
    private List<String> icomentarios;
    private List<String> iprecio;


    public Padapter2(Context contexto2, int layout2, List<String> iname, List<String> isize, List<String> icantidad, List<String> iextra, List<String> icomentarios, List<String> iprecio){
        this.icontext=contexto2;
        this.layout=layout2;
        this.iname=iname;
        this.isize=isize;
        this.icantidad=icantidad;
        this.iextra=iextra;
        this.icomentarios=icomentarios;
        this.iprecio=iprecio;

    }
    @Override
    public int getCount() { return this.iname.size(); }

    @Override
    public Object getItem(int position) { return this.iname.get(position+1); }

    @Override
    public long getItemId(int id) {return id; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //compiamos la vista
        View u= convertView;

        // inflamos la vista
        LayoutInflater layoutInflater = LayoutInflater.from(this.icontext);
        u = layoutInflater.inflate(R.layout.list_item2,null);

        //nos traemos el valor actuL DEPENDIENTE DE LA POSIION

        String currentName = iname.get(position);
        String currentSize = isize.get(position);
        String currentCantidad =icantidad.get(position);
        String currentextra = iextra.get(position);
        String currentComentarios = icomentarios.get(position);
        String currentPrecio = iprecio.get(position);

       // String currentDetalle = isize.get(position);

        //referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) u.findViewById(R.id.inombreView);
        textView.setText(currentName);
        TextView teextView = (TextView) u.findViewById(R.id.isizeView);
        teextView.setText(currentSize);
        TextView teextView2 = (TextView) u.findViewById(R.id.ircantidadView);
        teextView2.setText(currentCantidad);
        TextView teextView3 = (TextView) u.findViewById(R.id.irextraView);
        teextView3.setText(currentextra);
        TextView teextView4 = (TextView) u.findViewById(R.id.ircomentariosView);
        teextView4.setText(currentComentarios);
        TextView teextView5 = (TextView) u.findViewById(R.id.itotalView);
        teextView5.setText(currentPrecio);

        //devolvemos la vista inflada

        return  u;

    }
}
