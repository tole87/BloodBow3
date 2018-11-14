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
            jugadores.add(new Jugador("Linea", 50000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getId())),16));
            jugadores.add(new Jugador("Receptor", 70000, 8, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getId(), Habilidad.ESQUIVAR.getId())),4));
            jugadores.add(new Jugador("Lanzador", 70000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.MANOSSEGURAS.getId(), Habilidad.PASAR.getId())),2));
            jugadores.add(new Jugador("Blitzer", 90000, 7, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getId())),4));
            jugadores.add(new Jugador("Ogro", 140000, 5, 5, 2, 9, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getId(), Habilidad.CABEZADURA.getId(), Habilidad.GOLPEMORTIFERO.getId(), Habilidad.CABEZAHUECA.getId(), Habilidad.LANZARCOMPAÑERO.getId())),1));
        }
        return jugadores;
    }

    @Override
    public Jugador obtenerJugadorPorPosicion(String posicion){
        return getJugadores()
                .stream()
                .filter(jugador -> jugador.getPosicion().equalsIgnoreCase(posicion))
                .findFirst()
                .get();
    }
}
