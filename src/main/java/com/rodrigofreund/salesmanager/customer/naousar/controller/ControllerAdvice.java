package com.rodrigofreund.salesmanager.customer.naousar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrors>> handleError400(MethodArgumentNotValidException ex) {
        var errorList =
            ex.getFieldErrors().stream()
                .map(ValidationErrors::new)
                .toList();
        return ResponseEntity.badRequest().body(errorList);
    }
    
    private record ValidationErrors(String field, String message) {
        public ValidationErrors(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
