package com.eiwms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eiwms.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException ex){
		
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex){
		
		ErrorResponse errorResponse = new ErrorResponse(
				
				"Something Went Wrong",
				HttpStatus.INTERNAL_SERVER_ERROR.value()
				
		);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
		
}
