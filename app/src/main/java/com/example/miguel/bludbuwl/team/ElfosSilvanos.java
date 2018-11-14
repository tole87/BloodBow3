package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class ElfosSilvanos extends Equipo{

    public ElfosSilvanos() {
        this.ficha = R.drawable.elfos_silvanos_equipo;
        this.icono = R.drawable.elfos_silvanos_logo;
        this.nombre = R.string.elfos_silvanos_nombre;
        this.precioReRoll = 50000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 70000, 7, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getId())),16));
            jugadores.add(new Jugador("Receptor", 90000, 8, 2, 4, 7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getId(), Habilidad.ESQUIVAR.getId(), Habilidad.CARRERA.getId())),4));
            jugadores.add(new Jugador("Lanzador", 90000, 7, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PASAR.getId())),2));
            jugadores.add(new Jugador("Bailarines Guerrero", 120000, 8, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getId(), Habilidad.ESQUIVAR.getId(),Habilidad.SALTAR.getId())),2));
            jugadores.add(new Jugador("Hombre Arbol", 120000, 2, 6, 1, 10, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getId(), Habilidad.GOLPEMORTIFERO.getId(), Habilidad.MANTENERSEFIRME.getId(), Habilidad.BRAZOFUERTE.getId(), Habilidad.ECHARRAICES.getId(), Habilidad.CABEZADURA.getId(), Habilidad.LANZARCOMPAÑERO.getId())),1));
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
