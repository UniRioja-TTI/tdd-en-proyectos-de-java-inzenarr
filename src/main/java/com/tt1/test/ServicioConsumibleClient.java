package com.tt1.test;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@Component
public class ServicioConsumibleClient {

    private final RestTemplate restTemplate;
    //luego se mapeara al 5000 de la maquina virtual
    private final String BASE_URL = "http://localhost:8080";

    public ServicioConsumibleClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Consume el endpoint /Solicitud/Solicitar (POST)
     * Envía las entidades y cantidades y recibe la respuesta del servidor potente.
     */
    public void enviarSolicitud(String nombreUsuario, List<String> entidades, List<Integer> cantidades) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/Solicitud/Solicitar")
            .queryParam("nombreUsuario", nombreUsuario)
            .toUriString();

        // Creamos el objeto que espera el JSON (según el esquema 'Solicitud' del JSON)
        SolicitudBody body = new SolicitudBody(entidades, cantidades);

        try {
            restTemplate.postForObject(url, body, Object.class);
        } catch (Exception e) {
            System.err.println("Error al conectar con la VM: " + e.getMessage());
        }
    }

    /**
     * Consume el endpoint /Email (POST)
     * Envía un email a través del servicio de la VM.
     */
    public void enviarEmail(String email, String mensaje) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/Email")
            .queryParam("emailAddress", email)
            .queryParam("message", mensaje)
            .toUriString();

        restTemplate.postForObject(url, null, Object.class);
    }

    //para mapear el JSON
    private static class SolicitudBody {
        public List<String> nombreEntidades;
        public List<Integer> cantidadesIniciales;

        public SolicitudBody(List<String> nombres, List<Integer> cantidades) {
            this.nombreEntidades = nombres;
            this.cantidadesIniciales = cantidades;
        }
    }
}