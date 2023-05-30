package com.project.bibaboo.domain.cart.exception;

public class CategoryAlreadyExistInCartException extends RuntimeException {

  public CategoryAlreadyExistInCartException(String msg) {
    super(msg);
  }
}
