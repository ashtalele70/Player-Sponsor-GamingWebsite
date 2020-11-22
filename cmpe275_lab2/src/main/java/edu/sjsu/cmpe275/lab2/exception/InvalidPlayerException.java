package edu.sjsu.cmpe275.lab2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Firstname, Lastname and Email cannot be empty")
public class InvalidPlayerException extends RuntimeException {
  public InvalidPlayerException(final String message) {
    super(message);
  }
}
