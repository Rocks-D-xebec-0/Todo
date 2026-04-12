package com.letsdoit.todo.exceptions;

/**
 * Thrown when request data is invalid or violates business rules.
 * Maps to HTTP 400 BAD REQUEST.
 */
public class BadRequestException extends RuntimeException {
    
    public BadRequestException(String message) {
        super(message);
    }
    
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

