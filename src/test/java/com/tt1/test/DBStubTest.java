package com.tt1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DBStubTest {

    private DBStub db;
    private ToDo tareaEjemplo;

    @BeforeEach
    void setUp() {
        db = new DBStub();
        tareaEjemplo = new ToDo("Terminar pr3 Transversal", "2026-12-31");
    }

    @Test
    void create() {
        db.create(tareaEjemplo);
        List<ToDo> lista = db.read();

        assertEquals(1, lista.size(), "La lista debería tener un elemento tras el create.");
        assertEquals(tareaEjemplo, lista.get(0), "La tarea guardada no coincide con la creada.");
    }

    @Test
    void read() {
        assertNotNull(db.read(), "El método read no debería devolver null.");

        db.create(tareaEjemplo);
        db.create(new ToDo("Terminar test DBStub", "2026-01-01"));

        assertEquals(2, db.read().size(), "Read debería devolver todos los elementos insertados.");
    }

    @Test
    void update() {
        db.create(tareaEjemplo);
        ToDo nuevaTarea = new ToDo("Tarea Actualizada", "2026-05-05");

        db.update(0, nuevaTarea);

        assertEquals("Tarea Actualizada", db.read().get(0).getNombre(), "La tarea en el índice 0 no se actualizó.");
    }

    @Test
    void delete() {
        db.create(tareaEjemplo);
        assertFalse(db.read().isEmpty());

        db.delete(tareaEjemplo);

        assertTrue(db.read().isEmpty(), "La lista debería estar vacía tras borrar la única tarea.");
    }

    @Test
    void agregarEmail() {
        String email = "inzenarr@unirioja.es";
        db.agregarEmail(email);

        assertDoesNotThrow(() -> db.agregarEmail("inzenarr@unirioja.es"), "No debería fallar al agregar un email.");
    }
}