package com.example.borrowbooks.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BorrowBooksException extends Throwable {
    @ExceptionHandler(Exception.class)
    public String book(){
        return "book_error";
    }
}
