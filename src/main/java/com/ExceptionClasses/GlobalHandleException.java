package com.ExceptionClasses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Component
@ControllerAdvice
public class GlobalHandleException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = IDExistException.class)
	public ResponseEntity<?> handleException(IDExistException ie) {

		return new ResponseEntity<>(ie.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = NotValidAgeException.class)
	public ResponseEntity<?> handleException(NotValidAgeException ne) {
		return new ResponseEntity<>(ne.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
}
