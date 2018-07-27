package com.example.miguel.bludbuwl.activity;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.miguel.bludbuwl.Alineacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Alineaciones {

    private static HashMap<String, Alineacion> alineaciones= new HashMap<>();
    public static final String BLUDBULW_ALINEACION_CREADAS_JSON = "BludbulwAlineacionCreadas.json";
    private static final Gson gson = new GsonBuilder().create();

    public static HashMap<String, Alineacion> readFromFile(Context context) {


        try (InputStream inputStream = context.openFileInput(BLUDBULW_ALINEACION_CREADAS_JSON)) {


            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                alineaciones = (HashMap<String, Alineacion>) gson.fromJson(bufferedReader, HashMap.class);
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return alineaciones;
    }

    public static void guardarAlineacion(Alineacion alineacion, Context context) {

        readFromFile(context);
        alineaciones.put(alineacion.getNombreEquipo(), alineacion);
//        final File path = Environment.getExternalStoragePublicDirectory (
//                //Environment.DIRECTORY_PICTURES
//                Environment.DIRECTORY_DOCUMENTS + "/Bludbuwl/"
//        );
//
//        if(!path.exists())
//        {
//            // Make it, if it doesn't exit
//            path.mkdirs();
//        }

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("bludbul.json", Context.MODE_PRIVATE))) {
            outputStreamWriter.write(gson.toJson(alineaciones));
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
