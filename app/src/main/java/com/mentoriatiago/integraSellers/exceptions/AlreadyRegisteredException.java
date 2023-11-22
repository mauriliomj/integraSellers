package com.mentoriatiago.integraSellers.exceptions;

public class AlreadyRegisteredException extends RuntimeException{

    public AlreadyRegisteredException(String error){
        super(error);
    }

}
