package com.ExceptionClasses;

import org.springframework.web.bind.annotation.ResponseStatus;


public class IDExistException extends RuntimeException {

	String msg;

	public IDExistException() {
		super("ID Already Exist");
	}

	public IDExistException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
