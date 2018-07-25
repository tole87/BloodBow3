package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Humanos extends Equipo {

    public Humanos() {
        this.ficha = R.drawable.humanos_equipo;
        this.icono = R.drawable.humanos_logo;
        this.nombre = R.string.humanos;
        this.precioReRoll = 50000;
    }

    @Override
    public LinkedHashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 50000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre())),16));
            jugadores.add(new Jugador("Receptor", 70000, 8, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getNombre(), Habilidad.ESQUIVAR.getNombre())),4));
            jugadores.add(new Jugador("Lanzador", 70000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.MANOSSEGURAS.getNombre(), Habilidad.PASAR.getNombre())),2));
            jugadores.add(new Jugador("Blitzer", 90000, 7, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre())),4));
            jugadores.add(new Jugador("Ogro", 140000, 5, 5, 2, 9, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.CABEZAHUECA.getNombre(), Habilidad.LANZARCOMPAÑERO.getNombre())),1));
        }
        return jugadores;
    }
}
