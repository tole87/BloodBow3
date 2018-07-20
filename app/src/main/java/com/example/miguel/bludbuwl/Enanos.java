package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class Enanos extends Equipo {

    public Enanos() {
        this.ficha = R.drawable.enanos_equipo;
        this.icono = R.drawable.enanos_logo;
        this.nombre = R.string.enanos;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Defensas", 70000, 4, 3, 3, 9, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(),Habilidad.PLACAJEDEFENSIVO.getNombre(),Habilidad.CABEZADURA.getNombre()))));
            jugadores.add(new Jugador("Corredores", 80000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.MANOSSEGURAS.getNombre(), Habilidad.CABEZADURA.getNombre()))));
            jugadores.add(new Jugador("Blitzers", 80000, 5, 3, 3, 9, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.CABEZADURA.getNombre()))));
            jugadores.add(new Jugador("Matatrolls", 90000, 5, 3, 2, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre(), Habilidad.AGALLAS.getNombre(), Habilidad.FURIA.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.ANIMALSALVAJE.getNombre()))));
            jugadores.add(new Jugador("Apisonadora", 160000, 4, 7, 1, 10, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.ABRIRSEPASO.getNombre(), Habilidad.JUEGOSUCIO.getNombre(), Habilidad.JUGGERNAUT.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.SINMANOS.getNombre(), Habilidad.ARMASECRETA.getNombre(), Habilidad.MANTENERSEFIRME.getNombre()))));
        }
        return jugadores;
    }
}
