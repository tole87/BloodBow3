package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class Khemri extends Equipo {

    public Khemri() {
        this.ficha = R.drawable.khemri_equipo;
        this.icono = R.drawable.khemri_logo;
        this.nombre = R.string.khemri_nombre;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Esqueletos", 40000, 5, 3, 2, 7, new HashSet<>(Arrays.asList(Habilidad.REGENERACION.getNombre(), Habilidad.CABEZADURA.getNombre()))));
            jugadores.add(new Jugador("Thro-Ras", 70000, 6, 3, 2, 7, new HashSet<>(Arrays.asList(Habilidad.PASAR.getNombre(), Habilidad.REGENERACION.getNombre(), Habilidad.MANOSSEGURAS.getNombre()))));
            jugadores.add(new Jugador("Blitz-Ras", 90000, 6, 3, 2, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.REGENERACION.getNombre()))));
            jugadores.add(new Jugador("Guardianes de la Tumba", 100000, 4, 5, 1, 9, new HashSet<>(Arrays.asList(Habilidad.REGENERACION.getNombre(), Habilidad.DEGENERAR.getNombre()))));

        }
        return jugadores;
    }
}
