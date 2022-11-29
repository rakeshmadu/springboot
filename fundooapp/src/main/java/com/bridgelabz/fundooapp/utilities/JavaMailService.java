package com.bridgelabz.fundooapp.utilities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import com.bridgelabz.fundooapp.dto.EmailDTO;




@Component
public class JavaMailService {
    
    
    @Autowired private 
    JavaMailSender javaMailSender;
    
     @Value("${spring.mail.username}")
        private String sender;
    
    
    public String sendSimpleMail(String email, String token, String subject) {
        
        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(email);
            mailMessage.setText(token);
            mailMessage.setSubject(subject);

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";

        } catch (Exception e) {
            return "Error while Sending Mail";
        }

    }


    public String sendSimpleMail(EmailDTO mail) {
        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(mail.getRecipient());
            mailMessage.setText(mail.getMsgBody());
            mailMessage.setSubject(mail.getSubject());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";

        } catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

}