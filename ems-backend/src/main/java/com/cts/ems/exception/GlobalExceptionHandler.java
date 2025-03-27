package com.cts.ems.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Other exception handlers can go here
    @ExceptionHandler(APIException.class)
    public ResponseEntity<ErrorDetails> handleAPIException(APIException exception, WebRequest webRequest) {
    	
    	ErrorDetails errorDetails = new ErrorDetails(
    		LocalDateTime.now(), 
    		exception.getMessage(),
    		webRequest.getDescription(false)
    	);
    	
    	return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
