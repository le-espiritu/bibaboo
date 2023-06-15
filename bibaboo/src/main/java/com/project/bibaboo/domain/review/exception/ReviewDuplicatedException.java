package com.project.bibaboo.domain.review.exception;

public class ReviewDuplicatedException extends RuntimeException {

  public ReviewDuplicatedException(String msg) {
    super(msg);
  }
}
