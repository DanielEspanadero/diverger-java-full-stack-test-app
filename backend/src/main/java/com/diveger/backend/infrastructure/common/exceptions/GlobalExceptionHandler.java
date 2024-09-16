package com.diveger.backend.infrastructure.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCharacterNotFoundException(CharacterNotFoundException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());
        errorDetails.put("error", "Character Not Found");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", "/swapi-proxy/person-info");

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
