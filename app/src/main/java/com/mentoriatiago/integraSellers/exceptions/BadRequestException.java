package com.mentoriatiago.integraSellers.exceptions;

public class BadRequestException extends RuntimeException {

  public BadRequestException(String error) {
    super(error);
  }

}
