package com.wooahan.exchangerate.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(NotInputMonetaryException.class)
    public ResponseEntity handleIllegalArgsException(NotInputMonetaryException e) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(WrongInputMonetaryException.class)
    public ResponseEntity handleIllegalArgsException(WrongInputMonetaryException e) {
        return ResponseEntity.badRequest().build();
    }
}
