package com.tt1.test;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Service
public class Servicio {
    private final Repositorio repositorio;
    private final ServicioConsumibleClient apiCliente; // Cliente para la VM

    //spring inyecta los componentes
    public Servicio(Repositorio repositorio, ServicioConsumibleClient apiCliente) {
        this.repositorio = repositorio;
        this.apiCliente = apiCliente;
    }

    //este es el que llama a SolicitudController (Punto 5 y 6)
    @GetMapping("/solicitud")
    public int manejarSolicitud(List<Integer> cantidades) {
        List<String> entidades = List.of("Entidad_Alfa", "Entidad_Beta", "Entidad_Gamma");
        int token = new Random().nextInt(10000);
        //conexion con la maquina virtual
        apiCliente.enviarSolicitud("inzenarr", entidades, cantidades);
        return token;
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