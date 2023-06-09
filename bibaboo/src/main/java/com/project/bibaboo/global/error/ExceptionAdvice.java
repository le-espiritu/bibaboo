package com.project.bibaboo.global.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.project.bibaboo.domain.alterations.exception.AlterationsDuplicatedException;
import com.project.bibaboo.domain.cart.exception.CategoryAlreadyExistInCartException;
import com.project.bibaboo.domain.order.exception.OrderStateIsNotCompletedException;
import com.project.bibaboo.domain.review.exception.ReviewDuplicatedException;
import com.project.bibaboo.domain.user.exception.AlterInfoIsNullException;

@ControllerAdvice
public class ExceptionAdvice {
  private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
  
  //500번 예외 전체에 대한 처리
//  @ExceptionHandler(Exception.class)
//  public String exception(Exception e) {
//    logger.error("Exception... : {}",e.getMessage());
//    
//    return"error/500-custom";
//  }
  
  @ExceptionHandler(CategoryAlreadyExistInCartException.class)
  public ResponseEntity<Object> handleDuplicatedCategory(CategoryAlreadyExistInCartException e){
    
    logger.error("handleDuplicatedCategory 익셉션 핸들러 호출");
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json;charset=UTF-8");
    
    return ResponseEntity.badRequest().headers(headers).body(e.getMessage());
    
  }
  
  @ExceptionHandler(ReviewDuplicatedException.class)
  public ResponseEntity<Object> handleDuplicatedReview(ReviewDuplicatedException e){
    
    logger.error("ReviewDuplicatedException 익셉션 핸들러 호출");
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json;charset=UTF-8");
    
    return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.FORBIDDEN);
  }
  
  @ExceptionHandler(AlterationsDuplicatedException.class)
  public ResponseEntity<Object> handleDuplicatedAlterations(AlterationsDuplicatedException e){
    
    logger.error("AlterationsDuplicatedException 익셉션 핸들러 호출");
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json;charset=UTF-8");
    
    return ResponseEntity.badRequest().headers(headers).body(e.getMessage());
  }
  
  @ExceptionHandler(AlterInfoIsNullException.class)
  public String handleAlterInfoIsNullException (AlterInfoIsNullException e) {
    
    logger.error("AlterInfoIsNullException 익셉션 핸들러 호출");
    
    return"error/no-alter-info";
  }
  
  @ExceptionHandler(OrderStateIsNotCompletedException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public String handleOrderStateException(OrderStateIsNotCompletedException e) {
    logger.error("OrderStateIsNotCompletedException : {}",e.getMessage());
    
    return"error/can-not-write-review";
  }
}
