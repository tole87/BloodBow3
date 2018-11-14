package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class NoMuertos extends Equipo {

    public NoMuertos() {
        this.ficha = R.drawable.no_muertos_equipo;
        this.icono = R.drawable.no_muertos_logo;
        this.nombre = R.string.no_muertos_nombre;
        this.precioReRoll = 70000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Esqueletos", 40000, 5, 3, 2, 7, new HashSet<>(Arrays.asList(Habilidad.CABEZADURA.getId(), Habilidad.REGENERACION.getId())),16));
            jugadores.add(new Jugador("Zombis", 40000, 4, 3, 2, 8, new HashSet<>(Arrays.asList(Habilidad.REGENERACION.getId())),16));
            jugadores.add(new Jugador("Necrofagos", 70000, 7, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getId())),4));
            jugadores.add(new Jugador("Tumularios", 90000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getId(), Habilidad.REGENERACION.getId())),2));
            jugadores.add(new Jugador("Hombres Lobo Nigrománticos", 120000, 3, 5, 1, 9, new HashSet<>(Arrays.asList(Habilidad.GOLPEMORTIFERO.getId(), Habilidad.REGENERACION.getId())),2));

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
