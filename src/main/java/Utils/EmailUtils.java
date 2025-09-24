package Utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Properties;

public class EmailUtils {
    public void sendEmail(String senderEmail, String senderPassword, String recipientEmail,String subject,  String body,String resumePath) {

        // SMTP server settings
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");  // Enables TLS

        // Create a session with authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);

            // Create MimeBodyPart for the message text
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body);

            // Create MimeBodyPart for the attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            // <-- Change this to your file path
            attachmentPart.attachFile(new File(resumePath));

            // Create Multipart and add parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            // Set the multipart content to the message
            message.setContent(multipart);

            // Send email
            Transport.send(message);

            System.out.println("✅ Email with attachment sent successfully to :"+ recipientEmail);

        } catch (Exception e) {
            System.err.println("❌ Failed to send email with attachment:");
            e.printStackTrace();
        }
    }
}