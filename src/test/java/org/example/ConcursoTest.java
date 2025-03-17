package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConcursoTest {

    @Test
    public void seInscribeOk() {
        Participante p = new Participante(42708536, "Paula Agostinelli");
        Concurso c = new Concurso(LocalDate.now().plusDays(2), LocalDate.now().plusDays(7));
        c.inscribir(p);
        // boolean inscriptoOk= p.estaIncripto();
        assertTrue(c.estaIncripto(p));

    }

    @Test
    public void seIncribeDia1() {
        Participante p = new Participante(42708536, "Paula Agostinelli");
        Concurso c = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7));
        c.inscribir(p);
        assertTrue(c.inscriptoDiaUno(p));

    }

    @Test
    public void inscripcionFueraDeTermino() {
        Participante p = new Participante(42708536, "Paula Agostinelli");
        Concurso c = new Concurso(LocalDate.now(), LocalDate.now().plusDays(2));
        c.inscribir(p);
        assertTrue(c.inscriptoEnRango(p));

    }
}