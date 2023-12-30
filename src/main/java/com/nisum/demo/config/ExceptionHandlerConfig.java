package com.nisum.demo.config;

import com.nisum.demo.dto.ErrorDto;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            RuntimeException.class,
            IllegalArgumentException.class,
            UsernameNotFoundException.class})
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex) {
        ErrorDto error = new ErrorDto(null, ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<ErrorDto> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ErrorDto(error.getField(), error.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest().body(errors);
    }
}
