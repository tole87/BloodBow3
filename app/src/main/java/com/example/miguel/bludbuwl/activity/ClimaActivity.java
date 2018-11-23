package com.example.miguel.bludbuwl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miguel.bludbuwl.Partida;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.reglas.Clima;

import java.util.Random;

import static android.view.View.*;
import static android.view.View.VISIBLE;
import static com.example.miguel.bludbuwl.R.id.boton_continuar_clima;
import static com.example.miguel.bludbuwl.R.id.descripcion_clima;
import static com.example.miguel.bludbuwl.R.id.nombre_clima;
import static com.example.miguel.bludbuwl.reglas.Clima.CALOR;
import static com.example.miguel.bludbuwl.reglas.Clima.LLUVIOSO;
import static com.example.miguel.bludbuwl.reglas.Clima.PERFECTO;
import static com.example.miguel.bludbuwl.reglas.Clima.SOLEADO;
import static com.example.miguel.bludbuwl.reglas.Clima.VENTISCA;

public class ClimaActivity extends AppCompatActivity {

    Partida partidaEnCurso;
    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2;
    private int contadorDado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima);


        rollDices = findViewById(R.id.tirar_dados);
        imageView1 = findViewById(R.id.dado_uno);
        imageView2 = findViewById(R.id.dado_dos);

        partidaEnCurso = (Partida) getIntent().getSerializableExtra("partida");

        rollDices.setOnClickListener(view -> {
            final Animation anim1 = AnimationUtils.loadAnimation(ClimaActivity.this, R.anim.shake);
            final Animation anim2 = AnimationUtils.loadAnimation(ClimaActivity.this, R.anim.shake);
            final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    contadorDado = 0;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    int value = randomDiceValue();
                    contadorDado +=  value;
                    int res = getResources().getIdentifier("dado_" + value, "drawable", "com.example.miguel.bludbuwl");

                    if (animation == anim1) {
                        imageView1.setImageResource(res);
                    } else if (animation == anim2) {
                        imageView2.setImageResource(res);
                    }

                    findViewById(nombre_clima).setVisibility(VISIBLE);
                    findViewById(descripcion_clima).setVisibility(VISIBLE);
                    findViewById(boton_continuar_clima).setVisibility(VISIBLE);
                    findViewById(R.id.tirar_dados).setVisibility(INVISIBLE);
                    try {
                        if (contadorDado == 2) {
                            insertarValoresPatada(CALOR);
                            partidaEnCurso.setClima(CALOR.getNombreClima());
                        }
                        if (contadorDado == 3) {
                            insertarValoresPatada(SOLEADO);
                            partidaEnCurso.setClima(SOLEADO.getNombreClima());
                        }
                        if (contadorDado > 3 && contadorDado < 11) {
                            insertarValoresPatada(PERFECTO);
                            partidaEnCurso.setClima(PERFECTO.getNombreClima());
                        }
                        if (contadorDado == 11) {
                            insertarValoresPatada(LLUVIOSO);
                            partidaEnCurso.setClima(LLUVIOSO.getNombreClima());
                        }
                        if (contadorDado == 12) {
                            insertarValoresPatada(VENTISCA);
                            partidaEnCurso.setClima(VENTISCA.getNombreClima());
                        }
                    } catch (Exception e) {
                        Log.e("Exception", "File write failed: " + e.toString());
                    }

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            };

            anim1.setAnimationListener(animationListener);
            anim2.setAnimationListener(animationListener);

            imageView1.startAnimation(anim1);
            imageView2.startAnimation(anim2);

        });


    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

    public void abrirPatadaInicial(View view) {
        Intent i = new Intent(this, PatadaInicialActivity.class);
        i.putExtra("partida", partidaEnCurso);
        startActivity(i);


    }

    private void insertarValoresPatada(Clima clima) {
        ((TextView) findViewById(nombre_clima)).setText(clima.getNombreClima());
        ((TextView) findViewById(descripcion_clima)).setText(clima.getDescripcionClima());
    }
}

