package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Nigromantes extends Equipo {

    public Nigromantes() {
        this.ficha = R.drawable.nigromantes_equipo;
        this.icono = R.drawable.nigromantes_logo;
        this.nombre = R.string.nigromantes_nombre;
        this.precioReRoll = 70000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Zombis", 40000, 4, 3, 2, 8, new HashSet<>(Arrays.asList(Habilidad.REGENERACION.getNombre())),16));
            jugadores.add(new Jugador("Necrofagos", 70000, 7, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre())),2));
            jugadores.add(new Jugador("Tumularios", 90000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.REGENERACION.getNombre())),2));
            jugadores.add(new Jugador("Golems de Carne", 110000, 4, 4, 2, 9, new HashSet<>(Arrays.asList(Habilidad.REGENERACION.getNombre(), Habilidad.MANTENERSEFIRME.getNombre(), Habilidad.CABEZADURA.getNombre())),2));
            jugadores.add(new Jugador("Hombres Lobo Nigrománticos", 120000, 8, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.GARRAS.getNombre(), Habilidad.FURIA.getNombre(), Habilidad.REGENERACION.getNombre())),2));

        }
        return jugadores;
    }
}
