package com.tt1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioTest {

    private Repositorio repositorio;
    private ToDo tareaEjemplo;

    @BeforeEach
    void setUp() {
        repositorio = new Repositorio();
        tareaEjemplo = new ToDo("Lavar el coche", LocalDate.now().toString());
    }

    @Test
    void addTodo() {
        assertDoesNotThrow(() -> repositorio.addTodo(tareaEjemplo),"Debería poder añadir una tarea sin errores.");
    }

    @Test
    void encontrar() {
        repositorio.addTodo(tareaEjemplo);

        ToDo encontrada = repositorio.encontrar(tareaEjemplo);

        assertNotNull(encontrada, "La tarea debería existir en el repositorio.");
        assertEquals(tareaEjemplo.getNombre(), encontrada.getNombre());
    }

    @Test
    void marcarCompletado() {
        repositorio.addTodo(tareaEjemplo);

        assertFalse(tareaEjemplo.isCompletado(), "La tarea debería empezar como no completada.");

        repositorio.marcarCompletado(tareaEjemplo);

        assertTrue(tareaEjemplo.isCompletado(), "La tarea debería estar marcada como completada.");
    }

    @Test
    void addEmail() {
        String email = "inzenarr@unirioja.es";
        assertDoesNotThrow(() -> repositorio.addEmail(email),"El repositorio debería permitir añadir emails a la agenda.");
    }
}