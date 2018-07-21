package com.example.miguel.bludbuwl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RosterInicial extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster_inicial);

        Equipo equipo = (Equipo) getIntent().getSerializableExtra("equipo");

        equipo.getJugadores();
        Toast.makeText(RosterInicial.this, equipo.getNombre(), Toast.LENGTH_LONG).show();

        final ArrayList<Jugador> jugadores = new ArrayList<>(equipo.getJugadores());


           RosterInicialAdapter itemsAdapter = new RosterInicialAdapter(this, jugadores);

           ListView listView = findViewById(R.id.lista_roster_inicial);

           listView.setAdapter(itemsAdapter);


    }


}
