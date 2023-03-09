package co.develhope.emailServices02.Services;

import co.develhope.emailServices02.Entities.Student;
import jakarta.mail.Address;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public ResponseEntity sendTo(String to, String subject, String text) {
        try {
            String body = "<html><body><h1>Alessio e Ignazio di Sera</h1><h2>Resoconto serata</h2><img src='https://www.sinonimi-contrari.it/includes/images/sharers/sinonimi-di-follia.png'><h3>"+ text +"</h3></body></html>";
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("pollinaalessio1@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            emailSender.send(mimeMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong payload");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Send e-mail");

    }
}
