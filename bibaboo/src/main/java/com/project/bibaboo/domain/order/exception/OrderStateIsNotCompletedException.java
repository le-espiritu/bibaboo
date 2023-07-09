package com.project.bibaboo.domain.order.exception;

public class OrderStateIsNotCompletedException extends RuntimeException {

  public OrderStateIsNotCompletedException(String msg) {
    super(msg);
  }
}
