package com.sprayou.spray.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailSenderService {
    
    public static boolean SendMessage(final String femail, final String fpass, final String email, final String subject, final String message)
    {

    boolean rtn = false;
    //Creating properties
    Properties props = new Properties();
    //Configuring properties for gmail
    //If you are not using gmail you may need to change the values
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.port", "587");
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.ssl.trust", "smtp.gmail.com");     
    //Creating a new session
    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                //Authenticating the password
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(femail, fpass);
                }
            });
    try {
        //Creating MimeMessage object
        MimeMessage mm = new MimeMessage(session);
        //Setting sender address
        mm.setFrom(new InternetAddress(femail));
        //Adding receiver
        mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        //Adding subject
        mm.setSubject(subject);
        //Adding message
        mm.setText(message);           
        //Sending email
        // Transport.send(mm); 테스트 할때 까진 임시 주석. 윤혜수        

        rtn = true;
    } catch (MessagingException e) {
        e.printStackTrace();
    }

    return rtn;
    }
     
}
