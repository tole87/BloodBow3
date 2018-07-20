package com.example.miguel.bludbuwl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CreacionEquiposListaAdapter extends ArrayAdapter<Equipo> {

    public CreacionEquiposListaAdapter(Context context, ArrayList<Equipo> equipos) {
        super(context, 0, equipos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.lista_equipos_creacion, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Equipo equipoActual = getItem(position);


        ImageView iconoImageView = (ImageView) listItemView.findViewById(R.id.icono_equipos);

        iconoImageView.setImageResource(equipoActual.getIcono());

        TextView nombreTextView = (TextView) listItemView.findViewById(R.id.nombre_equipo_seleccion);

        nombreTextView.setText(equipoActual.getNombre());



        return listItemView;
    }
}
