package com.nisum.demo.controller;

import com.nisum.demo.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({
            RuntimeException.class,
            IllegalArgumentException.class,
            MethodArgumentNotValidException.class,
            UsernameNotFoundException.class})
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex) {
        ErrorDto error = new ErrorDto(ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
