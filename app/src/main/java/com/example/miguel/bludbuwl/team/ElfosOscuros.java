package com.example.miguel.bludbuwl.team;

import com.example.miguel.bludbuwl.player.Habilidad;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.player.Jugador;

import java.util.Arrays;
import java.util.HashSet;

public class ElfosOscuros extends Equipo {
    public ElfosOscuros() {
        this.ficha = R.drawable.elfos_oscuros_equipo;
        this.icono = R.drawable.elfos_oscuros_logo;
        this.nombre = R.string.elfos_oscuros_nombre;
        this.precioReRoll = 50000;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Linea", 70000, 6, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.NINGUNA.getNombre())),16));
            jugadores.add(new Jugador("Corredores", 80000, 7, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PASEPRECIPITADO.getNombre())),2));
            jugadores.add(new Jugador("Asesinos", 90000, 6, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.PERSEGUIR.getNombre(), Habilidad.PUÑAL.getNombre())),2));
            jugadores.add(new Jugador("Blitzers", 100000, 7, 3, 4, 8, new HashSet<>(Arrays.asList(Habilidad.PLACAR.getNombre())),4));
            jugadores.add(new Jugador("Brujas Elfas", 110000, 7, 3, 4, 7, new HashSet<>(Arrays.asList(Habilidad.FURIA.getNombre(),Habilidad.ESQUIVAR.getNombre(),Habilidad.ENPIEDEUNSALTO.getNombre())),2));
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
