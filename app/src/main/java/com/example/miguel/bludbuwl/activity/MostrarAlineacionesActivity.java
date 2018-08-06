package com.example.miguel.bludbuwl.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.miguel.bludbuwl.Alineacion;
import com.example.miguel.bludbuwl.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.example.miguel.bludbuwl.activity.AlineacionesUtilidades.*;

public class MostrarAlineacionesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_creados);

        leerArchivo(this);
        MostrarAlineacionesAdapter itemsAdapter = new MostrarAlineacionesAdapter(this,new ArrayList<>(obtenerAlineaciones().values()));

        ListView listView = findViewById(R.id.lista_mostrar_alineaciones_guardadas);

        listView.setAdapter(itemsAdapter);

        setListViewHeightBasedOnChildren(listView);

    }



    public class MostrarAlineacionesAdapter extends ArrayAdapter <Alineacion>{

        private class ViewHolder {
            ImageView tV1;
            TextView tV2;
            Button tV3;
        }

        public MostrarAlineacionesAdapter(Context context, List<Alineacion> alineaciones) {
            super(context, 0, alineaciones);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_mostrar_alineaciones, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.tV1 = convertView.findViewById(R.id.icono_equipos_existente);
                viewHolder.tV2 = convertView.findViewById(R.id.nombre_equipo_existente);
                convertView.setTag(viewHolder);
            } else
                viewHolder = (ViewHolder) convertView.getTag();

            Alineacion alineacion = (Alineacion) this.getItem(position);

            viewHolder.tV1.setImageResource(alineacion.getIconoEquipo());
            viewHolder.tV2.setText(alineacion.getNombreEquipo());

            Button menuEquipoExistenteButton = convertView.findViewById(R.id.menu_equipo_existente);
            menuEquipoExistenteButton.setTag(position);
            menuEquipoExistenteButton.setOnClickListener((View v) -> {
                PopupMenu popup = new PopupMenu(MostrarAlineacionesActivity.this, menuEquipoExistenteButton);
                popup.getMenuInflater().inflate(R.menu.popup_menu_alineaciones_creadas, popup.getMenu());
                popup.setOnMenuItemClickListener(item -> {

                    switch (item.getItemId()) {
                        case R.id.borrar_equipo_existente:
                            borrarAlineacion(alineacion.getNombreEquipo(), MostrarAlineacionesActivity.this);
                            finish();
                            startActivity(getIntent());
                            return true;
                        case R.id.editar_alineacion:
//                            Equipo equipo = (Equipo) entry.getValue();
//                            Intent intent = new  Intent(getApplicationContext(),RosterInicialActivity.class);
//                            intent.putExtra("equipo",equipo);
//                            startActivity(intent);
                            return true;
                        default:

                            return false;
                    }




                });

                popup.show();//showing popup menu



            });
            return convertView;
//            AlineacionesUtilidades.borrarAlineacion(entry.getKey(), MostrarAlineacionesActivity.this);
//                        finish();
//                        startActivity(getIntent());

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

