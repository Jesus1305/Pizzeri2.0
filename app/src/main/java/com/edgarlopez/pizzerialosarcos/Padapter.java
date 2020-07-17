package com.edgarlopez.pizzerialosarcos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class Padapter extends BaseAdapter {


    private Context context;
    private int layout;
    private List<String> names;
    private List<String> detalle;


public Padapter(Context contexto, int layout, List<String> names, List<String> detalle){
    this.context=contexto;
    this.layout=layout;
    this.names=names;
    this.detalle=detalle;
}
    @Override
    public int getCount() { return this.names.size(); }

    @Override
    public Object getItem(int position) { return this.names.get(position); }

    @Override
    public long getItemId(int id) {return id; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       //compiamos la vista
        View v = convertView;

        // inflamos la vista
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
                v = layoutInflater.inflate(R.layout.list_item,null);

       //nos traemos el valor actuL DEPENDIENTE DE LA POSIION
        String currentName = names.get(position);
        String currentDetalle = detalle.get(position);

        //referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.pizzanameView);
        textView.setText(currentName);
        TextView teextView = (TextView) v.findViewById(R.id.pizzadetalleView);
        teextView.setText(currentDetalle);

        //devolvemos la vista inflada
       return  v;

    }
}