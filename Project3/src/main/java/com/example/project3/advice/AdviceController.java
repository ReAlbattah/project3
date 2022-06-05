package com.example.project3.advice;


import com.example.project3.exception.BookLendedBeforException;
import com.example.project3.exception.InvalidIdException;
import com.example.project3.model.API;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleExeption(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(500).body(new API("SERVER ERROR !",500));
    }


    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(400).body(new API(message,400));
    }

    @ExceptionHandler(value = BookLendedBeforException.class)
    public ResponseEntity<API> handelBook(BookLendedBeforException bookLendedBeforException){
        String message=bookLendedBeforException.getMessage();
        return ResponseEntity.status(400).body(new API(message,400));
    }
}
