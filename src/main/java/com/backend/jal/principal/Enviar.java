package com.backend.jal.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Enviar {
       @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("sendemail")
    public ResponseEntity<?> sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("julioalazarte@gmail.com");
        message.setTo("julioalazarte@gmail.com");
        message.setSubject("Prueba de envio de mail");
        message.setText("Este es el contenido del mail");
        javaMailSender.send(message);
        
        return new ResponseEntity<>("desde principal. fue enviado el correo", HttpStatus.OK);
    } 
}
