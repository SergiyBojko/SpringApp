package com.serhiiboiko.spring_boot_app.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.serhiiboiko.spring_boot_app.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceNotFoundHandler {
	
	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String resourceNotFound (ResourceNotFoundException ex) {
		return ex.getMessage();
	}

}
