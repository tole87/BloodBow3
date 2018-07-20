package com.example.miguel.bludbuwl;

import java.util.Arrays;
import java.util.HashSet;

public class Nurgle extends Equipo {

    public Nurgle() {
        this.ficha = R.drawable.nurgle_equipo;
        this.icono = R.drawable.nurgle_logo;
        this.nombre = R.string.nurgle_nombre;
    }

    @Override
    public HashSet<Jugador> getJugadores() {
        if (jugadores.isEmpty()) {
            //Aqui instancio jugadores
            jugadores.add(new Jugador("Putrefactos", 40000, 5, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.DEGENERAR.getNombre(), Habilidad.PUTREFACCIONDENURGLE.getNombre()))));
            jugadores.add(new Jugador("Pestigors", 80000, 6, 3, 3, 8, new HashSet<>(Arrays.asList(Habilidad.CUERNOS.getNombre(), Habilidad.PUTREFACCIONDENURGLE.getNombre(), Habilidad.REGENERACION.getNombre()))));
            jugadores.add(new Jugador("Guerreros de Nurgle", 110000, 4, 4, 2, 9, new HashSet<>(Arrays.asList(Habilidad.PRESENCIAPERTURBADORA.getNombre(), Habilidad.APARIENCIAASQUEROSA.getNombre(), Habilidad.PUTREFACCIONDENURGLE.getNombre(), Habilidad.REGENERACION.getNombre()))));
            jugadores.add(new Jugador("Bestia de Nurgle", 140000, 4, 5, 1, 9, new HashSet<>(Arrays.asList(Habilidad.SOLITARIO.getNombre(), Habilidad.PRESENCIAPERTURBADORA.getNombre(), Habilidad.APARIENCIAASQUEROSA.getNombre(), Habilidad.GOLPEMORTIFERO.getNombre(), Habilidad.PUTREFACCIONDENURGLE.getNombre(), Habilidad.REALMENTEESTUPIDO.getNombre(), Habilidad.REGENERACION.getNombre(), Habilidad.TENTACULOS.getNombre()))));

        }
        return jugadores;
    }
}
