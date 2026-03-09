package com.tt1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailerStubTest {

    private MailerStub mailer;

    @BeforeEach
    void setUp() {
        mailer = new MailerStub();
    }

    @Test
    void mandarEmail() {
        String direccion = "inzenarr@unirioja.es";
        String mensaje = "Esto es una prueba de envio";

        assertDoesNotThrow(() -> mailer.mandarEmail(direccion, mensaje),"El método mandarEmail debería ejecutarse sin lanzar excepciones.");
    }

    @Test
    void mandarEmailConDatosNulos() {
        assertDoesNotThrow(() -> mailer.mandarEmail(null, null),"El stub debería manejar strings nulos con seguridad.");
    }
}