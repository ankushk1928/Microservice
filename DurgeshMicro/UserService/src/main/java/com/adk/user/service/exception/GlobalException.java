package com.adk.user.service.exception;

import com.adk.user.service.payload.ApiResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ankushk
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResource> handleResourceNotFoundException(ResourceNotFoundException ex){

        String message= ex.getMessage();
        ApiResource responce=ApiResource.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResource>(responce,HttpStatus.NOT_FOUND);
    }

}
