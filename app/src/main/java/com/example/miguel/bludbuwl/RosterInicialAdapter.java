package com.example.miguel.bludbuwl;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RosterInicialAdapter extends ArrayAdapter<Jugador>{



    public RosterInicialAdapter(Context context, ArrayList<Jugador> jugadores) {
        super(context, 0, jugadores);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.lista_roster_inicial, parent, false);
        }

        if (position % 2 == 1) {
            listItemView.setBackgroundColor(Color.WHITE);
        } else {
            listItemView.setBackgroundColor(Color.LTGRAY);
        }

        // Get the {@link Word} object located at this position in the list

        Jugador jugadorActual = getItem(position);


        TextView posicionTextView = (TextView) listItemView.findViewById(R.id.posicion);

        posicionTextView.setText(jugadorActual.getPosicion());

        TextView salarioTextView = (TextView) listItemView.findViewById(R.id.salario);

        salarioTextView.setText(String.valueOf(jugadorActual.getSalario()));

        TextView movimientoTextView = (TextView) listItemView.findViewById(R.id.movimiento);

        movimientoTextView.setText(String.valueOf(jugadorActual.getMoviemiento()));

        TextView fuerzaTextView = (TextView) listItemView.findViewById(R.id.fuerza);

        fuerzaTextView.setText(String.valueOf(jugadorActual.getFuerza()));

        TextView agilidadTextView = (TextView) listItemView.findViewById(R.id.agilidad);

        agilidadTextView.setText(String.valueOf(jugadorActual.getAgilidad()));

        TextView armaduraTextView = (TextView) listItemView.findViewById(R.id.armadura);

        armaduraTextView.setText(String.valueOf(jugadorActual.getArmadura()));

        TextView habilidadesTextView = (TextView) listItemView.findViewById(R.id.habilidades);

        habilidadesTextView.setText(String.valueOf(jugadorActual.getHabilidades()).replace("[","").replace("]",""));

        TextView cantidadTextView = (TextView) listItemView.findViewById(R.id.contador);

        cantidadTextView.setText(String.valueOf(jugadorActual.getCantidadSeleccion()));

        Button botonSumar = (Button) listItemView.findViewById(R.id.suma);

        botonSumar.setText("+");

        Button botonRestar = (Button) listItemView.findViewById(R.id.resta);

        botonRestar.setText("-");


        return listItemView;
    }



}
