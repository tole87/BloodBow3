package com.example.miguel.bludbuwl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import static com.example.miguel.bludbuwl.Equipos.getEquipos;

public class GuiaEquipos extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia_equipos);


        GuiaEquipoAdapter itemsAdapter = new GuiaEquipoAdapter(this,getEquipos());

        ListView listView = findViewById(R.id.lista_equipos);

        listView.setAdapter(itemsAdapter);


    }


}
