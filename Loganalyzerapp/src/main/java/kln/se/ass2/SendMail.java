package kln.se.ass2;

import kln.se.ass2.mysqlrepostery.Maillist;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    public static void sendmail(){

        // Sender's email ID needs to be mentioned
        String from = "softconsassiment2@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("softconsassiment2@gmail.com", "asanka2020");

            }

        });

        List<String> emailToAddresses = Maillist.getmailaddress();
        String emails = null;

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            StringBuilder sb = new StringBuilder();

            int i = 0;
            for (String email : emailToAddresses) {
                sb.append(email);
                i++;
                if (emailToAddresses.size() > i) {
                    sb.append(", ");
                }
            }

            emails = sb.toString();

            // set 'to email address'
            // you can set also CC or TO for recipient type
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(sb.toString()));

            // Set Subject: header field
            message.setSubject("Error notification");

            // Now set the actual message
            message.setText("There are some errors in the log");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
