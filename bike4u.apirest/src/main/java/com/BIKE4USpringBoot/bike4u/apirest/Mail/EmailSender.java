package com.BIKE4USpringBoot.bike4u.apirest.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender{

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String email,String userName){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email.trim());
        simpleMailMessage.setSubject("Bienvenido_a_BIKE4U");
        simpleMailMessage.setText("Su cuenta de BIKE4U se ha creado correctamente" +
                ". Bienvenido: "+userName);
        mailSender.send(simpleMailMessage);

    }
}
