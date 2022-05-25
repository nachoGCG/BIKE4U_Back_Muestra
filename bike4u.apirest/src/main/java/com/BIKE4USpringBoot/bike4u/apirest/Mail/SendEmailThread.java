package com.BIKE4USpringBoot.bike4u.apirest.Mail;

import org.springframework.beans.factory.annotation.Autowired;

public class SendEmailThread extends Thread implements Runnable{

    private String email;
    private String userName;

    @Autowired
    public EmailSender emailSender;

    public void run(){
        emailSender.sendEmail(email,userName);
    }

    public SendEmailThread(String userName, String email, EmailSender emailSender) {
        this.emailSender=emailSender;
        this.email=email;
        this.userName=userName;
    }
}
