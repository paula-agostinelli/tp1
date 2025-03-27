package org.example;

public class Participante {
    private int dni;
    private String nombre;
    private int puntos;

    public Participante(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.puntos = 0;

    }

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
    }

}
