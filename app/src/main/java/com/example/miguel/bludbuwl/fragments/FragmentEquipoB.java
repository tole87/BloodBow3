package com.example.miguel.bludbuwl.fragments;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miguel.bludbuwl.Alineacion;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.activity.AlineacionesUtilidades;
import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by tutlane on 09-01-2018.
 */

public class FragmentEquipoB extends Fragment {

    Dialog myDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        myDialog = new Dialog(this.getContext());
        Alineacion alineacionEquipoB = AlineacionesUtilidades.obtenerAlineacionPorNombre(getArguments().getString("equipo"));
        View equipoBView = inflater.inflate(R.layout.fragment_equipo_b, viewGroup, false);

        LinkedHashMap<Jugador, Integer> jugadoresLista = alineacionEquipoB.obtenerJugadoresCompletos();


        FragmentEquipoBAdapter itemsAdapter = new FragmentEquipoBAdapter(this.getContext(), new ArrayList(jugadoresLista.keySet()));
        ListView listView = equipoBView.findViewById(R.id.lista_fragment_equipo_b);
        listView.setAdapter(itemsAdapter);
        setListViewHeightBasedOnChildren(listView);

        return equipoBView;

    }

    public class FragmentEquipoBAdapter extends ArrayAdapter<Jugador> {


        public FragmentEquipoBAdapter(Context context, ArrayList<Jugador> jugadores) {
            super(context, 0, jugadores);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.lista_fragment_equipo_b, parent, false);
            }


            final Jugador jugadorActual = getItem(position);


            TextView posicionTextView = listItemView.findViewById(R.id.posicion);

            posicionTextView.setText(jugadorActual.getPosicion());


            TextView movimientoTextView = listItemView.findViewById(R.id.movimiento);

            movimientoTextView.setText(String.valueOf(jugadorActual.getMoviemiento()));

            TextView fuerzaTextView = listItemView.findViewById(R.id.fuerza);

            fuerzaTextView.setText(String.valueOf(jugadorActual.getFuerza()));

            TextView agilidadTextView = listItemView.findViewById(R.id.agilidad);

            agilidadTextView.setText(String.valueOf(jugadorActual.getAgilidad()));

            ((TextView) listItemView.findViewById(R.id.armadura)).setText(String.valueOf(jugadorActual.getArmadura()));

            listItemView.setBackgroundColor(position % 2 == 1 ? Color.WHITE : Color.LTGRAY);

            myDialog.setContentView(R.layout.habilidades_popup);
            TextView cerrarHabilidades = myDialog.findViewById(R.id.cerrarHabilidades);


            cerrarHabilidades.setOnClickListener(v1 -> myDialog.dismiss());

            Button iconoHabilidades = listItemView.findViewById(R.id.icono_habilidades);
            iconoHabilidades.setTag(position);

            iconoHabilidades.setOnClickListener((View v) -> {
                List<String> habilidades = new ArrayList<>(jugadorActual.getHabilidades());

                MostrarHabilidadesAdapter habilidadesAdapter = new MostrarHabilidadesAdapter(this.getContext(), habilidades);
                ListView listView = myDialog.findViewById(R.id.lista_habilidades);
                listView.setAdapter(habilidadesAdapter);
                setListViewHeightBasedOnChildren(listView);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
            });

            return listItemView;


        }

        public class MostrarHabilidadesAdapter extends ArrayAdapter<String> {

            private class ViewHolder {
                TextView tV1;
                TextView tV2;
            }


            public MostrarHabilidadesAdapter(Context context, List<String> habilidades) {
                super(context, 0, habilidades);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Check if an existing view is being reused, otherwise inflate the view
                ViewHolder viewHolder;
                View listItemView = convertView;
                if (listItemView == null) {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.lista_habilidades, parent, false);
                    viewHolder = new ViewHolder();
                    viewHolder.tV1 = listItemView.findViewById(R.id.nombre_habilidad);
                    viewHolder.tV2 = listItemView.findViewById(R.id.descripcion_habilidad);
                    listItemView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) listItemView.getTag();
                }


                String habilidad = this.getItem(position);

                viewHolder.tV1.setText(Habilidad.valueOf(habilidad).getNombre());
                viewHolder.tV1.setBackgroundColor(Color.LTGRAY);
                viewHolder.tV2.setText(Habilidad.valueOf(habilidad).getDescripcion());
                viewHolder.tV2.setBackgroundColor(Color.WHITE);

                return listItemView;
            }
        }

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

