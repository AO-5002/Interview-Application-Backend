package org.example.interviewprojectserver.exceptions.interview_errors;

import org.example.interviewprojectserver.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

public class NoInterviewsFoundException extends ApplicationException {
    public NoInterviewsFoundException(String message) {

        super(message, HttpStatus.NOT_FOUND);
    }
}
