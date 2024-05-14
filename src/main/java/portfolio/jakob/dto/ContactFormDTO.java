package portfolio.jakob.dto;

import lombok.Data;

@Data
public class ContactFormDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String subject;
    private String message;
}
