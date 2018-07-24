package com.example.miguel.bludbuwl.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.miguel.bludbuwl.R;

import static com.example.miguel.bludbuwl.team.Equipos.getEquipos;

public class GuiaEquipos extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia_equipos);


        GestionEquipoMenu.GuiaEquipoAdapter itemsAdapter = new GestionEquipoMenu.GuiaEquipoAdapter(this,getEquipos());

        ListView listView = findViewById(R.id.lista_equipos);

        listView.setAdapter(itemsAdapter);


    }


}
