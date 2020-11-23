package edu.sjsu.cmpe275.lab2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Opponents exist")
public class OpponentsExistException extends RuntimeException {
	/**
	 * 
	 * @param message Opponents exist
	 */
	public OpponentsExistException(final String message) {
		super(message);
	}
}
