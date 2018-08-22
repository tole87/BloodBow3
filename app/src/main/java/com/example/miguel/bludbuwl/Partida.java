package com.example.miguel.bludbuwl;

import java.io.Serializable;

public class Partida implements Serializable {

    private String equipoA;

    private String equipoB;
    private String clima;
    private String patadaInicial;

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

    public void removeEquipoA() {
        this.equipoA = "";
    }

    public void removeEquipoB() {
        this.equipoB = "";
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getPatadaInicial() {
        return patadaInicial;
    }

    public void setPatadaInicial(String patadaInicial) {
        this.patadaInicial = patadaInicial;
    }
}
