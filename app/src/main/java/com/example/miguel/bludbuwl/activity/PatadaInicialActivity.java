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
import com.example.miguel.bludbuwl.reglas.PatadaInicial;

import java.util.Random;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.miguel.bludbuwl.R.id.boton_continuar_evento;
import static com.example.miguel.bludbuwl.R.id.descripcion_evento;
import static com.example.miguel.bludbuwl.R.id.nombre_evento;
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
    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2;
    private int contadorDado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_patada_inicial);

        rollDices = findViewById(R.id.tirar_dados);
        imageView1 = findViewById(R.id.dado_uno);
        imageView2 = findViewById(R.id.dado_dos);

        partidaEnCurso = (Partida) getIntent().getSerializableExtra("partida");

        rollDices.setOnClickListener(view -> {
            final Animation anim1 = AnimationUtils.loadAnimation(PatadaInicialActivity.this, R.anim.shake);
            final Animation anim2 = AnimationUtils.loadAnimation(PatadaInicialActivity.this, R.anim.shake);
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

                    findViewById(nombre_evento).setVisibility(VISIBLE);
                    findViewById(descripcion_evento).setVisibility(VISIBLE);
                    findViewById(boton_continuar_evento).setVisibility(VISIBLE);
                    findViewById(R.id.tirar_dados).setVisibility(INVISIBLE);
                    try {
                        if (contadorDado == 2) {
                            insertarValoresPatada(APORELARBITRO);
                            partidaEnCurso.setPatadaInicial(APORELARBITRO.getNombreEvento());
                        }
                        if (contadorDado == 3) {
                            insertarValoresPatada(DISTURBIOS);
                            partidaEnCurso.setPatadaInicial(DISTURBIOS.getNombreEvento());
                        }
                        if (contadorDado == 4) {
                            insertarValoresPatada(DEFENSAPERFECTA);
                            partidaEnCurso.setPatadaInicial(DEFENSAPERFECTA.getNombreEvento());
                        }
                        if (contadorDado == 5) {
                            insertarValoresPatada(PATADAALTA);
                            partidaEnCurso.setPatadaInicial(PATADAALTA.getNombreEvento());
                        }
                        if (contadorDado == 6) {
                            insertarValoresPatada(LOSHINCHASANIMAN);
                            partidaEnCurso.setPatadaInicial(LOSHINCHASANIMAN.getNombreEvento());
                        }
                        if (contadorDado == 7) {
                            insertarValoresPatada(TIEMPOVARIABLE);
                            partidaEnCurso.setPatadaInicial(TIEMPOVARIABLE.getNombreEvento());
                        }
                        if (contadorDado == 8) {
                            insertarValoresPatada(TACTICABRILLANTE);
                            partidaEnCurso.setPatadaInicial(TACTICABRILLANTE.getNombreEvento());
                        }
                        if (contadorDado == 9) {
                            insertarValoresPatada(ANTICIPACION);
                            partidaEnCurso.setPatadaInicial(ANTICIPACION.getNombreEvento());
                        }
                        if (contadorDado == 10) {
                            insertarValoresPatada(PENETRACION);
                            partidaEnCurso.setPatadaInicial(PENETRACION.getNombreEvento());

                        }
                        if (contadorDado == 11) {
                            insertarValoresPatada(PEDRADA);
                            partidaEnCurso.setPatadaInicial(PEDRADA.getNombreEvento());
                        }
                        if (contadorDado==12) {
                            insertarValoresPatada(INVASIONDELCAMPO);
                            partidaEnCurso.setPatadaInicial(INVASIONDELCAMPO.getNombreEvento());
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
