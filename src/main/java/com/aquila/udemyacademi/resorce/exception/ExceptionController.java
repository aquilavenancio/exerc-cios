package com.aquila.udemyacademi.resorce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.aquila.udemyacademi.exceptions.BusinessException;

@RestController
public class ExceptionController {
    

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleResponseException(BusinessException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Erro : " + ex.getMessage());
    }

}
