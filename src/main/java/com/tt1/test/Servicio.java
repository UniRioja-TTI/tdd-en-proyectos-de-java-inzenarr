package com.tt1.test;

public class Servicio {
    private Repositorio repositorio;
    private MailerStub mailer;

    public Servicio() {
        this.repositorio = new Repositorio();
        this.mailer = new MailerStub();
    }

    public void crearToDo(String nombre, String fechalimite) {
        ToDo nuevaTarea = new ToDo(nombre, fechalimite);
        repositorio.addTodo(nuevaTarea);
    }

    public void addCorreo(String s) {
        if (s != null && !s.isEmpty()) {
            repositorio.addEmail(s);
        }
    }

    public void marcarCompletado(ToDo toDo) {
        if (toDo != null) {
            repositorio.marcarCompletado(toDo);
        }
    }

    public ToDo consultar(ToDo toDo) {
        if (toDo == null) {
            return null;
        }
        return repositorio.encontrar(toDo);
    }
}