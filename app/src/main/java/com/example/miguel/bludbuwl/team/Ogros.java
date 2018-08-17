package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Ogros extends Equipo {


    public Ogros() {
        this.ficha = R.drawable.ogros_equipo;
        this.icono = R.drawable.ogros_logo;
        this.nombre = R.string.ogros_nombre;
        this.precioReRoll = 70000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Snotlings", 20000, 5, 1, 3, 5, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre(), Habilidad.AGILIDADFELINA.getNombre(), Habilidad.ECHARSEAUNLADO.getNombre(), Habilidad.ESCURRIDIZO.getNombre(), Habilidad.CANIJO.getNombre())),16));
            jugadores.add(new Jugador("Ogros", 140000, 5, 5, 2, 9, new HashSet<>(Arrays.asList(Habilidad.CABEZAHUECA.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.LANZARCOMPAÑERO.getNombre())),6));

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
