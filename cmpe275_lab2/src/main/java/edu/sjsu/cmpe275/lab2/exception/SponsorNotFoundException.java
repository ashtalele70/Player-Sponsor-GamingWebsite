package edu.sjsu.cmpe275.lab2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Sponsor not found")
public class SponsorNotFoundException extends RuntimeException {
  public SponsorNotFoundException(final String message) {

    super(message);
    System.out.print(message);
  }
}
