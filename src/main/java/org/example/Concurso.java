package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concurso {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Participante> participantes;
    private Map<Participante, LocalDate> inscripciones; // Mapea cada participante con su fecha de inscripción

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }


    public void inscribir(Participante p) {
        if (!participantes.contains(p)) {
            this.participantes.add(p);
            this.inscripciones.put(p, LocalDate.now());
        }

    }

    public boolean estaIncripto(Participante p) {
        return this.participantes.contains(p);
    }

    public LocalDate obtenerFechaIncripcion(Participante p) {

        return this.inscripciones.get(p);
    }

    public boolean inscriptoEnRango(Participante p) {
        LocalDate fechaInscripcion = obtenerFechaIncripcion(p);
        return fechaInscripcion != null &&
                !fechaInscripcion.isBefore(fechaInicio) &&
                !fechaInscripcion.isAfter(fechaFin);
    }

    public boolean inscriptoDiaUno(Participante p) {
        LocalDate fechaInscripcion = obtenerFechaIncripcion(p);
        return fechaInscripcion != null && fechaInscripcion.isEqual(fechaInicio);
    }
}
