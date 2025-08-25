package org.example.interviewprojectserver.exceptions.user_errors;

import org.example.interviewprojectserver.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;


public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
