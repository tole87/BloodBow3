package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class ElfosSilvanos extends Equipo{

    public ElfosSilvanos() {
        this.ficha = R.drawable.elfos_silvanos_equipo;
        this.icono = R.drawable.elfos_silvanos_logo;
        this.nombre = R.string.elfos_silvanos_nombre;
        this.precioReRoll = 50000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 70000, 7, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre())),16));
            jugadores.add(new Jugador("Receptor", 90000, 8, 2, 4, 7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getNombre(), Habilidad.ESQUIVAR.getNombre(), Habilidad.CARRERA.getNombre())),4));
            jugadores.add(new Jugador("Lanzador", 90000, 7, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PASAR.getNombre())),2));
            jugadores.add(new Jugador("Bailarines Guerrero", 120000, 8, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.ESQUIVAR.getNombre(),Habilidad.SALTAR.getNombre())),2));
            jugadores.add(new Jugador("Hombre Arbol", 120000, 2, 6, 1, 10, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.MANTENERSEFIRME.getNombre(), Habilidad.BRAZOFUERTE.getNombre(), Habilidad.ECHARRAICES.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.LANZARCOMPAÑERO.getNombre())),1));
        }
        return jugadores;
    }
}
