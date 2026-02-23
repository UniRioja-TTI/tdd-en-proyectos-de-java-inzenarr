package com.tt1.test;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable {
    private String nombre;
    private String descripcion;
    private String fechalimite;
    private boolean completado;

    public ToDo(){
        super();
    }

    public ToDo(String nombre,String fechalimite) {
        super();
        this.nombre = nombre;
        this.descripcion = "";
        this.fechalimite = fechalimite;
        this.completado = false;
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setNombre(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public String getDescripcion() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setDescripcion(String descripcion) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public LocalDate getFechalimite() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setFechalimite(LocalDate fechalimite) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    // Nota: El estándar para booleanos es "is"
    public boolean isCompletado() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void setCompletado(boolean completado) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }


}
