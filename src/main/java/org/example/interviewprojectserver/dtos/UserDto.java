package org.example.interviewprojectserver.dtos;

import lombok.Data;
import org.example.interviewprojectserver.entities.UserRole;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String name;
    private String email;
    private String profile_url;
    private UserRole role;
}
