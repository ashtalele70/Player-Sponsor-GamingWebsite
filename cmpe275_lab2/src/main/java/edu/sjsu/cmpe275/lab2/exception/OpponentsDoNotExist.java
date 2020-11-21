package edu.sjsu.cmpe275.lab2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Opponents not found")
public class OpponentsDoNotExist extends RuntimeException {
  public OpponentsDoNotExist(final String message) {

    super(message);
    System.out.print(message);
  }
}
