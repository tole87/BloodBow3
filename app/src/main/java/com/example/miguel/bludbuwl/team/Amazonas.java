package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Amazonas extends Equipo {

    public Amazonas() {
        this.ficha = R.drawable.amazonas_equipo;
        this.icono = R.drawable.amazonas_logo;
        this.nombre = R.string.amazonas;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 50000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre()))));
            jugadores.add(new Jugador("Receptor", 70000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre(), Habilidad.ATRAPAR.getNombre()))));
            jugadores.add(new Jugador("Lanzador", 70000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre(), Habilidad.PASAR.getNombre()))));
            jugadores.add(new Jugador("Blitzer", 90000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre(), Habilidad.PLACAR.getNombre()))));
        }
        return jugadores;
    }


}
