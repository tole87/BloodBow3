package com.example.miguel.bludbuwl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.miguel.bludbuwl.Equipos.getEquipos;


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
                equipo.getJugadores();
                Toast.makeText(CreacionEquiposLista.this, equipo.getNombre(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
