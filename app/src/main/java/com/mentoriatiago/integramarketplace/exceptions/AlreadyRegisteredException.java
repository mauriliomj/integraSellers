package com.mentoriatiago.integramarketplace.exceptions;

public class AlreadyRegisteredException extends RuntimeException{
    public AlreadyRegisteredException(String error){
        super(error);
    }

}
