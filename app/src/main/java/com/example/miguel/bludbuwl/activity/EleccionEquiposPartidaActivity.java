package com.example.miguel.bludbuwl.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miguel.bludbuwl.Alineacion;
import com.example.miguel.bludbuwl.Partida;
import com.example.miguel.bludbuwl.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.miguel.bludbuwl.activity.AlineacionesUtilidades.leerArchivo;
import static com.example.miguel.bludbuwl.activity.AlineacionesUtilidades.obtenerAlineacionPorNombre;
import static com.example.miguel.bludbuwl.activity.AlineacionesUtilidades.obtenerAlineaciones;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class EleccionEquiposPartidaActivity extends AppCompatActivity {
    Partida partidaEnCurso = new Partida();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_equipos_partida);

        leerArchivo(this);
        MostrarAlineacionesPartidaAdapter itemsAdapter = new MostrarAlineacionesPartidaAdapter(this, new ArrayList<>(obtenerAlineaciones().values()));

        ListView listView = findViewById(R.id.lista_mostrar_alineaciones_guardadas);

        listView.setAdapter(itemsAdapter);

        setListViewHeightBasedOnChildren(listView);

        findViewById(R.id.nombre_equipoA).setOnClickListener(v -> {
            if (isBlank(((TextView) findViewById(R.id.nombre_equipoA)).getText())) {
                return;
            }
            itemsAdapter.add(obtenerAlineacionPorNombre(((TextView) findViewById(R.id.nombre_equipoA)).getText().toString()));
            ((TextView) findViewById(R.id.nombre_equipoA)).setText("");
            ((ImageView) findViewById(R.id.icono_equipoA)).setImageResource(0);
            partidaEnCurso.removeEquipoA();
            itemsAdapter.notifyDataSetChanged();

        });
        findViewById(R.id.nombre_equipoB).setOnClickListener(v -> {
            if (isBlank(((TextView) findViewById(R.id.nombre_equipoB)).getText())) {
                return;
            }
            itemsAdapter.add(obtenerAlineacionPorNombre(((TextView) findViewById(R.id.nombre_equipoB)).getText().toString()));
            ((TextView) findViewById(R.id.nombre_equipoB)).setText("");
            ((ImageView) findViewById(R.id.icono_equipoB)).setImageResource(0);
            partidaEnCurso.removeEquipoB();
            itemsAdapter.notifyDataSetChanged();

        });
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            if (isNotBlank(((TextView) findViewById(R.id.nombre_equipoA)).getText()) && isNotBlank(((TextView) findViewById(R.id.nombre_equipoB)).getText())) {
                return;
            }
            int equipo = R.id.nombre_equipoB;
            int icono = R.id.icono_equipoB;

            Alineacion alineacion = (Alineacion) adapterView.getItemAtPosition(i);
            if (isBlank(((TextView) findViewById(R.id.nombre_equipoA)).getText())) {
                partidaEnCurso.setEquipoA(alineacion.getNombreEquipo());
                equipo = R.id.nombre_equipoA;
                icono = R.id.icono_equipoA;
            }
            partidaEnCurso.setEquipoB(alineacion.getNombreEquipo());
            ((TextView) findViewById(equipo)).setText(alineacion.getNombreEquipo());
            ((ImageView) findViewById(icono)).setImageResource(alineacion.getIconoEquipo());
            itemsAdapter.remove(alineacion);

            itemsAdapter.notifyDataSetChanged();
        });
    }

    public void botonComenzar(View view) {
        if (!((TextView) findViewById(R.id.nombre_equipoA)).getText().equals("") && !((TextView) findViewById(R.id.nombre_equipoB)).getText().equals("")) {
            Intent intent = new Intent(getApplicationContext(), SeleccionarCronometro.class);
            intent.putExtra("partida", partidaEnCurso);
            startActivity(intent);
        } else {
            Toast.makeText(this, "No has seleccionado dos equipos", Toast.LENGTH_SHORT).show();
        }
    }

    public class MostrarAlineacionesPartidaAdapter extends ArrayAdapter<Alineacion> {

        private class ViewHolder {
            ImageView tV1;
            TextView tV2;
        }

        public MostrarAlineacionesPartidaAdapter(Context context, List<Alineacion> alineaciones) {
            super(context, 0, alineaciones);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            EleccionEquiposPartidaActivity.MostrarAlineacionesPartidaAdapter.ViewHolder viewHolder;

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_1_vs_1, parent, false);
                viewHolder = new EleccionEquiposPartidaActivity.MostrarAlineacionesPartidaAdapter.ViewHolder();
                viewHolder.tV1 = convertView.findViewById(R.id.icono_equipos_existente);
                viewHolder.tV2 = convertView.findViewById(R.id.nombre_equipo_existente);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (EleccionEquiposPartidaActivity.MostrarAlineacionesPartidaAdapter.ViewHolder) convertView.getTag();
            }
            Alineacion alineacion = (Alineacion) this.getItem(position);

            viewHolder.tV1.setImageResource(alineacion.getIconoEquipo());
            viewHolder.tV2.setText(alineacion.getNombreEquipo());


            return convertView;

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
