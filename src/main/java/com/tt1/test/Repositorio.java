package com.tt1.test;

import java.util.List;

public class Repositorio {
    private DBStub dbStub;

    public Repositorio() {
        this.dbStub = new DBStub();
    }

    public ToDo encontrar(ToDo toDo) {
        if (toDo == null) return null;

        List<ToDo> todas = dbStub.read();
        for (ToDo t : todas) {
            if (t.getNombre() != null && t.getNombre().equals(toDo.getNombre())) {
                return t;
            }
        }
        return null;
    }

    public void marcarCompletado(ToDo toDo) {
        ToDo encontrada = encontrar(toDo);
        if (encontrada != null) {
            encontrada.setCompletado(true);
        } else {
            toDo.setCompletado(true);
        }
    }

    public void addTodo(ToDo toDo) {
        if (toDo != null) {
            dbStub.create(toDo);
        }
    }

    public void addEmail(String email) {
        if (email != null) {
            dbStub.agregarEmail(email);
        }
    }
}