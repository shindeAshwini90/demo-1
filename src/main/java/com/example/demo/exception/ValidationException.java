package com.example.demo.exception;

public class ValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	public ValidationException(String mgs) {
		super(mgs);
		this.message = mgs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getMessage() {
		return message;
	}
	
	
}
