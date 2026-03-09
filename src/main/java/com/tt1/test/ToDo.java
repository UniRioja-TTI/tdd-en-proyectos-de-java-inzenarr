package com.tt1.test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDo implements Serializable {
    private String nombre;
    private String descripcion;
    private String fechalimite;
    private boolean completado;

    // para los tests, para convertir String a LocalDate y al reves
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    public ToDo(){
        super();
    }

    public ToDo(String nombre, String fechalimite) {
        super();
        this.nombre = nombre;
        this.descripcion = "";
        this.fechalimite = fechalimite;
        this.completado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechalimite() {
        return (fechalimite != null) ? LocalDate.parse(fechalimite, FORMATTER) : null;
    }

    public void setFechalimite(LocalDate fechalimite) {
        this.fechalimite = (fechalimite != null) ? fechalimite.format(FORMATTER) : null;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    // Es recomendable añadir equals para que el Repositorio pueda encontrar objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return nombre.equals(toDo.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}