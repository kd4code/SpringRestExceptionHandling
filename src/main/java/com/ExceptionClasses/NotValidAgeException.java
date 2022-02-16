package com.ExceptionClasses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotValidAgeException extends RuntimeException {
	String msg;

	public NotValidAgeException() {
		super("Not Valid Age");
	}

	public NotValidAgeException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
