package org.example.interviewprojectserver.exceptions.interview_errors;

import org.example.interviewprojectserver.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

public class IncorrectRoleException extends ApplicationException {
    public IncorrectRoleException(String message)
    {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
