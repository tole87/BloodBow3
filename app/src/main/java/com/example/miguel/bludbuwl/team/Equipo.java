package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Jugador;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;

public abstract class Equipo implements Serializable {
    int ficha;
    int icono;
    int nombre;
    int precioReRoll;
    public final static int PRESUPUESTO = 1000000;
    final LinkedHashSet<Jugador> jugadores = new LinkedHashSet<>();

    public abstract HashSet<Jugador> getJugadores();

    public abstract Jugador obtenerJugadorPorPosicion(String posicion);

    public int getFicha() {
        return ficha;
    }

    public int getIcono() {
        return icono;
    }

    public int getNombre() {
        return nombre;
    }

    public int getPrecioReRoll() {
        return precioReRoll;
    }

    @Override
    public String toString() {
        return String.valueOf(icono);
    }
}
