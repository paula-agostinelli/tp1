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
    private Map<Participante, LocalDate> inscripciones; //

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }


    public void inscribir(Participante p) {
        LocalDate fechaInscripcion = LocalDate.now();
        if (fechaInscripcion.isBefore(fechaInicio) || fechaInscripcion.isAfter(fechaFin)) {
            throw new IllegalStateException("Inscripción fuera del rango permitido.");
        }

        if (!participantes.contains(p)) {
            this.participantes.add(p);
            this.inscripciones.put(p, LocalDate.now());
            if (fechaInscripcion.isEqual(fechaInicio)) {
                p.sumarPuntos(10);
            }
        }

    }

    public LocalDate obtenerFechaIncripcion(Participante p) {

        return this.inscripciones.get(p);
    }


    public boolean inscriptoDiaUno(Participante p) {
        LocalDate fechaInscripcion = obtenerFechaIncripcion(p);
        return fechaInscripcion != null && fechaInscripcion.isEqual(fechaInicio);

    }
}
