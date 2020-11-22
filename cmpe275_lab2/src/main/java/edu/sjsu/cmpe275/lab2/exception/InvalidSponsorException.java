package edu.sjsu.cmpe275.lab2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="name cannot be empty")
public class InvalidSponsorException extends RuntimeException{
	
	public InvalidSponsorException(final String message) {
		
		super(message);
		System.out.println(message);
	}
}
