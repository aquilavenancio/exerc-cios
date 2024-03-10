package com.aquila.udemyacademi.resorce.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    public ResponseEntity<StandardError> objectNotFound(){
        return null;
    }
}
