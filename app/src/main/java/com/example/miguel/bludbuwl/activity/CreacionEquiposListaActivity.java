package com.example.miguel.bludbuwl.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.team.Equipo;

import java.util.ArrayList;

import static com.example.miguel.bludbuwl.team.Equipos.getEquipos;


public class CreacionEquiposListaActivity extends Activity {


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
                Intent intent = new  Intent(getApplicationContext(),RosterInicialActivity.class);
                intent.putExtra("equipo",equipo);
                startActivity(intent);

            }
        });
    }


    public static class CreacionEquiposListaAdapter extends ArrayAdapter<Equipo> {

        public CreacionEquiposListaAdapter(Context context, ArrayList<Equipo> equipos) {
            super(context, 0, equipos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.lista_equipos_creacion, parent, false);
            }

            // Get the {@link Word} object located at this position in the list
            Equipo equipoActual = getItem(position);


            ImageView iconoImageView = (ImageView) listItemView.findViewById(R.id.icono_equipos);

            iconoImageView.setImageResource(equipoActual.getIcono());

            TextView nombreTextView = (TextView) listItemView.findViewById(R.id.nombre_equipo_seleccion);

            nombreTextView.setText(equipoActual.getNombre());



            return listItemView;
        }
    }
}
