package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Caos extends Equipo {

    public Caos() {
        this.ficha = R.drawable.caos_equipo;
        this.icono = R.drawable.caos_logo;
        this.nombre = R.string.caos_nombre;
        this.precioReRoll = 60000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Hombres Bestia", 60000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.CUERNOS.getNombre())),16));
            jugadores.add(new Jugador("Guerreros del Caos", 100000, 5, 4, 3, 9, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre())),4));
            jugadores.add(new Jugador("Minotauro", 150000, 5, 5, 2, 8, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.FURIA.getNombre(),Habilidad.CUERNOS.getNombre(),Habilidad.GOLPEMORTIFERO.getNombre(),Habilidad.CABEZADURA.getNombre(),Habilidad.ANIMALSALVAJE.getNombre())),1));
        }
        return jugadores;
    }
}
