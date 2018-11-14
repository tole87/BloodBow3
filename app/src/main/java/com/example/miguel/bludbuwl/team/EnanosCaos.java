package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class EnanosCaos extends Equipo {

    public EnanosCaos() {
        this.ficha = R.drawable.enanos_caos_equipo;
        this.icono = R.drawable.enanos_caos_logo;
        this.nombre = R.string.enanos_caos_nombre;
        this.precioReRoll = 70000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Hobgoblins", 40000, 6, 3, 3, 7, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getId())),16));
            jugadores.add(new Jugador("Defensas Enanos del Caos", 70000, 4, 3, 2, 9, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getId(), Habilidad.PLACAJEDEFENSIVO.getId())),6));
            jugadores.add(new Jugador("Centauros Toro", 130000, 6, 4, 2, 9, new HashSet<>(Arrays.asList(Habilidad.CARRERA.getId(), Habilidad.PIESFIRMES.getId(), Habilidad.CABEZADURA.getId())),2));
            jugadores.add(new Jugador("Minotauro", 150000, 5, 5, 2, 8, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getId(), Habilidad.FURIA.getId(), Habilidad.CUERNOS.getId(), Habilidad.GOLPEMORTIFERO.getId(), Habilidad.CABEZADURA.getId(), Habilidad.ANIMALSALVAJE.getId())),1));
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
