package com.ExceptionClasses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalHandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value=IDExistException.class)
    public ResponseEntity HandleException(IDExistException ie)
    {
      return new ResponseEntity(ie.getMessage(),HttpStatus.CONFLICT);	
    }
    
    @ExceptionHandler(value=NotValidAgeException.class)
    public ResponseEntity HandleException(NotValidAgeException ne)
    {
      return new ResponseEntity(ne.getMessage(),HttpStatus.NOT_ACCEPTABLE);	
    }	
}
