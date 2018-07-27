package com.example.miguel.bludbuwl.activity;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.miguel.bludbuwl.Alineacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Alineaciones {

    private static LinkedHashMap<String, Alineacion> alineaciones = new LinkedHashMap<>();
    public static final String BLUDBULW_ALINEACION_CREADAS_JSON = "BludbulwAlineaciones.json";
    private static final Gson gson = new GsonBuilder().create();

    public static LinkedHashMap<String, Alineacion> readFromFile(Context context) {

        try (InputStream inputStream = context.openFileInput(BLUDBULW_ALINEACION_CREADAS_JSON)) {

            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                alineaciones = (LinkedHashMap<String, Alineacion>) gson.fromJson(bufferedReader, HashMap.class);
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

        try (BufferedWriter bwriter = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "BludbulwAlineaciones.json"))))) {
            bwriter.write(gson.toJson(alineaciones));
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static void borrarAlineacion (String nombreEquipo, Context context){
        readFromFile(context);
        alineaciones.remove(nombreEquipo);

        try (BufferedWriter bwriter = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "BludbulwAlineaciones.json"))))) {
            bwriter.write(gson.toJson(alineaciones));
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
