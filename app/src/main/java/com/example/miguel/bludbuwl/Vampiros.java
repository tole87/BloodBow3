package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class Vampiros extends Equipo {

    public Vampiros() {
        this.ficha = R.drawable.vampiros_equipo;
        this.icono = R.drawable.vampiros_logo;
        this.nombre = R.string.vampiros_nombre;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Siervos", 40000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Vampiros", 110000, 6, 4, 4, 8, new HashSet<>(Arrays.asList(Habilidad.SEDDESANGRE.getNombre(), Habilidad.MIRADAHIPNOTICA.getNombre(), Habilidad.REGENERACION.getNombre()))));

        }
        return jugadores;
    }
}
