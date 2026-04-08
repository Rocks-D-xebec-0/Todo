package com.letsdoit.todo.exceptions;

import lombok.Getter;

/**
 * Thrown when a business logic rule is violated.
 * Can optionally include an error code for categorization.
 * Maps to HTTP 409 CONFLICT or 422 UNPROCESSABLE ENTITY.
 */
@Getter
public class BusinessException extends RuntimeException {
    
    private final String errorCode;
    
    public BusinessException(String message) {
        super(message);
        this.errorCode = null;
    }
    
    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = null;
    }
    
    public BusinessException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

}

