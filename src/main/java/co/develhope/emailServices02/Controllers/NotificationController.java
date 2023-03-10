package co.develhope.emailServices02.Controllers;

import co.develhope.emailServices02.Entities.NotificationDTO;
import co.develhope.emailServices02.Entities.Student;
import co.develhope.emailServices02.Services.EmailService;
import co.develhope.emailServices02.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/notification")
    public ResponseEntity sendNotification(@RequestBody NotificationDTO payload){
        try {
            Student studentToSendNotification = studentService.getStudentById(payload.getContactId());
            System.out.println("Getting the Student: " + studentToSendNotification);
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not find the Student");
            }
            return emailService.sendTo(studentToSendNotification.getEmail(), payload.getTitle(), payload.getText());

        }catch (Exception e){
            System.err.println("Error in notification controller: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
