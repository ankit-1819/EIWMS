package com.eiwms.dto;

import java.util.Map;

public class ErrorResponse {

	private String message;
	private int status;
	
	private Map<String,String> errors;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	

	public ErrorResponse(String message, int status, Map<String, String> errors) {
		super();
		this.message = message;
		this.status = status;
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
	
}
