package portfolio.jakob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Value("${email.from}")
    private String fromEmail;

    @Value("${email.to}")
    private String toEmail;


    public void sendEmail(String name, String email, String phoneNumber, String subject, String message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(fromEmail); // sender's email address
            mailMessage.setTo(toEmail); // recipient's email address
            mailMessage.setSubject(subject);
            mailMessage.setText("Name: " + name + "\nEmail: " + email + "\nPhone: " + phoneNumber + "\nMessage: " + message);

            javaMailSender.send(mailMessage);

            System.out.println("Contact form submitted by: " + name);

        } catch (Exception e) {
            System.err.println("Error sending contact form submitted by: " + name);
            e.printStackTrace();
        }
    }
}
