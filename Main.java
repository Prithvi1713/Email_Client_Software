package org.example;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main{
    public static void main(String[] args) {
        String message = " happiest birthday prithviraj lavate ";
        String subject = "baddey wishesh";
        String to = "plavate95@gmail.com";
        String from = "lavateprithviraj@gmail.com";

        sendAttach(message,subject,to,from);
    }
    private static void sendAttach(String message, String subject, String to, String from) {
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("lavateprithviraj@gmail.com", "vzrwunfwzlvjtswl");
            }



        });
        session.setDebug(true);

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(from);
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
             System.out.println("Message send successfully");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    }
