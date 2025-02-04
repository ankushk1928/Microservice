package com.adk.hotel.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ankushk
 */

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);
    }
    public ResourceNotFoundException()
    {
        super("Resource Not Found !!");
    }
}
