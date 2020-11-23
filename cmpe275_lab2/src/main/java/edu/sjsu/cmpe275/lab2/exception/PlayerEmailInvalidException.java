package edu.sjsu.cmpe275.lab2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Email ID is already taken")
public class PlayerEmailInvalidException extends RuntimeException {
	/**
	 * 
	 * @param message email id is already taken
	 */
	public PlayerEmailInvalidException(final String message) {
		super(message);
	}
}
