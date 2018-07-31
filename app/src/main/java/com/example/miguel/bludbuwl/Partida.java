package com.example.miguel.bludbuwl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Partida implements Serializable{

    private String equipoA;

    private String equipoB;
    private String clima;
    private int hinchas;

    public Partida() {
    }

    public String getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(String equipoA) {
        this.equipoA = equipoA;
    }

    public String getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(String equipoB) {
        this.equipoB = equipoB;
    }

    public void removeEquipoA(){
        this.equipoA = "";
    }

    public void removeEquipoB(){
        this.equipoB = "";
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
