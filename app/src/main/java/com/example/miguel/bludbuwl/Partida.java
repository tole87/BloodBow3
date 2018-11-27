package com.example.miguel.bludbuwl;

import java.io.Serializable;

public class Partida implements Serializable {

    private String equipoA;
    private String equipoB;
    private String clima;
    private String patadaInicial;
    private int scoreA;
    private int scoreB;
    private int reRollsA;
    private int reRollsB;


    public Partida() {
    }

    public int getReRollsB() {
        return reRollsB;
    }

    public void setReRollsB(int reRollsB) {
        this.reRollsB = reRollsB;
    }

    public int getReRollsA() {

        return reRollsA;
    }

    public void setReRollsA(int reRollsA) {
        this.reRollsA = reRollsA;
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

    public int getScoreA() {
        return scoreA;
    }

    public void sumaGolA() {
        this.scoreA = scoreA+1;
    }
    public void sumaGolB() {
        this.scoreB = scoreB+1;
    }

    public void restaGolA() {
        if(scoreA>0){
        this.scoreA = scoreA-1;}
    }
    public void restaGolB() {
        if(scoreB>0){
        this.scoreB = scoreB-1;}
    }


    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }
}
