package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ConcursoTest {

    @Test
    public void seInscribeOk() {
        Participante p = new Participante(42708536, "Paula Agostinelli");
        Concurso c = new Concurso(LocalDate.now().plusDays(2), LocalDate.now().plusDays(7));
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            c.inscribir(p);  // Se espera que se lance una excepción si la fecha de inscripción está fuera del rango
        });

        // Verificamos que el mensaje de la excepción sea el esperado
        assertTrue(exception.getMessage().contains("Inscripción fuera del rango permitido."));

        //c.inscribir(p);
        // assertTrue(c.estaIncripto(p));

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
        Concurso c = new Concurso(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            c.inscribir(p);
        });

        assertTrue(exception.getMessage().contains("Inscripción fuera del rango permitido."));
    }

    /*@Test
    public void inscripcionFueraDeTermino() {
        Participante p = new Participante(42708536, "Paula Agostinelli");
        Concurso c = new Concurso(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        c.inscribir(p);
        assertTrue(c.inscriptoEnRango(p));

    }*/
}