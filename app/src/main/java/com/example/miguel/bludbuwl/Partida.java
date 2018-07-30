package com.example.miguel.bludbuwl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Partida implements Serializable {

    private List<Alineacion> alineaciones = Arrays.asList(new Alineacion[2]);
    private String clima;
    private int hinchas;

    public Partida() {
    }

    public List<Alineacion> getAlineaciones() {
        return alineaciones;
    }

    public void setAlineaciones(Alineacion alineacion) {
        alineaciones.add(alineacion);
    }
    public void removeAlineaciones(Alineacion alineacion){
        alineaciones.remove(alineacion);
    }
    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public int getHinchas() {
        return hinchas;
    }

    public void setHinchas(int hinchas) {
        this.hinchas = hinchas;
    }
}
