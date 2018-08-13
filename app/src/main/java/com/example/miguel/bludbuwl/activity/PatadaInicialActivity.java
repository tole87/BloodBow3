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

import com.example.miguel.bludbuwl.Partida;
import com.example.miguel.bludbuwl.reglas.PatadaInicial;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.miguel.bludbuwl.R.id.boton_continuar_evento;
import static com.example.miguel.bludbuwl.R.id.descripcion_evento;
import static com.example.miguel.bludbuwl.R.id.nombre_evento;
import static com.example.miguel.bludbuwl.R.id.tirada_patada_inicial;
import static com.example.miguel.bludbuwl.R.layout;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.ANTICIPACION;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.APORELARBITRO;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.DEFENSAPERFECTA;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.DISTURBIOS;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.INVASIONDELCAMPO;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.LOSHINCHASANIMAN;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.PATADAALTA;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.PEDRADA;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.PENETRACION;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.TACTICABRILLANTE;
import static com.example.miguel.bludbuwl.reglas.PatadaInicial.TIEMPOVARIABLE;

public class PatadaInicialActivity extends AppCompatActivity {

    Partida partidaEnCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_patada_inicial);

        partidaEnCurso = (Partida) getIntent().getSerializableExtra("partida");

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
                        partidaEnCurso.setPatadaInicial(APORELARBITRO.getNombreEvento());
                    }
                    if (numeroIntroducido == 3) {
                        insertarValoresPatada(DISTURBIOS);
                        partidaEnCurso.setPatadaInicial(DISTURBIOS.getNombreEvento());
                    }
                    if (numeroIntroducido == 4) {
                        insertarValoresPatada(DEFENSAPERFECTA);
                        partidaEnCurso.setPatadaInicial(DEFENSAPERFECTA.getNombreEvento());
                    }
                    if (numeroIntroducido == 5) {
                        insertarValoresPatada(PATADAALTA);
                        partidaEnCurso.setPatadaInicial(PATADAALTA.getNombreEvento());
                    }
                    if (numeroIntroducido == 6) {
                        insertarValoresPatada(LOSHINCHASANIMAN);
                        partidaEnCurso.setPatadaInicial(LOSHINCHASANIMAN.getNombreEvento());
                    }
                    if (numeroIntroducido == 7) {
                        insertarValoresPatada(TIEMPOVARIABLE);
                        partidaEnCurso.setPatadaInicial(TIEMPOVARIABLE.getNombreEvento());
                    }
                    if (numeroIntroducido == 8) {
                        insertarValoresPatada(TACTICABRILLANTE);
                        partidaEnCurso.setPatadaInicial(TACTICABRILLANTE.getNombreEvento());
                    }
                    if (numeroIntroducido == 9) {
                        insertarValoresPatada(ANTICIPACION);
                        partidaEnCurso.setPatadaInicial(ANTICIPACION.getNombreEvento());
                    }
                    if (numeroIntroducido == 10) {
                        insertarValoresPatada(PENETRACION);
                        partidaEnCurso.setPatadaInicial(PENETRACION.getNombreEvento());

                    }
                    if (numeroIntroducido == 11) {
                        insertarValoresPatada(PEDRADA);
                        partidaEnCurso.setPatadaInicial(PEDRADA.getNombreEvento());
                    }
                    if (numeroIntroducido==12) {
                        insertarValoresPatada(INVASIONDELCAMPO);
                        partidaEnCurso.setPatadaInicial(INVASIONDELCAMPO.getNombreEvento());
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

    public void abrirPartida(View view) {
        Intent i = new Intent(this, GestionPartido.class);
        i.putExtra("partida", partidaEnCurso);
        startActivity(i);


    }
private void insertarValoresPatada(PatadaInicial patada){
    ((TextView) findViewById(nombre_evento)).setText(patada.getNombreEvento());
    ((TextView) findViewById(descripcion_evento)).setText(patada.getDescripcionEvento());
}
}
