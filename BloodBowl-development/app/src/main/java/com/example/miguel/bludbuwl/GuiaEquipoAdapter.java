package com.example.miguel.bludbuwl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GuiaEquipoAdapter extends ArrayAdapter<Equipo> {

    public GuiaEquipoAdapter(Context context, ArrayList<Equipo> equipos) {
        super(context, 0, equipos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.lista_equipos_guia, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Equipo equipoActual = getItem(position);


        ImageView equipoImageView = (ImageView) listItemView.findViewById(R.id.ficha_equipos);

        equipoImageView.setImageResource(equipoActual.getFicha());
        


        return listItemView;
    }
}
