package healthcareApp;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static boolean send(String user, String pass, String recip, String m) {
        // Sender's email credentials
        String senderEmail = user;          //"addithurston@gmail.com"
        String senderPassword = pass;       // "lyzv fdyb airr zkxk"
        
        // Recipient's email address
        String recipientEmail = recip;           //"addithurston@gmail.com"

        // Set up SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create email content
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(recipientEmail)
            );
            message.setSubject("Test Email");
            message.setText(m);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
}
