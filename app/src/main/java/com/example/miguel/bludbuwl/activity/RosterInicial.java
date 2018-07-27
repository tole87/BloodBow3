package com.example.miguel.bludbuwl.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miguel.bludbuwl.Alineacion;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;
import com.example.miguel.bludbuwl.team.Equipo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static com.example.miguel.bludbuwl.team.Equipo.PRESUPUESTO;

public class RosterInicial extends Activity {


    private Alineacion alineacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster_inicial);
        Equipo equipo = (Equipo) getIntent().getSerializableExtra("equipo");

        equipo.getJugadores();

        alineacion = new Alineacion(equipo);



        final ArrayList<Jugador> jugadores = new ArrayList<>(equipo.getJugadores());
        RosterInicialAdapter itemsAdapter = new RosterInicialAdapter(this, jugadores);
        ListView listView = findViewById(R.id.lista_roster_inicial);
        listView.setAdapter(itemsAdapter);
        setListViewHeightBasedOnChildren(listView);


        ((TextView) findViewById(R.id.precio_reroll)).setText(String.valueOf(equipo.getPrecioReRoll()));


        findViewById(R.id.suma_reroll).setOnClickListener(v -> modificarCantidadReRoll(R.id.suma_reroll, findViewById(R.id.contador_reroll), findViewById(R.id.presupuesto_restante), equipo));
        findViewById(R.id.resta_reroll).setOnClickListener(v -> modificarCantidadReRoll(R.id.resta_reroll, findViewById(R.id.contador_reroll), findViewById(R.id.presupuesto_restante), equipo));
        findViewById(R.id.suma_hincha).setOnClickListener(v -> modificarFactorHinchas(R.id.suma_hincha, findViewById(R.id.contador_hincha), findViewById(R.id.presupuesto_restante)));
        findViewById(R.id.resta_hincha).setOnClickListener(v -> modificarFactorHinchas(R.id.resta_hincha, findViewById(R.id.contador_hincha), findViewById(R.id.presupuesto_restante)));
        findViewById(R.id.suma_animadora).setOnClickListener(v -> modificarAnimadora(R.id.suma_animadora, findViewById(R.id.contador_animadora), findViewById(R.id.presupuesto_restante)));
        findViewById(R.id.resta_animadora).setOnClickListener(v -> modificarAnimadora(R.id.resta_animadora, findViewById(R.id.contador_animadora), findViewById(R.id.presupuesto_restante)));
        findViewById(R.id.suma_ayudante).setOnClickListener(v -> modificarAyudante(R.id.suma_ayudante, findViewById(R.id.contador_ayudante), findViewById(R.id.presupuesto_restante)));
        findViewById(R.id.resta_ayudante).setOnClickListener(v -> modificarAyudante(R.id.resta_ayudante, findViewById(R.id.contador_ayudante), findViewById(R.id.presupuesto_restante)));
        findViewById(R.id.suma_medico).setOnClickListener(v -> modificarMedico(R.id.suma_medico, findViewById(R.id.contador_medico), findViewById(R.id.presupuesto_restante)));
        findViewById(R.id.resta_medico).setOnClickListener(v -> modificarMedico(R.id.resta_medico, findViewById(R.id.contador_medico), findViewById(R.id.presupuesto_restante)));

    }

    public void botonGuardar(View view) {
        alineacion.setNombreEquipo(((EditText)findViewById(R.id.nombre_alineacion)).getText().toString());
        Alineaciones.guardarAlineacion(alineacion,this);
        startActivity(new Intent(this, GestionEquipoMenu.class));
    }

    public class RosterInicialAdapter extends ArrayAdapter<Jugador> {


        public RosterInicialAdapter(Context context, ArrayList<Jugador> jugadores) {
            super(context, 0, jugadores);
        }

        LinkedHashMap<Jugador, Integer> jugadoresAlineacion = new LinkedHashMap<>();

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.lista_roster_inicial, parent, false);
            }

            final Jugador jugadorActual = getItem(position);
            jugadoresAlineacion.put(jugadorActual, 0);


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

            ((TextView) listItemView.findViewById(R.id.max_jugador)).setText(String.valueOf(jugadorActual.getNumMaxPermitido()));

            Button botonSumarJugador = listItemView.findViewById(R.id.suma_jugador);

            Button botonRestarJugador = listItemView.findViewById(R.id.resta_jugador);

            TextView presupuestoTextView = findViewById(R.id.presupuesto_restante);
            presupuestoTextView.setText(String.valueOf(PRESUPUESTO));


            botonSumarJugador.setTag(position);
            botonSumarJugador.setOnClickListener(v -> modificarCantidadJugadores(R.id.suma_jugador, jugadorActual, cantidadTextView, presupuestoTextView, jugadoresAlineacion));

            botonRestarJugador.setTag(position);
            botonRestarJugador.setOnClickListener(v -> modificarCantidadJugadores(R.id.resta_jugador, jugadorActual, cantidadTextView, presupuestoTextView, jugadoresAlineacion));

            listItemView.setBackgroundColor(position % 2 == 1 ? Color.WHITE : Color.LTGRAY);


            return listItemView;


        }


    }

    private void modificarCantidadReRoll(int id, TextView cantidadTextView, TextView presupuestoTextView, Equipo equipo) {
        if (id == R.id.suma_reroll && (alineacion.getPresupuestoRestante() - equipo.getPrecioReRoll()) >= 0) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante() - equipo.getPrecioReRoll());
            alineacion.setReRolls(alineacion.getReRolls() + 1);
        }

        if (id == R.id.resta_reroll && alineacion.getReRolls() > 0) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante() + equipo.getPrecioReRoll());
            alineacion.setReRolls(alineacion.getReRolls() - 1);
        }
        presupuestoTextView.setText(String.valueOf(alineacion.getPresupuestoRestante()));
        cantidadTextView.setText(String.valueOf(alineacion.getReRolls()));

    }

    private void modificarFactorHinchas(int id, TextView cantidadTextView, TextView presupuestoTextView) {

        if (id == R.id.suma_hincha && (alineacion.getPresupuestoRestante() - 10000) >= 0) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante() - 10000);
            alineacion.setFactorHinchas(alineacion.getFactorHinchas()+1);
        }

        if (id == R.id.resta_hincha && alineacion.getFactorHinchas() > 0) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante() + 10000);
            alineacion.setFactorHinchas(alineacion.getFactorHinchas()-1);
        }
        presupuestoTextView.setText(String.valueOf(alineacion.getPresupuestoRestante()));
        cantidadTextView.setText(String.valueOf(alineacion.getFactorHinchas()));

    }

    private void modificarAnimadora(int id, TextView cantidadTextView, TextView presupuestoTextView) {
        if (id == R.id.suma_animadora && (alineacion.getPresupuestoRestante() - 10000) >= 0) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante() - 10000);
            alineacion.setAnimadoras(alineacion.getAnimadoras()+1);
        }

        if (id == R.id.resta_animadora && alineacion.getAnimadoras() > 0) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante() + 10000);
            alineacion.setAnimadoras(alineacion.getAnimadoras()-1);
        }
        presupuestoTextView.setText(String.valueOf(alineacion.getPresupuestoRestante()));
        cantidadTextView.setText(String.valueOf(alineacion.getAnimadoras()));

    }

    private void modificarAyudante(int id, TextView cantidadTextView, TextView presupuestoTextView) {
        if (id == R.id.suma_ayudante && (alineacion.getPresupuestoRestante() - 10000) >= 0) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante() - 10000);
            alineacion.setAyudanteEntrenador(alineacion.getAyudanteEntrenador()+1);
        }

        if (id == R.id.resta_ayudante && alineacion.getAyudanteEntrenador() > 0) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante() + 10000);
            alineacion.setAyudanteEntrenador(alineacion.getAyudanteEntrenador()-1);
        }
        presupuestoTextView.setText(String.valueOf(alineacion.getPresupuestoRestante()));
        cantidadTextView.setText(String.valueOf(alineacion.getAyudanteEntrenador()));

    }

    private void modificarMedico(int id, TextView cantidadTextView, TextView presupuestoTextView) {


        if (id == R.id.suma_medico && (alineacion.getPresupuestoRestante() - 50000) >= 0 && !alineacion.isMedico()) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante()-50000);
            alineacion.setMedico(true);
            cantidadTextView.setText(String.valueOf(1));
        }

        if (id == R.id.resta_medico && alineacion.isMedico()) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante()+50000);
            alineacion.setMedico(false);
            cantidadTextView.setText(String.valueOf(0));
        }

        presupuestoTextView.setText(String.valueOf(alineacion.getPresupuestoRestante()));
    }

    private void modificarCantidadJugadores(int id, Jugador jugadorActual, TextView cantidadTextView, TextView presupuestoTextView, LinkedHashMap<Jugador, Integer> jugadoresAlineacion) {

        if ((id == R.id.suma_jugador && (alineacion.getPresupuestoRestante() - jugadorActual.getSalario()) >= 0 && Integer.parseInt(cantidadTextView.getText().toString()) < jugadorActual.getNumMaxPermitido())) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante()- jugadorActual.getSalario());
            presupuestoTextView.setText(String.valueOf(Integer.parseInt(presupuestoTextView.getText().toString()) - jugadorActual.getSalario()));
            alineacion.addPlayer(jugadorActual);
        }

        if (id == R.id.resta_jugador && alineacion.existeJugador(jugadorActual)) {
            alineacion.setPresupuestoRestante(alineacion.getPresupuestoRestante()+ jugadorActual.getSalario());
            alineacion.deletePlayer(jugadorActual);
        }
        presupuestoTextView.setText(String.valueOf(alineacion.getPresupuestoRestante()));
        if (alineacion.existeJugador(jugadorActual)){
        cantidadTextView.setText(String.valueOf(alineacion.getNumPlayers(jugadorActual)));} else{cantidadTextView.setText(String.valueOf(0));}

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
