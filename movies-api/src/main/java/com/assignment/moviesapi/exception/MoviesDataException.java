package com.assignment.moviesapi.exception;

import org.springframework.http.HttpStatus;

public class MoviesDataException extends RuntimeException {

  private static final long serialVersionUID = 5373868865249521216L;

  private HttpStatus status;

  public MoviesDataException(Exception e) {
    super(e);
  }

  public MoviesDataException(String message) {
    super(message);
  }

  public MoviesDataException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }

  public MoviesDataException(String message, Exception e) {
    super(message, e);
  }

  public HttpStatus getStatus() {
    return this.status;
  }
}
