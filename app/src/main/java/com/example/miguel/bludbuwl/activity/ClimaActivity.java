package com.example.miguel.bludbuwl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miguel.bludbuwl.Partida;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.reglas.Clima;
import com.example.miguel.bludbuwl.reglas.PatadaInicial;
import com.example.miguel.bludbuwl.team.Equipo;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.miguel.bludbuwl.R.id.boton_continuar_clima;
import static com.example.miguel.bludbuwl.R.id.descripcion_clima;
import static com.example.miguel.bludbuwl.R.id.nombre_clima;
import static com.example.miguel.bludbuwl.R.id.tirada_clima;
import static com.example.miguel.bludbuwl.reglas.Clima.CALOR;
import static com.example.miguel.bludbuwl.reglas.Clima.LLUVIOSO;
import static com.example.miguel.bludbuwl.reglas.Clima.PERFECTO;
import static com.example.miguel.bludbuwl.reglas.Clima.SOLEADO;
import static com.example.miguel.bludbuwl.reglas.Clima.VENTISCA;

public class ClimaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima);
        Partida partida = (Partida) getIntent().getSerializableExtra("partida");

        ((EditText) findViewById(tirada_clima)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                findViewById(nombre_clima).setVisibility(VISIBLE);
                findViewById(descripcion_clima).setVisibility(VISIBLE);
                findViewById(boton_continuar_clima).setVisibility(VISIBLE);
                try {
                    int numeroIntroducido = Integer.parseInt(((EditText) findViewById(tirada_clima)).getText().toString());
                    if (numeroIntroducido<2 || numeroIntroducido>13 || ((EditText) findViewById(tirada_clima)).getText().toString().equals("")) {
                        findViewById(nombre_clima).setVisibility(INVISIBLE);
                        findViewById(descripcion_clima).setVisibility(INVISIBLE);
                        findViewById(boton_continuar_clima).setVisibility(INVISIBLE);
                    }
                    if (numeroIntroducido == 2) {
                        insertarValoresPatada(CALOR);
                    }
                    if (numeroIntroducido == 3) {
                        insertarValoresPatada(SOLEADO);
                    }
                    if (numeroIntroducido > 3 && numeroIntroducido < 11) {
                        insertarValoresPatada(PERFECTO);
                    }
                    if (numeroIntroducido == 11) {
                        insertarValoresPatada(LLUVIOSO);
                    }
                    if (numeroIntroducido == 12) {
                        insertarValoresPatada(VENTISCA);
                    }
                } catch (Exception e) {
                    Log.e("Exception", "File write failed: " + e.toString());
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void abrirTiradaHinchas(View view) {
        Intent i = new Intent(this, PatadaInicialActivity.class);
        startActivity(i);


    }

    private void insertarValoresPatada(Clima clima){
        ((TextView) findViewById(nombre_clima)).setText(clima.getNombreClima());
        ((TextView) findViewById(descripcion_clima)).setText(clima.getDescripcionClima());
    }
}

