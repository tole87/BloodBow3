package com.example.miguel.bludbuwl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.miguel.bludbuwl.activity.GestionEquipoMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirMenuEquipos(View view){
        Intent i = new Intent(this, GestionEquipoMenu.class);
        startActivity(i);


    }
}
