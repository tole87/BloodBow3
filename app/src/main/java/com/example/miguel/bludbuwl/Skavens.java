package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class Skavens extends Equipo {

    public Skavens() {
        this.ficha = R.drawable.skaven_equipo;
        this.icono = R.drawable.skaven_logo;
        this.nombre = R.string.skaven_nombre;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 50000, 7, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Corredor Alcantarilla", 70000, 7, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.PASAR.getNombre(), Habilidad.MANOSSEGURAS.getNombre()))));
            jugadores.add(new Jugador("Lanzador", 80000, 9, 2, 4, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre()))));
            jugadores.add(new Jugador("Blitzer", 90000, 7, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre()))));
            jugadores.add(new Jugador("Troll", 150000, 6, 5, 2, 8, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.FURIA.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.COLAPRENSIL.getNombre(), Habilidad.ANIMALSALVAJE.getNombre()))));

        }
        return jugadores;
    }
}
