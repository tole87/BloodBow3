package com.example.miguel.bludbuwl;

import java.util.ArrayList;

public class Equipos {

    public static final int PRESUPUESTO = 1000000;
    private static final ArrayList<Equipo> equipos = new ArrayList<>();

    private Equipos() {
    }

    public static ArrayList<Equipo> getEquipos() {
        if (equipos.isEmpty()) {
            equipos.add(new Humanos());
            /**equipos.add(new Equipo(R.drawable.altos_elfos_equipo, R.drawable.altos_elfos_logo, R.string.altos_elfos_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.caos_equipo, R.drawable.caos_logo, R.string.caos_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.elfos_oscuros_equipo, R.drawable.elfos_oscuros_logo, R.string.elfos_oscuros_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.elfos_pro_equipo, R.drawable.elfos_pro_logo, R.string.elfos_pro_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.elfos_silvanos_equipo, R.drawable.elfos_silvanos_logo, R.string.elfos_silvanos_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.enanos_caos_equipo, R.drawable.enanos_caos_logo, R.string.enoanos_caos_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.goblins_equipo, R.drawable.goblins_logo, R.string.goblins_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.halfings_equipo, R.drawable.halfings_logo, R.string.halfings_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.hombres_lagarto_equipo, R.drawable.hombres_lagarto_logo, R.string.hombres_lagarto_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.khemri_equipo, R.drawable.khemri_logo, R.string.khemri_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.nigromantes_equipo, R.drawable.nigromantes_logo, R.string.nigromantes_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.no_muertos_equipo, R.drawable.no_muertos_logo, R.string.no_muertos_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.norses_equipo, R.drawable.norses_logo, R.string.norses_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.nurgle_equipo, R.drawable.nurgle_logo, R.string.nurgle_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.ogros_equipo, R.drawable.ogros_logo, R.string.ogros_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.orcos_equipo, R.drawable.orcos_logo, R.string.orcos_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.skaven_equipo, R.drawable.skaven_logo, R.string.skaven_nombre, PRESUPUESTO));
            equipos.add(new Equipo(R.drawable.vampiros_equipo, R.drawable.vampiros_logo, R.string.vampiros_nombre, PRESUPUESTO));*/
        }



        return equipos;
    }

}
