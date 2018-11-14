package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Goblins extends Equipo {

    public Goblins() {
        this.ficha = R.drawable.goblins_equipo;
        this.icono = R.drawable.goblins_logo;
        this.nombre = R.string.goblins_nombre;
        this.precioReRoll = 60000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Goblins", 40000, 6, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getId(), Habilidad.AGILIDADFELINA.getId(), Habilidad.ESCURRIDIZO.getId())),16));
            jugadores.add(new Jugador("Bombardero", 40000, 6, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.BOMBARDERO.getId(), Habilidad.ESQUIVAR.getId(), Habilidad.ARMASECRETA.getId(), Habilidad.ESCURRIDIZO.getId())),1));
            jugadores.add(new Jugador("Chiflado", 40000, 6, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.SIERRAMECANICA.getId(), Habilidad.ARMASECRETA.getId(), Habilidad.ESCURRIDIZO.getId())),1));
            jugadores.add(new Jugador("Fanatico", 70000, 3, 7, 3, 7, new HashSet<>(Arrays.asList(Habilidad.BOLACONCADENA.getId(), Habilidad.SINMANOS.getId(), Habilidad.ARMASECRETA.getId(), Habilidad.GOLPEMORTIFERO.getId(), Habilidad.CABEZADURA.getId(), Habilidad.ANIMALSALVAJE.getId())),1));
            jugadores.add(new Jugador("Pogo", 70000, 7, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getId(), Habilidad.SALTAR.getId(), Habilidad.ESCURRIDIZO.getId(), Habilidad.PIERNASMUYLARGAS.getId())),1));
            jugadores.add(new Jugador("Trolls", 110000, 4, 5, 1, 9, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getId(), Habilidad.SIEMPREHAMBRIENTO.getId(), Habilidad.GOLPEMORTIFERO.getId(), Habilidad.REALMENTEESTUPIDO.getId(), Habilidad.REGENERACION.getId(), Habilidad.LANZARCOMPAÑERO.getId())),2));
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
