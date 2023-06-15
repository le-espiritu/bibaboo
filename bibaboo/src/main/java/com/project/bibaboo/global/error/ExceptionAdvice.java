package com.project.bibaboo.global.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.project.bibaboo.domain.cart.exception.CategoryAlreadyExistInCartException;
import com.project.bibaboo.domain.review.exception.ReviewDuplicatedException;

@ControllerAdvice
public class ExceptionAdvice {
  private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
  
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
  

}
