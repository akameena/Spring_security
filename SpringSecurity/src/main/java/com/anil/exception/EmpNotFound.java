package com.anil.exception;

public class EmpNotFound  extends RuntimeException {

	
	public EmpNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmpNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmpNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
