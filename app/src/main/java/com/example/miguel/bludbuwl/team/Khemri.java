package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Khemri extends Equipo {

    public Khemri() {
        this.ficha = R.drawable.khemri_equipo;
        this.icono = R.drawable.khemri_logo;
        this.nombre = R.string.khemri_nombre;
        this.precioReRoll = 70000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Esqueletos", 40000, 5, 3, 2, 7, new HashSet<>(Arrays.asList(Habilidad.REGENERACION.getNombre(), Habilidad.CABEZADURA.getNombre())),16));
            jugadores.add(new Jugador("Thro-Ras", 70000, 6, 3, 2, 7, new HashSet<>(Arrays.asList(Habilidad.PASAR.getNombre(), Habilidad.REGENERACION.getNombre(), Habilidad.MANOSSEGURAS.getNombre())),2));
            jugadores.add(new Jugador("Blitz-Ras", 90000, 6, 3, 2, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.REGENERACION.getNombre())),2));
            jugadores.add(new Jugador("Guardianes de la Tumba", 100000, 4, 5, 1, 9, new HashSet<>(Arrays.asList(Habilidad.REGENERACION.getNombre(), Habilidad.DEGENERAR.getNombre())),4));

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
