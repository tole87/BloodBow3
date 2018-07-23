package com.example.miguel.bludbuwl;

import java.io.Serializable;
import java.util.HashSet;

public abstract class Equipo implements Serializable{
    int ficha;
    int icono;
    int nombre;
    private final static int presupuesto = 1000000;
    final HashSet<Jugador> jugadores = new HashSet<>();

    public abstract HashSet<Jugador> getJugadores();

    public int getFicha() {
        return ficha;
    }

    public int getIcono() {
        return icono;
    }

    public int getNombre() {
        return nombre;
    }

    public static int getPresupuesto() {
        return presupuesto;
    }


}
