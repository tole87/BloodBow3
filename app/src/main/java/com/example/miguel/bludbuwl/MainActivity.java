package com.example.miguel.bludbuwl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.miguel.bludbuwl.activity.EleccionEquiposPartidaActivity;
import com.example.miguel.bludbuwl.activity.GestionEquipoMenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirMenuEquipos(View view){
        Intent i = new Intent(this, GestionEquipoMenuActivity.class);
        startActivity(i);


    }

    public void abrirPartidaRapida(View view){
        Intent i = new Intent(this, EleccionEquiposPartidaActivity.class);
        startActivity(i);


    }
}
