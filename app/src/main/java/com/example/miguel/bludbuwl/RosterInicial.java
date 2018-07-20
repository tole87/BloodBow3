package com.example.miguel.bludbuwl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class RosterInicial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster_inicial);

        Equipo equipo = (Equipo) getIntent().getSerializableExtra("equipo");

        equipo.getJugadores();
        Toast.makeText(RosterInicial.this, equipo.getNombre(), Toast.LENGTH_LONG).show();


    }
}
