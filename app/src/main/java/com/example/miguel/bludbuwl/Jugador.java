package com.example.miguel.bludbuwl;

import java.util.ArrayList;
import java.util.HashSet;

public class Jugador{

    private String posicion;
    private int salario;
    private int moviemiento;
    private int fuerza;
    private int agilidad;
    private int armadura;
    private HashSet<String> habilidades;

    private int nivel;
    private int pje;

    public Jugador(String posicion, int salario, int moviemiento, int fuerza, int agilidad, int armadura, HashSet<String> habilidades) {
        this.posicion = posicion;
        this.salario = salario;
        this.moviemiento = moviemiento;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.armadura = armadura;
        this.habilidades = habilidades;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getMoviemiento() {
        return moviemiento;
    }

    public void setMoviemiento(int moviemiento) {
        this.moviemiento = moviemiento;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public HashSet<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(HashSet<String> habilidades) {
        this.habilidades = habilidades;
    }
}
