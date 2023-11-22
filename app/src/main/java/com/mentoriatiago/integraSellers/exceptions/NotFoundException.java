package com.mentoriatiago.integraSellers.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String error){
        super(error);
    }

}
