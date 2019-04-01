package com.example.miguel.bludbuwl.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.activity.GestionPartido;

import java.util.Locale;

/**
 * Created by tutlane on 09-01-2018.
 */

public class FragmentPartido extends Fragment {

    private static final long START_TIME_IN_MILLIS = 210000;


    private TextView marcadorEquipoATextView;
    private Button sumaGolEquipoAButton;
    private TextView marcadorEquipoBTextView;
    private Button sumaGolEquipoBButton;
    private Button restaGolEquipoAButton;
    private Button restaGolEquipoBButton;
    private TextView cronometroTextView;
    private Button startPauseButton;
    private Button resetButton;

    private CountDownTimer countDownTimer;

    private boolean isTimerRunning;

//    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    private long timeLeftInMillis = (GestionPartido.partidaEnCurso.getMinutos()*60000)+(GestionPartido.partidaEnCurso.getSegundos()*1000);

    private MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View partidoView = inflater.inflate(R.layout.partido_en_curso, viewGroup, false);



        cronometroTextView = partidoView.findViewById(R.id.text_view_countdown);
        startPauseButton = partidoView.findViewById(R.id.button_start_pause);
        resetButton = partidoView.findViewById(R.id.button_reset);
        sumaGolEquipoAButton = partidoView.findViewById(R.id.gol_equipo_a);
        marcadorEquipoATextView = partidoView.findViewById(R.id.marcador_equipo_a);
        sumaGolEquipoBButton = partidoView.findViewById(R.id.gol_equipo_b);
        marcadorEquipoBTextView = partidoView.findViewById(R.id.marcador_equipo_b);
        restaGolEquipoAButton = partidoView.findViewById(R.id.resta_gol_equipo_a);
        restaGolEquipoBButton = partidoView.findViewById(R.id.resta_gol_equipo_b);

        sumaGolEquipoAButton.setOnClickListener(v -> {
            GestionPartido.partidaEnCurso.sumaGolA();
            marcadorEquipoATextView.setText(String.valueOf(GestionPartido.partidaEnCurso.getScoreA()));
        });
        sumaGolEquipoBButton.setOnClickListener(v -> {
            GestionPartido.partidaEnCurso.sumaGolB();
            marcadorEquipoBTextView.setText(String.valueOf(GestionPartido.partidaEnCurso.getScoreB()));
        });

        restaGolEquipoAButton.setOnClickListener(v -> {
            GestionPartido.partidaEnCurso.restaGolA();
            marcadorEquipoATextView.setText(String.valueOf(GestionPartido.partidaEnCurso.getScoreA()));
        });
        restaGolEquipoBButton.setOnClickListener(v -> {
            GestionPartido.partidaEnCurso.restaGolB();
            marcadorEquipoBTextView.setText(String.valueOf(GestionPartido.partidaEnCurso.getScoreB()));
        });

        startPauseButton.setOnClickListener(v -> {
            if (isTimerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        resetButton.setOnClickListener(v -> resetTimer());

        updateCountDownText();
        return partidoView;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                isTimerRunning = false;
                startPauseButton.setText("Start");
                startPauseButton.setVisibility(View.INVISIBLE);
                resetButton.setVisibility(View.VISIBLE);
                mp = MediaPlayer.create(getContext(), R.raw.airhorn);
                mp.start();
            }
        }.start();

        isTimerRunning = true;
        startPauseButton.setText("pause");
        resetButton.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        isTimerRunning = false;
        startPauseButton.setText("Start");
        resetButton.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        resetButton.setVisibility(View.INVISIBLE);
        startPauseButton.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        cronometroTextView.setText(timeLeftFormatted);
    }

}