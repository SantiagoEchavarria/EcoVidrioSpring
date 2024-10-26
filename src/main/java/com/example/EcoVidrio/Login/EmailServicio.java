package com.example.EcoVidrio.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServicio {
    
    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(destinatario);
        mailMessage.setSubject(asunto);
        mailMessage.setText(mensaje);
        mailSender.send(mailMessage);
    }
}
