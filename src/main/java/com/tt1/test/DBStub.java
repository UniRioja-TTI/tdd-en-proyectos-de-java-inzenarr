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
        if (tarea != null) {
            this.tareas.add(tarea);
        }
    }

    public List<ToDo> read() {
        return new ArrayList<>(this.tareas);
    }

    public void update(int index, ToDo nuevaTarea) {
        if (index >= 0 && index < this.tareas.size() && nuevaTarea != null) {
            this.tareas.set(index, nuevaTarea);
        }
    }

    public void delete(ToDo tarea) {
        this.tareas.remove(tarea);
    }

    public void agregarEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.agendaEmails.add(email);
        }
    }
}