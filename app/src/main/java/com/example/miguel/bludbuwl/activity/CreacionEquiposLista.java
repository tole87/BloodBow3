package com.example.miguel.bludbuwl.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.team.Equipo;

import static com.example.miguel.bludbuwl.team.Equipos.getEquipos;


public class CreacionEquiposLista extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_equipos_lista);


        CreacionEquiposListaAdapter itemsAdapter = new CreacionEquiposListaAdapter(this, getEquipos());

        ListView listView = findViewById(R.id.lista_equipos_creacion);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Equipo equipo = (Equipo) adapterView.getItemAtPosition(i);
                Intent intent = new  Intent(getApplicationContext(),RosterInicial.class);
                intent.putExtra("equipo",equipo);
                startActivity(intent);

            }
        });
    }


}
