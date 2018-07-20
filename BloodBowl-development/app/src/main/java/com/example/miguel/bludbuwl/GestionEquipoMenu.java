package com.example.miguel.bludbuwl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
}