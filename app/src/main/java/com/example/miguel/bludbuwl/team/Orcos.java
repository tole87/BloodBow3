package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class Orcos extends Equipo {

    public Orcos() {
        this.ficha = R.drawable.orcos_equipo;
        this.icono = R.drawable.orcos_logo;
        this.nombre = R.string.orcos_nombre;
        this.precioReRoll = 60000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 50000, 5, 3, 3, 9, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Goblin", 40000, 6, 2, 3, 7, new HashSet<>(Arrays.asList(Habilidad.AGILIDADFELINA.getNombre(), Habilidad.ESQUIVAR.getNombre(), Habilidad.ESCURRIDIZO.getNombre()))));
            jugadores.add(new Jugador("Lanzador", 70000, 5, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.MANOSSEGURAS.getNombre(), Habilidad.PASAR.getNombre()))));
            jugadores.add(new Jugador("Defensa Orco Negro", 80000, 4, 4, 2, 9, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre()))));
            jugadores.add(new Jugador("Blitzer", 80000, 6, 3, 3, 9, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre()))));
            jugadores.add(new Jugador("Troll", 110000, 4, 5, 1, 9, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.SIEMPREHAMBRIENTO.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.REALMENTEESTUPIDO.getNombre(), Habilidad.REGENERACION.getNombre(), Habilidad.LANZARCOMPAÑERO.getNombre()))));

        }
        return jugadores;
    }
}
