package com.myretail.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * A custom exception handler for my retail. 
 * 
 * @author Gerson Bothello
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends  ResponseEntityExceptionHandler { 
		
	
	private Logger exlogger = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
	
	/**
	 * Custom Exception for all exceptions 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		exlogger.error("ERROR:", ex);
		ExceptionResponse exResponse =  new ExceptionResponse("Oops! Something went wrong.The application has encountered an unknown error. Please contact support.");
        return new ResponseEntity<>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	/**
	 * Exception when Product not found 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(MyRetailExceptionHandler.ProductNotFoundException.class)
    public final ResponseEntity<Object> handlesProductNotFoudExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exResponse =  new ExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
    }
		
	
	/**
	 * Exception when a request was made with a bad parameter
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(MyRetailExceptionHandler.BadRequestException.class)
    public final ResponseEntity<Object> handlesBadRequestExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exResponse =  new ExceptionResponse(ex.getMessage() );
        return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
    }
	
	/**
	 * Exception when a no data was changed on a put/Post 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(MyRetailExceptionHandler.NoContentException.class)
    public final ResponseEntity<Object> handlesNoContentExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exResponse =  new ExceptionResponse(ex.getMessage() );
        return new ResponseEntity<>(exResponse, HttpStatus.NO_CONTENT);
    }
	
}
