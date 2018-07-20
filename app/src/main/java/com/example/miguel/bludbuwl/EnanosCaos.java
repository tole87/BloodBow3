package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class EnanosCaos extends Equipo {

    public EnanosCaos() {
        this.ficha = R.drawable.enanos_caos_equipo;
        this.icono = R.drawable.enanos_caos_logo;
        this.nombre = R.string.enanos_caos_nombre;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Hobgoblins", 40000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Defensas Enanos del Caos", 70000, 4, 3, 2, 9, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.PLACAJEDEFENSIVO.getNombre()))));
            jugadores.add(new Jugador("Centauros Toro", 130000, 6, 4, 2, 9, new HashSet<>(Arrays.asList(Habilidad.CARRERA.getNombre(), Habilidad.PIESFIRMES.getNombre(), Habilidad.CABEZADURA.getNombre()))));
            jugadores.add(new Jugador("Minotauro", 150000, 5, 5, 2, 8, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.FURIA.getNombre(), Habilidad.CUERNOS.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.ANIMALSALVAJE.getNombre()))));
        }
        return jugadores;
    }
}
