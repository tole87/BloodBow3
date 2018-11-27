package com.example.miguel.bludbuwl;

import com.example.miguel.bludbuwl.player.Jugador;
import com.example.miguel.bludbuwl.team.Equipo;
import com.example.miguel.bludbuwl.team.Equipos;

import java.util.LinkedHashMap;
import java.util.Map;

public class Alineacion {

    private String nombreEquipo;
    private int tipoEquipo;
    private int iconoEquipo;
    private int presupuestoRestante;
    private int reRolls;
    private final LinkedHashMap<String, Integer> jugadores = new LinkedHashMap<>();
    private boolean medico;
    private int factorHinchas;
    private int animadoras;
    private int ayudanteEntrenador;


    public Alineacion(Equipo equipo) {
        this.iconoEquipo = equipo.getIcono();
        this.presupuestoRestante = Equipo.PRESUPUESTO;
        this.tipoEquipo = equipo.getNombre();
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void setPresupuestoRestante(int presupuestoRestante) {
        this.presupuestoRestante = presupuestoRestante;
    }

    public void setReRolls(int reRolls) {
        this.reRolls = reRolls;
    }

    public int getTipoEquipo() {
        return tipoEquipo;
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

    public LinkedHashMap<String, Integer> getJugadores() {
        return jugadores;
    }

    public boolean isMedico() {
        return medico;
    }


    public void setMedico(boolean medico) {
        this.medico = medico;
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
        if (!jugadores.containsKey(jugador.getPosicion())) {
            jugadores.put(jugador.getPosicion(), 1);
        } else {
            jugadores.put(jugador.getPosicion(), jugadores.get(jugador.getPosicion()) + 1);
        }
    }

    public void deletePlayer(Jugador jugador) {
        if (jugadores.get(jugador.getPosicion()) == 1) {
            jugadores.remove(jugador.getPosicion());
        } else {
            jugadores.put(jugador.getPosicion(), jugadores.get(jugador.getPosicion()) - 1);
        }
    }

    public int getNumPlayers(Jugador jugador) {
        return jugadores.get(jugador.getPosicion());
    }

    public boolean existeJugador(Jugador jugador) {
        return jugadores.containsKey(jugador.getPosicion());
    }

    public LinkedHashMap<Jugador, Integer> obtenerJugadoresCompletos(){

        LinkedHashMap<Jugador, Integer> jugadoresCompletos = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : jugadores.entrySet()) {

            jugadoresCompletos.put(Equipos.obtenerEquipoPorNombre(String.valueOf(tipoEquipo)).obtenerJugadorPorPosicion(entry.getKey()),entry.getValue());
        }

        return jugadoresCompletos;
    }
    
    
    @Override
    public String toString() {
        return nombreEquipo + ',' + String.valueOf(iconoEquipo) + ',' + presupuestoRestante + ',' + jugadores + ',' + reRolls + ',' + medico + ',' + factorHinchas + ',' + animadoras + ',' + ayudanteEntrenador + '\n';

    }
}
