package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Halflings extends Equipo {

    public Halflings() {
        this.ficha = R.drawable.halfings_equipo;
        this.icono = R.drawable.halfings_logo;
        this.nombre = R.string.halfings_nombre;
        this.precioReRoll = 60000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {

            jugadores.add(new Jugador("Halflings", 30000, 5, 2, 3, 6, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre(), Habilidad.AGILIDADFELINA.getNombre(), Habilidad.ESCURRIDIZO.getNombre()))));
            jugadores.add(new Jugador("Hombre Arbol", 120000, 2, 6, 1, 10, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.MANTENERSEFIRME.getNombre(), Habilidad.BRAZOFUERTE.getNombre(), Habilidad.ECHARRAICES.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.LANZARCOMPAÑERO.getNombre()))));
        }
        return jugadores;
    }
}
