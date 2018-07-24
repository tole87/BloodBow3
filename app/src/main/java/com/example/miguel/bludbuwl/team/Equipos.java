package com.example.miguel.bludbuwl.team;

import java.util.ArrayList;

public class Equipos {

    private static final ArrayList<Equipo> equipos = new ArrayList<>();

    private Equipos() {
    }

    public static ArrayList<Equipo> getEquipos() {
        if (equipos.isEmpty()) {
            equipos.add(new Humanos());
            equipos.add(new AltosElfos());
            equipos.add(new Amazonas());
            equipos.add(new Caos());
            equipos.add(new ElfosOscuros());
            equipos.add(new ElfosPro());
            equipos.add(new ElfosSilvanos());
            equipos.add(new EnanosCaos());
            equipos.add(new Enanos());
            equipos.add(new Goblins());
            equipos.add(new Halflings());
            equipos.add(new HombresLagarto());
            equipos.add(new Khemri());
            equipos.add(new Nigromantes());
            equipos.add(new NoMuertos());
            equipos.add(new Norses());
            equipos.add(new Nurgle());
            equipos.add(new Ogros());
            equipos.add(new Orcos());
            equipos.add(new Skavens());
            equipos.add(new Vampiros());

        }



        return equipos;
    }

}
