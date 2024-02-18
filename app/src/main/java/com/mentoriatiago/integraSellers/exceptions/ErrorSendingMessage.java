package com.mentoriatiago.integraSellers.exceptions;

public class ErrorSendingMessage extends RuntimeException{
  public ErrorSendingMessage(String error){super(error);}
}
