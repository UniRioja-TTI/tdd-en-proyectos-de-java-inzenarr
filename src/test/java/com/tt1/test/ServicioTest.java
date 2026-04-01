package com.tt1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    private Servicio servicio;

    @BeforeEach
    void setUp() {
        Repositorio repo = new Repositorio();
        ServicioConsumibleClient cliente = new ServicioConsumibleClient(new org.springframework.web.client.RestTemplate());
        servicio = new Servicio(repo, cliente);
    }

    @Test
    void crearToDo() {
        String nombre = "Terminar tests de Servicio";
        String fecha = "2026-06-15";

        // Verificamos que no explote al crear
        assertDoesNotThrow(() -> servicio.crearToDo(nombre, fecha),"El servicio debería permitir crear una tarea con nombre y fecha.");
    }

    @Test
    void addCorreo() {
        String email = "inzenarr@unirioja.es";

        assertDoesNotThrow(() -> servicio.addCorreo(email),"El servicio debería permitir registrar correos en la agenda.");
    }

    @Test
    void marcarCompletado() {
        // Creamos una tarea de prueba
        ToDo tarea = new ToDo("Terminar test de Servicio", "2026-03-10");

        // El servicio debería cambiar el estado de la tarea
        servicio.marcarCompletado(tarea);

        assertTrue(tarea.isCompletado(), "El servicio no marcó la tarea como completada.");
    }

    @Test
    void consultar() {
        // Escenario: Creamos una tarea y luego intentamos recuperarla
        String nombreTarea = "Mirar documentacion pr3";
        servicio.crearToDo(nombreTarea, "2026-04-01");

        ToDo busqueda = new ToDo(nombreTarea, "2026-04-01");
        ToDo resultado = servicio.consultar(busqueda);

        assertNotNull(resultado, "El servicio debería encontrar la tarea creada.");
        assertEquals(nombreTarea, resultado.getNombre());
    }
}