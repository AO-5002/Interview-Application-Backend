package org.example.interviewprojectserver.exceptions.file_errors;

import org.example.interviewprojectserver.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

public class FileNotValid extends ApplicationException {
    public FileNotValid(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
