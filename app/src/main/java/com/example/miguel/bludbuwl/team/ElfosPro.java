package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class ElfosPro extends Equipo {

    public ElfosPro() {
        this.ficha = R.drawable.elfos_pro_equipo;
        this.icono = R.drawable.elfos_pro_logo;
        this.nombre = R.string.elfos_pro_nombre;
        this.precioReRoll = 50000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 60000, 6, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre())),16));
            jugadores.add(new Jugador("Receptor", 100000, 8, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PASAR.getNombre())),4));
            jugadores.add(new Jugador("Lanzador", 70000, 6, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getNombre(), Habilidad.NERVIOSDEACERO.getNombre())),2));
            jugadores.add(new Jugador("Blitzer", 110000, 7, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.ECHARSEAUNLADO.getNombre())),2));
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
