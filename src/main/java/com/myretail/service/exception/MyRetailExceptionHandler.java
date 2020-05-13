package com.myretail.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is a custom exceptions for myRetail.
 * Included are the exceptions we are expecting.
 *  
 * @author gersonbothello
 *
 */
public class MyRetailExceptionHandler {
	
	private MyRetailExceptionHandler() {
		super();
	}
	
	/**
	 * This is a custom exception to handle 404 responses. 
	 * The server can not find the requested resource. 
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public static class ProductNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public ProductNotFoundException(int productId) {
		    super("Could not find product ID " + productId);
        }
    }

	/**
	 * This is a custom exception to handle 400 responses.
	 * The server could not understand the request due to invalid syntax. 
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public BadRequestException(String message) {
            super(message);
        }
    }
	
	/**
	 * This is a custom exception to handle 204 responses. 
	 * There is no content to send for this request.
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public static class NoContentException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public NoContentException() {
            super("No Content was changed.");
        }
    }

}
