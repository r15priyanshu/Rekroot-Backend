package com.anshuit.rekroot.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto extends BaseEntityDto {
    private int contactId;

    @NotBlank(message = "Name cannot be empty,blank space(s) or null.")
    @Size(min = 3, message = "Name must have minimum of 3 characters.")
    private String name;

    @NotBlank(message = "Email cannot be empty,blank space(s) or null.")
    @Email(message = "Must be a well formatted email address.")
    private String email;

    @NotBlank(message = "UserType cannot be empty,blank space(s) or null.")
    @Pattern(regexp = "Job-Seeker|Employer|Others", message = "UserType must be one among : Job-Seeker|Employer|Other.")
    private String userType;

    @NotBlank(message = "Subject cannot be empty,blank space(s) or null.")
    private String subject;

    @NotBlank(message = "Message cannot be empty,blank space(s) or null.")
    private String message;

    private String status;
}
