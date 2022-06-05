package com.example.project3.exception;

public class BookLendedBeforException extends RuntimeException{
    public BookLendedBeforException(String msg){
        super(msg);
    }
}
