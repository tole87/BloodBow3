package com.example.miguel.bludbuwl.activity;

import android.content.Context;
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

import com.example.miguel.bludbuwl.Alineacion;
import com.example.miguel.bludbuwl.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EleccionEquiposPartidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_equipos_partida);

        LinkedHashMap<String,Alineacion> archivo = AlineacionesActivity.readFromFile(this);
        List<Map.Entry<String, Alineacion>> list = new ArrayList(archivo.entrySet());
        MostrarAlineacionesPartidaAdapter itemsAdapter = new MostrarAlineacionesPartidaAdapter(this,list);

        ListView listView = findViewById(R.id.lista_mostrar_alineaciones_guardadas);

        listView.setAdapter(itemsAdapter);

        setListViewHeightBasedOnChildren(listView);
    }

    public class MostrarAlineacionesPartidaAdapter extends ArrayAdapter {

        private class ViewHolder {
            ImageView tV1;
            TextView tV2;
        }

        public MostrarAlineacionesPartidaAdapter(Context context, List<Map.Entry<String, Alineacion>> alineaciones) {
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
            } else
                viewHolder = (EleccionEquiposPartidaActivity.MostrarAlineacionesPartidaAdapter.ViewHolder) convertView.getTag();

            Map.Entry<String, Alineacion> entry = (Map.Entry<String, Alineacion>) this.getItem(position);

            viewHolder.tV1.setImageResource(entry.getValue().getIconoEquipo());
            viewHolder.tV2.setText(entry.getKey());


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
