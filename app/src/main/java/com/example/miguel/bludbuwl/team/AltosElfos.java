package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

import static java.util.Collections.singletonList;

public class AltosElfos extends Equipo{

    public AltosElfos() {
        this.ficha = R.drawable.altos_elfos_equipo;
        this.icono = R.drawable.altos_elfos_logo;
        this.nombre = R.string.altos_elfos_nombre;
        this.precioReRoll = 50000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 70000, 6, 3, 4, 8, new HashSet<>(singletonList(Habilidad.NINGUNA.getId())),16));
            jugadores.add(new Jugador("Receptor", 90000, 8, 3, 4, 7, new HashSet<>(singletonList(Habilidad.ATRAPAR.getId())),4));
            jugadores.add(new Jugador("Lanzador", 90000, 6, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.PASESEGURO.getId(), Habilidad.PASAR.getId())),2));
            jugadores.add(new Jugador("Blitzer", 100000, 7, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getId())),2));
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

