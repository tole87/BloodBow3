package com.example.miguel.bludbuwl.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.miguel.bludbuwl.MainActivity;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.team.Equipo;

import java.util.ArrayList;

public class GestionEquipoMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_equipo_menu);
    }

    public void volverMenu(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void abrirGuiaEquipos(View view) {
        startActivity(new Intent(this, GuiaEquipos.class));
    }

    public void abrirCreacionEquipos(View view) {
        startActivity(new Intent(this, CreacionEquiposLista.class));
    }

    public static class GuiaEquipoAdapter extends ArrayAdapter<Equipo> {

        public GuiaEquipoAdapter(Context context, ArrayList<Equipo> equipos) {
            super(context, 0, equipos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.lista_equipos_guia, parent, false);
            }

            // Get the {@link Word} object located at this position in the list
            Equipo equipoActual = getItem(position);


            ImageView equipoImageView = (ImageView) listItemView.findViewById(R.id.ficha_equipos);

            equipoImageView.setImageResource(equipoActual.getFicha());



            return listItemView;
        }
    }
}