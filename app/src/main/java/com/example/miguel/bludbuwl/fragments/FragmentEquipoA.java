package com.example.miguel.bludbuwl.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miguel.bludbuwl.Alineacion;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.activity.AlineacionesUtilidades;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class FragmentEquipoA extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        Alineacion alineacionEquipoA = AlineacionesUtilidades.obtenerAlineacionPorNombre(getArguments().getString("equipo"));
        View equipoAView = inflater.inflate(R.layout.fragment_equipo_a, viewGroup, false);

        LinkedHashMap<Jugador, Integer> jugadoresLista = alineacionEquipoA.obtenerJugadoresCompletos();


        FragmentEquipoAAdapter itemsAdapter = new FragmentEquipoAAdapter(this.getContext(), new ArrayList(jugadoresLista.keySet()));
        ListView listView = equipoAView.findViewById(R.id.lista_fragment_equipo_a);
        listView.setAdapter(itemsAdapter);
        setListViewHeightBasedOnChildren(listView);

        return equipoAView;

    }

    public class FragmentEquipoAAdapter extends ArrayAdapter<Jugador> {


        public FragmentEquipoAAdapter(Context context, ArrayList<Jugador> jugadores) {
            super(context, 0, jugadores);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.lista_fragment_equipo_a, parent, false);
            }


            final Jugador jugadorActual = getItem(position);


            TextView posicionTextView = listItemView.findViewById(R.id.posicion);

            posicionTextView.setText(jugadorActual.getPosicion());


            TextView movimientoTextView = listItemView.findViewById(R.id.movimiento);

            movimientoTextView.setText(String.valueOf(jugadorActual.getMoviemiento()));

            TextView fuerzaTextView = listItemView.findViewById(R.id.fuerza);

            fuerzaTextView.setText(String.valueOf(jugadorActual.getFuerza()));

            TextView agilidadTextView = listItemView.findViewById(R.id.agilidad);

            agilidadTextView.setText(String.valueOf(jugadorActual.getAgilidad()));

            ((TextView) listItemView.findViewById(R.id.armadura)).setText(String.valueOf(jugadorActual.getArmadura()));

            listItemView.setBackgroundColor(position % 2 == 1 ? Color.WHITE : Color.LTGRAY);


            return listItemView;


        }


    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}

