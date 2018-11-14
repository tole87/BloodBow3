package com.example.miguel.bludbuwl.moneda;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miguel.bludbuwl.Partida;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.activity.ClimaActivity;

import java.util.Random;

public class MonedaActivity extends AppCompatActivity {

    Partida partidaEnCurso;
    private ImageView coinImage;
    private Button tirarMoneda;
    private Button continuarClima;
    private TextView eleccionTextView;

    private Random r;
    private int coinSide;
//    private MediaPlayer mp;
    private int curSide = R.drawable.heads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneda);

        r = new Random();

        coinImage = findViewById(R.id.coin);
        eleccionTextView  = findViewById(R.id.equipo_comienza);
        tirarMoneda = findViewById(R.id.lanzar_moneda);
        continuarClima = findViewById(R.id.ir_clima);

        partidaEnCurso = (Partida) getIntent().getSerializableExtra("partida");
    }

    public void abrirTiradaClima(View view) {
        Intent i = new Intent(this, ClimaActivity.class);
        i.putExtra("partida", partidaEnCurso);
        startActivity(i);


    }



    private long animateCoin(boolean stayTheSame) {

        Rotate3dAnimation animation;

        if (curSide == R.drawable.heads) {
            animation = new Rotate3dAnimation(coinImage, R.drawable.heads, R.drawable.tails, 0, 180, 0, 0, 0, 0);
        } else {
            animation = new Rotate3dAnimation(coinImage, R.drawable.tails, R.drawable.heads, 0, 180, 0, 0, 0, 0);
        }
        if (stayTheSame) {
            animation.setRepeatCount(5); // must be odd (5+1 = 6 flips so the side will stay the same)
        } else {
            animation.setRepeatCount(6); // must be even (6+1 = 7 flips so the side will not stay the same)
        }

        animation.setDuration(110);
        animation.setInterpolator(new LinearInterpolator());


        coinImage.startAnimation(animation);


        tirarMoneda.setVisibility(View.INVISIBLE);

        return animation.getDuration() * (animation.getRepeatCount() + 1);
    }

    public void flipCoin(View v) {


        coinSide = r.nextInt(2);

//        stopPlaying();
//        mp = MediaPlayer.create(this, R.raw.coin_flip);
//        mp.start();

        if (coinSide == 0) {  // We have Tails

            boolean stayTheSame = (curSide == R.drawable.tails);
            long timeOfAnimation = animateCoin(stayTheSame);
            curSide = R.drawable.tails;

            final Handler handler = new Handler();
            handler.postDelayed(() -> {

                continuarClima.setVisibility(View.VISIBLE);
                eleccionTextView.setVisibility(View.VISIBLE);
                eleccionTextView.setText(String.valueOf(partidaEnCurso.getEquipoB())+" Decide ");
            }, timeOfAnimation + 100);


        } else {  // We have Heads

            boolean stayTheSame = (curSide == R.drawable.heads);
            long timeOfAnimation = animateCoin(stayTheSame);
            curSide = R.drawable.heads;

            final Handler handler = new Handler();
            handler.postDelayed(() -> {



                continuarClima.setVisibility(View.VISIBLE);
                eleccionTextView.setVisibility(View.VISIBLE);
                eleccionTextView.setText(String.valueOf(partidaEnCurso.getEquipoA())+" Decide ");

            }, timeOfAnimation + 100);

        }

    }

//    private void stopPlaying() {
//        if (mp != null) {
//            mp.stop();
//            mp.release();
//            mp = null;
//        }
//    }
}
