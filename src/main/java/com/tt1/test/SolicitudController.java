package com.tt1.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SolicitudController {

    private final Servicio servicio;

    // Spring inyecta tu clase Servicio aquí
    public SolicitudController(Servicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/solicitud")
    public String mostrarFormulario(Model model) {
        // Estas son las entidades que tu Servicio espera (Alfa, Beta, Gamma)
        model.addAttribute("entidades", List.of("Entidad_Alfa", "Entidad_Beta", "Entidad_Gamma"));
        return "solicitud";
    }

    @PostMapping("/solicitud")
    public String procesar(@RequestParam Map<String, String> formData, Model model) {
        List<Integer> cantidades = new ArrayList<>();

        // Convertimos los datos del formulario a la lista de Integers que pide tu servicio
        formData.forEach((key, value) -> {
            try {
                cantidades.add(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                cantidades.add(0);
            }
        });

        // Llamada a TU método manejarSolicitud
        int token = servicio.manejarSolicitud(cantidades);

        model.addAttribute("token", token);
        return "resultado";
    }
}