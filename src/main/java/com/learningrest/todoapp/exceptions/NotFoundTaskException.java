package com.learningrest.todoapp.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundTaskException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public NotFoundTaskException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
