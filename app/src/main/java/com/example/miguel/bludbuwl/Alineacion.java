package com.example.miguel.bludbuwl;

import com.example.miguel.bludbuwl.player.Jugador;

import java.util.LinkedHashMap;

public class Alineacion{

    private String nombreEquipo;
    private String razaEquipo;
    private int presupuestoRestante;
    private int reRolls;
    private LinkedHashMap <Jugador,Integer> jugadoresAlineacion;
    private boolean Medico;
    private int  factorHinchas;
    private int animadoras;
    private int ayudanteEntrenador;


    public Alineacion(String razaEquipo, int presupuestoRestante) {

        this.razaEquipo = razaEquipo;
        this.presupuestoRestante = presupuestoRestante;

    }

    public void setPresupuestoRestante(int presupuestoRestante) {
        this.presupuestoRestante = presupuestoRestante;
    }

    public void setReRolls(int reRolls) {
        this.reRolls = reRolls;
    }

    public void setJugadoresAlineacion(LinkedHashMap<Jugador, Integer> jugadoresAlineacion) {
        this.jugadoresAlineacion = jugadoresAlineacion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getRazaEquipo() {
        return razaEquipo;
    }

    public int getPresupuestoRestante() {
        return presupuestoRestante;
    }

    public int getReRolls() {
        return reRolls;
    }

    public LinkedHashMap<Jugador, Integer> getJugadoresAlineacion() {
        return jugadoresAlineacion;
    }

    public boolean isMedico() {
        return Medico;
    }

    public void setMedico(boolean medico) {
        Medico = medico;
    }

    public int getFactorHinchas() {
        return factorHinchas;
    }

    public void setFactorHinchas(int factorHinchas) {
        this.factorHinchas = factorHinchas;
    }

    public int getAnimadoras() {
        return animadoras;
    }

    public void setAnimadoras(int animadoras) {
        this.animadoras = animadoras;
    }

    public int getAyudanteEntrenador() {
        return ayudanteEntrenador;
    }

    public void setAyudanteEntrenador(int ayudanteEntrenador) {
        this.ayudanteEntrenador = ayudanteEntrenador;
    }
}
