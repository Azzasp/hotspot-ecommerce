package com.hotspot.ecommerce.models.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final String remetente = "${spring.mail.username}";

    public String enviarEmailTexto(Email email){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(email.getDestinatario());
            simpleMailMessage.setSubject(email.getTitulo());
            simpleMailMessage.setText(email.getMensagem());

            javaMailSender.send(simpleMailMessage);

            return  "Email Enviado!";
        }catch (Exception e){
            System.out.println(e.getMessage());

            return  "Erro ao enviar Email!";
        }

    }




}
