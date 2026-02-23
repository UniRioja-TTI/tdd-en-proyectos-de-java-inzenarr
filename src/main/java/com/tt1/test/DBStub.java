package com.tt1.test;

import java.util.*;

public class DBStub {
    private List<ToDo> tareas;
    private List<String> agendaEmails;

    public DBStub() {
        this.tareas = new ArrayList<>();
        this.agendaEmails = new ArrayList<>();
    }

    public void create(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<ToDo> read() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void update(int index, ToDo nuevaTarea) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void delete(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void agregarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
