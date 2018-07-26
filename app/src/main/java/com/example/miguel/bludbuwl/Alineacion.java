package com.example.miguel.bludbuwl;

import com.example.miguel.bludbuwl.player.Jugador;
import com.example.miguel.bludbuwl.team.Equipo;

import java.util.LinkedHashMap;

public class Alineacion {

    private String nombreEquipo;
    private int iconoEquipo;
    private int presupuestoRestante;
    private int reRolls;
    private final LinkedHashMap<Jugador, Integer> jugadores = new LinkedHashMap<>();
    private boolean Medico;
    private int factorHinchas;
    private int animadoras;
    private int ayudanteEntrenador;


    public Alineacion(Equipo equipo) {
        this.iconoEquipo = equipo.getIcono();
        this.presupuestoRestante = Equipo.PRESUPUESTO;
    }

    public void setPresupuestoRestante(int presupuestoRestante) {
        this.presupuestoRestante = presupuestoRestante;
    }

    public void setReRolls(int reRolls) {
        this.reRolls = reRolls;
    }


    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public int getIconoEquipo() {
        return iconoEquipo;
    }

    public int getPresupuestoRestante() {
        return presupuestoRestante;
    }

    public int getReRolls() {
        return reRolls;
    }

    public LinkedHashMap<Jugador, Integer> getJugadores() {
        return jugadores;
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

    public void addPlayer(Jugador jugador) {
        if (!jugadores.containsKey(jugador)) {
            jugadores.put(jugador, 0);
        }
        jugadores.put(jugador, jugadores.get(jugador) + 1);
    }

    public void deletePlayer(Jugador jugador) {
        if (jugadores.get(jugador)==1) {
            jugadores.remove(jugador);
        }
        jugadores.put(jugador, jugadores.get(jugador) - 1);
    }

    public int getNumPlayers(Jugador jugador) {
        return jugadores.get(jugador);
    }
}
