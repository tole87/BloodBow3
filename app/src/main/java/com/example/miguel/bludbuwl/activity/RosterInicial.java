package com.example.miguel.bludbuwl.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miguel.bludbuwl.Alineacion;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;
import com.example.miguel.bludbuwl.team.Equipo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RosterInicial extends Activity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster_inicial);


        Equipo equipo = (Equipo) getIntent().getSerializableExtra("equipo");

        equipo.getJugadores();

        Alineacion nuevaAlineacion = new Alineacion(String.valueOf(equipo.getNombre()),Equipo.PRESUPUESTO);

        Toast.makeText(RosterInicial.this, equipo.getNombre(), Toast.LENGTH_LONG).show();

        final ArrayList<Jugador> jugadores = new ArrayList<>(equipo.getJugadores());

        RosterInicialAdapter itemsAdapter = new RosterInicialAdapter(this, jugadores);

        ListView listView = findViewById(R.id.lista_roster_inicial);


        listView.setAdapter(itemsAdapter);


        setListViewHeightBasedOnChildren(listView);


    }


    public class RosterInicialAdapter extends ArrayAdapter<Jugador> {


        public RosterInicialAdapter(Context context, ArrayList<Jugador> jugadores) {
            super(context, 0, jugadores);
        }

        LinkedHashMap<Jugador,Integer> jugadoresAlineacion= new LinkedHashMap<>();
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.lista_roster_inicial, parent, false);
            }

            final Jugador jugadorActual = getItem(position);
            jugadoresAlineacion.put(jugadorActual,0);


            TextView posicionTextView = listItemView.findViewById(R.id.posicion);

            posicionTextView.setText(jugadorActual.getPosicion());

            TextView salarioTextView = listItemView.findViewById(R.id.salario);

            salarioTextView.setText(String.valueOf(jugadorActual.getSalario()));

            TextView movimientoTextView = listItemView.findViewById(R.id.movimiento);

            movimientoTextView.setText(String.valueOf(jugadorActual.getMoviemiento()));

            TextView fuerzaTextView = listItemView.findViewById(R.id.fuerza);

            fuerzaTextView.setText(String.valueOf(jugadorActual.getFuerza()));

            TextView agilidadTextView = listItemView.findViewById(R.id.agilidad);

            agilidadTextView.setText(String.valueOf(jugadorActual.getAgilidad()));

            // todo Simplifica esto en casa
            ((TextView) listItemView.findViewById(R.id.armadura)).setText(String.valueOf(jugadorActual.getArmadura()));

            TextView habilidadesTextView = listItemView.findViewById(R.id.habilidades);

            habilidadesTextView.setText(String.valueOf(jugadorActual.getHabilidades()).replace("[", "").replace("]", ""));

            final TextView cantidadTextView = listItemView.findViewById(R.id.contador_jugador);


            Button botonSumar = listItemView.findViewById(R.id.suma_jugador);

            Button botonRestar = listItemView.findViewById(R.id.resta_jugador);

            TextView presupuestoTextView = findViewById(R.id.presupuesto_restante);
            presupuestoTextView.setText(String.valueOf(Equipo.PRESUPUESTO));

            botonSumar.setTag(position);
            botonSumar.setOnClickListener(v -> modificarCantidadJugadores(R.id.suma_jugador, jugadorActual, cantidadTextView, presupuestoTextView, jugadoresAlineacion));

            botonRestar.setTag(position);
            botonRestar.setOnClickListener(v -> modificarCantidadJugadores(R.id.resta_jugador, jugadorActual, cantidadTextView, presupuestoTextView, jugadoresAlineacion));

            listItemView.setBackgroundColor(position % 2 == 1 ? Color.WHITE : Color.LTGRAY);








            return listItemView;


        }

        private void modificarCantidadJugadores(int id, Jugador jugadorActual, TextView cantidadTextView, TextView presupuestoTextView, LinkedHashMap<Jugador,Integer> jugadoresAlineacion) {
            int contador = jugadoresAlineacion.get(jugadorActual);
            if (id== R.id.suma_jugador && (Integer.parseInt(presupuestoTextView.getText().toString())-jugadorActual.getSalario())>=0 && jugadoresAlineacion.get(jugadorActual)<=jugadorActual.getNumMaxPermitido())  {
                int que = jugadoresAlineacion.get(jugadorActual);
                contador += 1;
                presupuestoTextView.setText(String.valueOf(Integer.parseInt(presupuestoTextView.getText().toString())-jugadorActual.getSalario()));
                jugadoresAlineacion.put(jugadorActual, contador);
            }

            if (id == R.id.resta_jugador && (Integer.parseInt(presupuestoTextView.getText().toString())+jugadorActual.getSalario())<=1000000) {
                contador -= 1;
                presupuestoTextView.setText(String.valueOf(Integer.parseInt(presupuestoTextView.getText().toString())+jugadorActual.getSalario()));
                jugadoresAlineacion.put(jugadorActual, contador);
            }

            jugadorActual.setNumMaxPermitido(contador);
            cantidadTextView.setText(String.valueOf(contador));

        }
    }
}
