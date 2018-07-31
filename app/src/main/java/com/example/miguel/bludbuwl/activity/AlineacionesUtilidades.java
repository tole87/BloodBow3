package com.example.miguel.bludbuwl.activity;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.miguel.bludbuwl.Alineacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

public class AlineacionesUtilidades {

    private static LinkedHashMap<String, Alineacion> alineaciones = new LinkedHashMap<>();
    public static final String BLUDBULW_ALINEACION_CREADAS_JSON = "BludbulwAlineaciones.json";
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static LinkedHashMap<String, Alineacion> readFromFile(Context context) {

        if (!new File(context.getFilesDir() + "/" + BLUDBULW_ALINEACION_CREADAS_JSON).exists()) {
            return alineaciones;
        }
        try (FileInputStream inputStream = context.openFileInput(BLUDBULW_ALINEACION_CREADAS_JSON)) {
            int size = inputStream.available();
            byte[] buffer = new byte[size];

            inputStream.read(buffer);
            String mResponse = new String(buffer);
            alineaciones = gson.fromJson(mResponse, new TypeToken<LinkedHashMap<String, Alineacion>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: ", e);
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: ", e);
        }

        return alineaciones;
    }

    public static void guardarAlineacion(Alineacion alineacion, Context context) {

        readFromFile(context);
        alineaciones.put(alineacion.getNombreEquipo(), alineacion);
        escribirAlineaciones(context);
    }

    public static void borrarAlineacion(String nombreEquipo, Context context) {
        readFromFile(context);
        alineaciones.remove(nombreEquipo);
        escribirAlineaciones(context);
    }

    private static void escribirAlineaciones(Context context) {
        try (FileOutputStream fos = context.openFileOutput("BludbulwAlineaciones.json", Context.MODE_PRIVATE)) {
            fos.write(gson.toJson(alineaciones).getBytes());
        } catch (IOException e) {
            Log.e("Exception", "File write failed: ", e);
        }
    }

    public static Alineacion obtenerAlineacionPorNombre(String nombreAlineacion){
        return alineaciones.get(nombreAlineacion);
    }

}