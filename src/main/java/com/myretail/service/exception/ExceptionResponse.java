package com.myretail.service.exception;

/**
 * This is the response object for the custom exception. 
 * 
 * @author Gerson Bothello
 *  
 */
public class ExceptionResponse {

	private String message;

	public ExceptionResponse(String message) {
		super();
			this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
