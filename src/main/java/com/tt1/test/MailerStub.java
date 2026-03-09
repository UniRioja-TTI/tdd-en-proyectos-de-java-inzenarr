package com.tt1.test;

public class MailerStub {
    public void mandarEmail(String dir, String m){
        if (dir == null || m == null) {
            System.out.println("Intento de envío fallido, algun parametro nulo.");
            return;
        }
    }
}