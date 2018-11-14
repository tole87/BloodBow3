package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class HombresLagarto extends Equipo {

    public HombresLagarto() {
        this.ficha = R.drawable.hombres_lagarto_equipo;
        this.icono = R.drawable.hombres_lagarto_logo;
        this.nombre = R.string.hombres_lagarto_nombre;
        this.precioReRoll = 60000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Eslizones", 60000, 8, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getId(), Habilidad.ESCURRIDIZO.getId())),16));
            jugadores.add(new Jugador("Saurios", 80000, 6, 4, 1, 9, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getId())),6));
            jugadores.add(new Jugador("Kroxigor", 140000, 6, 5, 1, 9, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getId(), Habilidad.CABEZAHUECA.getId(), Habilidad.GOLPEMORTIFERO.getId(), Habilidad.CABEZADURA.getId(), Habilidad.COLAPRENSIL.getId())),1));
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
