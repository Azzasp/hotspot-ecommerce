package com.hotspot.ecommerce.models.email;



import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final String remetente = "hotspot2023@outlook.com.br";
    private final String password = "AthokUzIjk2023";

    public void enviarEmailTexto(Email email){


        try {

            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.office365.com");
            mailSender.setPort(587);
            mailSender.setUsername(remetente);
            mailSender.setPassword(password);

            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.office365.com");

            mailSender.setJavaMailProperties(props);


            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(email.getDestinatario());
            simpleMailMessage.setSubject(email.getTitulo());
            simpleMailMessage.setText(email.getMensagem());
            mailSender.send(simpleMailMessage);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }




}
