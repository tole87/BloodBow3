package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Norses extends Equipo {

    public Norses() {
        this.ficha = R.drawable.norses_equipo;
        this.icono = R.drawable.norses_logo;
        this.nombre = R.string.norses_nombre;
        this.precioReRoll = 60000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 50000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre()))));
            jugadores.add(new Jugador("Lanzador", 70000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.PASAR.getNombre()))));
            jugadores.add(new Jugador("Corredor", 90000, 7, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.AGALLAS.getNombre()))));
            jugadores.add(new Jugador("Berserker", 90000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.FURIA.getNombre(), Habilidad.ENPIEDEUNSALTO.getNombre()))));
            jugadores.add(new Jugador("Hombres Lobo Nordicos", 110000, 6, 4, 2, 8, new HashSet<>(Arrays.asList(Habilidad.FURIA.getNombre()))));
            jugadores.add(new Jugador("Yehti", 140000, 5, 5, 1, 8, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.GARRAS.getNombre(), Habilidad.PRESENCIAPERTURBADORA.getNombre(), Habilidad.FURIA.getNombre(), Habilidad.ANIMALSALVAJE.getNombre()))));

        }
        return jugadores;
    }
}
