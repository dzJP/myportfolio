package portfolio.jakob.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.jakob.dto.ContactFormDTO;
import portfolio.jakob.service.EmailService;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/api/v1/submitContactForm")
    public ResponseEntity<String> submitContactForm(@RequestBody ContactFormDTO contactFormDTO) {
        try {
            emailService.sendEmail(contactFormDTO.getName(), contactFormDTO.getEmail(), contactFormDTO.getPhoneNumber(), contactFormDTO.getSubject(), contactFormDTO.getMessage());
            return ResponseEntity.ok("Contact form submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error submitting contact form: " + e.getMessage());
        }
    }
}
