package com.hotspot.ecommerce.models.email;



import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;
import java.util.Properties;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final String remetente = "hotspot2023@outlook.com.br";
    private final String password = "AthokUzIjk2023";
    private final Configuration fmConfiguration;

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

    public void enviarEmailTemplate(Email email, Map<String, Object> map){

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

        var message = mailSender.createMimeMessage();

        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(remetente);
            mimeMessageHelper.setTo(email.getDestinatario());
            mimeMessageHelper.setSubject(email.getTitulo());
            mimeMessageHelper.setText(email.getMensagem());
            mimeMessageHelper.setText(getConteudoTemplate(map), true);
            mailSender.setJavaMailProperties(props);
            mailSender.send(mimeMessageHelper.getMimeMessage());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public String getConteudoTemplate(Map<String, Object> model){
        StringBuffer buffer = new StringBuffer();
        try{
            buffer.append(FreeMarkerTemplateUtils
                    .processTemplateIntoString(fmConfiguration.getTemplate("template.flth"), model));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return buffer.toString();
    }



}
