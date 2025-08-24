package org.example.interviewprojectserver.exceptions.user_errors;

import org.example.interviewprojectserver.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends ApplicationException {
    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
