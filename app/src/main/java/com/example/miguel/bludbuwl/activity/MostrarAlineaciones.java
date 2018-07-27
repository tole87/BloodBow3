package com.example.miguel.bludbuwl.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miguel.bludbuwl.Alineacion;
import com.example.miguel.bludbuwl.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class MostrarAlineaciones extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_creados);

        HashMap<String,Alineacion> archivo = Alineaciones.readFromFile(this);
     ((TextView) findViewById(R.id.alineacion_guardada)).setText(archivo.toString());
        Toast.makeText(this, archivo.keySet().toString(), Toast.LENGTH_SHORT).show();

    }


}

