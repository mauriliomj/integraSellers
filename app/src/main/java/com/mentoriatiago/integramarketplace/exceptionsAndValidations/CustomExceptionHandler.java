package com.mentoriatiago.integramarketplace.exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JASON_CHARSET_UTF_8 = "application/jason; charset=utf-8";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<ErrorResponse> handlerValidationException(final  MethodArgumentNotValidException ex) {

        final BindingResult bindingResult = ex.getBindingResult();
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        final ErrorResponse response = this.processFieldErrors(fieldErrors);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JASON_CHARSET_UTF_8);
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(AlreadyRegistered.class)
    public HttpEntity<ErrorResponse> handlerValidationException(final  AlreadyRegistered ex) {
        List<String> erros = new ArrayList<>();
        erros.add(ex.getMessage());
        final ErrorResponse response = new ErrorResponse(erros);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JASON_CHARSET_UTF_8);
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.BAD_REQUEST);

    }

    private ErrorResponse processFieldErrors(final List<FieldError> fieldErrors) {
        final List<String> errors = fieldErrors.stream()
                .map(error -> String.format("%s: %s", error.getField(), error.getDefaultMessage())).collect(toList());
        return new ErrorResponse(errors);
    }
}