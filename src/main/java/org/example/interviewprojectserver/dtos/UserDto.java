package org.example.interviewprojectserver.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.interviewprojectserver.entities.UserRole;

@Data
public class UserDto {

    // We can honestly use this Dto for POST request.

    @NotNull(message = "Name cannot be null")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    private String profile_url;
    private UserRole role;
}
