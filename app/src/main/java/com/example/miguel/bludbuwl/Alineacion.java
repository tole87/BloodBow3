package com.example.miguel.bludbuwl;

import com.example.miguel.bludbuwl.player.Jugador;

import java.util.LinkedHashMap;

public class Alineacion{

    private String nombreEquipo;
    private String razaEquipo;
    private int presupuestoRestante;
    private int numeroReRolls;
    private LinkedHashMap <Jugador,Integer> jugadoresAlineacion;

    public Alineacion(String razaEquipo, int presupuestoRestante) {

        this.razaEquipo = razaEquipo;
        this.presupuestoRestante = presupuestoRestante;

    }

    public void setPresupuestoRestante(int presupuestoRestante) {
        this.presupuestoRestante = presupuestoRestante;
    }

    public void setNumeroReRolls(int numeroReRolls) {
        this.numeroReRolls = numeroReRolls;
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

    public int getNumeroReRolls() {
        return numeroReRolls;
    }

    public LinkedHashMap<Jugador, Integer> getJugadoresAlineacion() {
        return jugadoresAlineacion;
    }
}
