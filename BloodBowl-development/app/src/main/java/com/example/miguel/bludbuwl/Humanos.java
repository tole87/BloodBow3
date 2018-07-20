package com.example.miguel.bludbuwl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Humanos extends Equipo {

    public Humanos() {
        this.ficha = R.drawable.humanos_equipo;
        this.icono = R.drawable.humanos_logo;
        this.nombre = R.string.humanos;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if(jugadores.isEmpty()){
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea",50000,6,3,3,8, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Receptor",70000,8,2,3,7, new HashSet<>(Arrays.asList(Habilidad.ATRAPAR.getNombre(),Habilidad.ESQUIVAR.getNombre()))));
            jugadores.add(new Jugador("Lanzador",70000,6,3,3,8, new HashSet<>(Arrays.asList(Habilidad.MANOSSEGURAS.getNombre(),Habilidad.PASAR.getNombre()))));
            jugadores.add(new Jugador("Blitzer",90000,7,3,3,8, new HashSet<>(Arrays.asList(Habilidad.PLARCAR.getNombre()))));
            jugadores.add(new Jugador("Ogro",140000,5,5,2,9, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(),Habilidad.CABEZADURA.getNombre(),Habilidad.GOLPEMORTIFERO.getNombre(),Habilidad.CABEZAHUECA.getNombre(),Habilidad.LANZARCOMPAÑERO.getNombre()))));
        }
        return jugadores;
    }
}
