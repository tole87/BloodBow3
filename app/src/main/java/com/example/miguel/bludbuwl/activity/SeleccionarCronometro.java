package com.example.miguel.bludbuwl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.miguel.bludbuwl.Partida;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.moneda.MonedaActivity;

public class SeleccionarCronometro extends AppCompatActivity {

    Partida partidaEnCurso;
    private TextView minutos, segundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_cronometro);

        partidaEnCurso = (Partida) getIntent().getSerializableExtra("partida");
        minutos = findViewById(R.id.minutos);
        segundos = findViewById(R.id.segundos);

    }


        public void sumaMinutos(View v) {
        partidaEnCurso.sumaMinuto();
        minutos.setText(String.valueOf(partidaEnCurso.getMinutos()));
        }

        public void restaMinutos(View v) {
        partidaEnCurso.restaMinuto();
        minutos.setText(String.valueOf(partidaEnCurso.getMinutos()));
        }

    public void sumaSegundos(View v) {
        partidaEnCurso.sumaSegundo();
        segundos.setText(String.valueOf(partidaEnCurso.getSegundos()));
    }

    public void restaSegundos(View v) {
        partidaEnCurso.restaSegundo();
        segundos.setText(String.valueOf(partidaEnCurso.getSegundos()));
    }

    public void botonSiguienteMoneda(View view) {
            Intent intent = new Intent(getApplicationContext(), MonedaActivity.class);
            intent.putExtra("partida", partidaEnCurso);
            startActivity(intent);
        }


}
