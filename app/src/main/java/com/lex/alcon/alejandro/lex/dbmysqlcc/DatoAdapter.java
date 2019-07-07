package com.lex.alcon.alejandro.lex.dbmysqlcc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DatoAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] Descripcion;

    public DatoAdapter(Activity context, String[] descripcion /*, Integer[] integers*/) {
        super(context, R.layout.item, descripcion);
        // TODO Auto-generated constructor stub
        this.context=context;
        //this.Hora=hora;
        this.Descripcion = descripcion;
        //this.integers=integers;
    }
    public View getView(int posicion, View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item,null,true);

        //TextView txtHora = (TextView) rowView.findViewById(R.id.textViewHourSchedule);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewLogoFraternidad);
        TextView txtDescripcion = (TextView) rowView.findViewById(R.id.textViewDato);

        //txtHora.setText(Hora[posicion]);

        //imageView.setImageResource(integers[posicion]);
        txtDescripcion.setText(Descripcion[posicion]);

        return rowView;
    }

}
