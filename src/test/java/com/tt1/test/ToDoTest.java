package com.tt1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {

    private ToDo tarea;
    private final String NOMBRE_INICIAL = "Practica3";
    private final LocalDate FECHA_INICIAL = LocalDate.now().plusDays(1);

    @BeforeEach
    void setUp() {
        tarea = new ToDo(NOMBRE_INICIAL, FECHA_INICIAL.toString());
    }

    @Test
    void getNombre() {
        assertEquals(NOMBRE_INICIAL, tarea.getNombre(), "El nombre debería coincidir con el del constructor.");
    }

    @Test
    void setNombre() {
        String nuevoNombre = "Practica3_test";
        tarea.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, tarea.getNombre(), "El nombre debería haberse actualizado.");
    }

    @Test
    void getDescripcion() {
        assertEquals("", tarea.getDescripcion(), "La descripción inicial debería estar vacía.");
    }

    @Test
    void setDescripcion() {
        String desc = "Ir a hacer la practica 3";
        tarea.setDescripcion(desc);
        assertEquals(desc, tarea.getDescripcion());
    }

    @Test
    void getFechalimite() {
        assertEquals(FECHA_INICIAL, tarea.getFechalimite());
    }

    @Test
    void setFechalimite() {
        LocalDate nuevaFecha = LocalDate.of(2025, 12, 31);
        tarea.setFechalimite(nuevaFecha);
        assertEquals(nuevaFecha, tarea.getFechalimite());
    }

    @Test
    void isCompletado() {
        assertFalse(tarea.isCompletado(), "Una tarea nueva no debería estar completada.");
    }

    @Test
    void setCompletado() {
        tarea.setCompletado(true);
        assertTrue(tarea.isCompletado(), "La tarea debería marcarse como completada.");
    }
}