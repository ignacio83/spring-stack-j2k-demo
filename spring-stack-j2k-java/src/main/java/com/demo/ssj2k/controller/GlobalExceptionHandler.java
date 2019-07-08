package com.demo.ssj2k.controller;

import com.demo.ssj2k.service.DomainAlreadyExistsException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DomainAlreadyExistsException.class)
  public ResponseEntity<ErrorContract> handleDomainAlreadyExistsException(
      DomainAlreadyExistsException ex) {
    return new ResponseEntity(new ErrorContract(ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @RequiredArgsConstructor
  @Data
  public class ErrorContract {
    private final String message;
  }
}
