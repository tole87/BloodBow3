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
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Goblins", 40000, 6, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre(), Habilidad.AGILIDADFELINA.getNombre(), Habilidad.ESCURRIDIZO.getNombre()))));
            jugadores.add(new Jugador("Bombardero", 40000, 6, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.BOMBARDERO.getNombre(), Habilidad.ESQUIVAR.getNombre(), Habilidad.ARMASECRETA.getNombre(), Habilidad.ESCURRIDIZO.getNombre()))));
            jugadores.add(new Jugador("Chiflado", 40000, 6, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.SIERRAMECANICA.getNombre(), Habilidad.ARMASECRETA.getNombre(), Habilidad.ESCURRIDIZO.getNombre()))));
            jugadores.add(new Jugador("Fanatico", 70000, 3, 7, 3, 7, new HashSet<>(Arrays.asList(Habilidad.BOLACONCADENA.getNombre(), Habilidad.SINMANOS.getNombre(), Habilidad.ARMASECRETA.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.CABEZADURA.getNombre(), Habilidad.ANIMALSALVAJE.getNombre()))));
            jugadores.add(new Jugador("Pogo", 70000, 7, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.ESQUIVAR.getNombre(), Habilidad.SALTAR.getNombre(), Habilidad.ESCURRIDIZO.getNombre(), Habilidad.PIERNASMUYLARGAS.getNombre()))));
            jugadores.add(new Jugador("Trolls", 110000, 4, 5, 1, 9, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.SIEMPREHAMBRIENTO.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.REALMENTEESTUPIDO.getNombre(), Habilidad.REGENERACION.getNombre(), Habilidad.LANZARCOMPAÑERO.getNombre()))));
        }
        return jugadores;
    }
}
