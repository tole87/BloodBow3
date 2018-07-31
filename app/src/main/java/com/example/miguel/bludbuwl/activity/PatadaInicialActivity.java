package com.example.miguel.bludbuwl.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miguel.bludbuwl.Partida;
import com.example.miguel.bludbuwl.reglas.PatadaInicial;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.miguel.bludbuwl.R.*;
import static com.example.miguel.bludbuwl.R.id.*;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.*;

public class PatadaInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_patada_inicial);
//        Partida partida = (Partida) getIntent().getSerializableExtra("partida");
//
        ((EditText) findViewById(tirada_patada_inicial)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                findViewById(nombre_evento).setVisibility(VISIBLE);
                findViewById(descripcion_evento).setVisibility(VISIBLE);
                findViewById(boton_continuar_evento).setVisibility(VISIBLE);
                try {
                    int numeroIntroducido = Integer.parseInt(((EditText) findViewById(tirada_patada_inicial)).getText().toString());
                    if (numeroIntroducido<2 || numeroIntroducido>13 || ((EditText) findViewById(tirada_patada_inicial)).getText().toString().equals("")) {
                        findViewById(nombre_evento).setVisibility(INVISIBLE);
                        findViewById(descripcion_evento).setVisibility(INVISIBLE);
                        findViewById(boton_continuar_evento).setVisibility(INVISIBLE);
                    }
                    if (numeroIntroducido == 2) {
                        insertarValoresPatada(APORELARBITRO);
                    }
                    if (numeroIntroducido == 3) {
                        insertarValoresPatada(DISTURBIOS);
                    }
                    if (numeroIntroducido == 4) {
                        insertarValoresPatada(DEFENSAPERFECTA);
                    }
                    if (numeroIntroducido == 5) {
                        insertarValoresPatada(PATADAALTA);
                    }
                    if (numeroIntroducido == 6) {
                        insertarValoresPatada(LOSHINCHASANIMAN);
                    }
                    if (numeroIntroducido == 7) {
                        insertarValoresPatada(TIEMPOVARIABLE);
                    }
                    if (numeroIntroducido == 8) {
                        insertarValoresPatada(TACTICABRILLANTE);
                    }
                    if (numeroIntroducido == 9) {
                        insertarValoresPatada(ANTICIPACION);
                    }
                    if (numeroIntroducido == 10) {
                        insertarValoresPatada(PENETRACION);

                    }
                    if (numeroIntroducido == 11) {
                        insertarValoresPatada(PEDRADA);
                    }
                    if (numeroIntroducido==12) {
                        insertarValoresPatada(INVASIONDELCAMPO);
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
private void insertarValoresPatada(PatadaInicial patada){
    ((TextView) findViewById(nombre_evento)).setText(patada.getNombreEvento());
    ((TextView) findViewById(descripcion_evento)).setText(patada.getDescripcionEvento());
}
}
