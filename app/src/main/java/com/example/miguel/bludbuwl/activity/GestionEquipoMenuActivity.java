package com.example.miguel.bludbuwl.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.miguel.bludbuwl.MainActivity;
import com.example.miguel.bludbuwl.R;

public class GestionEquipoMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_equipo_menu);
    }

    public void volverMenu(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
    public void abrirEquiposCreados(View view) { startActivity(new Intent(this, MostrarAlineacionesActivity.class)); }
    public void abrirGuiaEquipos(View view) {
        startActivity(new Intent(this, GuiaEquiposActivity.class));
    }
    public void abrirCreacionEquipos(View view) { startActivity(new Intent(this, CreacionEquiposListaActivity.class)); }


}