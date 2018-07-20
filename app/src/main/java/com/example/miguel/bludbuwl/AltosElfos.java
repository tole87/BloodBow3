package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class AltosElfos extends Equipo{

    public AltosElfos() {
        this.ficha = R.drawable.altos_elfos_equipo;
        this.icono = R.drawable.altos_elfos_logo;
        this.nombre = R.string.altos_elfos_nombre;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 70000, 6, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Receptor", 90000, 8, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getNombre()))));
            jugadores.add(new Jugador("Lanzador", 90000, 6, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.PASESEGURO.getNombre(), Habilidad.PASAR.getNombre()))));
            jugadores.add(new Jugador("Blitzer", 100000, 7, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre()))));
        }
        return jugadores;
    }
}

