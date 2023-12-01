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
            MethodArgumentNotValidException.class,
            UsernameNotFoundException.class})
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex) {
        ErrorDto error = ErrorDto.builder().message(ex.getMessage()).build();
        return ResponseEntity.badRequest().body(error);
    }
}
