package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class ElfosSilvanos extends Equipo{

    public ElfosSilvanos() {
        this.ficha = R.drawable.elfos_silvanos_equipo;
        this.icono = R.drawable.elfos_silvanos_logo;
        this.nombre = R.string.elfos_silvanos_nombre;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 70000, 7, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Receptor", 90000, 8, 2, 4, 7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getNombre(), Habilidad.ESQUIVAR.getNombre(), Habilidad.CARRERA.getNombre()))));
            jugadores.add(new Jugador("Lanzador", 90000, 7, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PASAR.getNombre()))));
            jugadores.add(new Jugador("Bailarines Guerrero", 120000, 8, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.ESQUIVAR.getNombre(),Habilidad.SALTAR.getNombre()))));
            jugadores.add(new Jugador("Hombre Arbol", 120000, 2, 6, 1, 10, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.MANTENERSEFIRME.getNombre(), Habilidad.BRAZOFUERTE.getNombre(), Habilidad.ECHARRAICES.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.LANZARCOMPAÑERO.getNombre()))));
        }
        return jugadores;
    }
}
