package com.demo.ssj2k.service;

public class DomainAlreadyExistsException extends RuntimeException {

  public DomainAlreadyExistsException(String message) {
    super(message);
  }
}
