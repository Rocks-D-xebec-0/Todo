package com.letsdoit.todo.exceptions;

/**
 * Thrown when user authentication or authorization fails.
 * Maps to HTTP 401 UNAUTHORIZED or 403 FORBIDDEN.
 */
public class UnauthorizedException extends RuntimeException {
    
    public UnauthorizedException(String message) {
        super(message);
    }
    
    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}

