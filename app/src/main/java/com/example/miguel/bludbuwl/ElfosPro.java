package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class ElfosPro extends Equipo {

    public ElfosPro() {
        this.ficha = R.drawable.elfos_pro_equipo;
        this.icono = R.drawable.elfos_pro_logo;
        this.nombre = R.string.elfos_pro_nombre;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 60000, 6, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Receptor", 100000, 8, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PASAR.getNombre()))));
            jugadores.add(new Jugador("Lanzador", 70000, 6, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getNombre(), Habilidad.NERVIOSDEACERO.getNombre()))));
            jugadores.add(new Jugador("Blitzer", 110000, 7, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.ECHARSEAUNLADO.getNombre()))));
        }
        return jugadores;
    }
}
