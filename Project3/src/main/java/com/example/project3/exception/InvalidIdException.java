package com.example.project3.exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String msg){
        super(msg);
    }
}
