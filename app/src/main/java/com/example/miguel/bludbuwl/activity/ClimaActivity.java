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

import com.example.miguel.bludbuwl.R;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
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


        ((EditText) findViewById(tirada_clima)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Toast.makeText(ClimaActivity.this, s, Toast.LENGTH_SHORT).show();
                findViewById(nombre_clima).setVisibility(VISIBLE);
                findViewById(descripcion_clima).setVisibility(VISIBLE);
                try {
                    if (s.equals("")) {
                        findViewById(nombre_clima).setVisibility(INVISIBLE);
                        findViewById(descripcion_clima).setVisibility(INVISIBLE);
                    }
                    if (Integer.parseInt(s.toString()) == 2) {
                        ((TextView) findViewById(nombre_clima)).setText(CALOR.getNombreClima());
                        ((TextView) findViewById(descripcion_clima)).setText(CALOR.getDescripcionClima());
                    }
                    if (Integer.parseInt(s.toString()) == 3) {
                        ((TextView) findViewById(nombre_clima)).setText(SOLEADO.getNombreClima());
                        ((TextView) findViewById(descripcion_clima)).setText(SOLEADO.getDescripcionClima());
                    }
                    if (Integer.parseInt(s.toString()) > 3 && Integer.parseInt(s.toString()) < 11) {
                        ((TextView) findViewById(nombre_clima)).setText(PERFECTO.getNombreClima());
                        ((TextView) findViewById(descripcion_clima)).setText(PERFECTO.getDescripcionClima());
                    }
                    if (Integer.parseInt(s.toString()) == 11) {
                        ((TextView) findViewById(nombre_clima)).setText(LLUVIOSO.getNombreClima());
                        ((TextView) findViewById(descripcion_clima)).setText(LLUVIOSO.getDescripcionClima());
                    }
                    if (Integer.parseInt(s.toString()) == 12) {
                        ((TextView) findViewById(nombre_clima)).setText(VENTISCA.getNombreClima());
                        ((TextView) findViewById(descripcion_clima)).setText(VENTISCA.getDescripcionClima());
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

    public void abrirTiradaHinchas(View view){
        Intent i = new Intent(this, HinchasActivity.class);
        startActivity(i);


    }
}

