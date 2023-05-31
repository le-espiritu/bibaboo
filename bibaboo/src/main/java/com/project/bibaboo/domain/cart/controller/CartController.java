package com.project.bibaboo.domain.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.bibaboo.domain.cart.dto.CartDTO;
import com.project.bibaboo.domain.cart.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

  CartService cartService;
  
  @Autowired
  public CartController(CartService cartService) {
    this.cartService=cartService;
  }
  
  @PostMapping
  public ResponseEntity<Object> addCart(@RequestBody CartDTO cartDTO){
    // @ModelAttribute 는 form 데이터를 받아서 자바 객체로 매핑할때 사용
    // @RequestBody는 request body를 통해서 전달된 json 데이터를 자바 객체로 매핑할때 사용 
    
    cartService.addCart(cartDTO);
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json;charset=UTF-8");
    
    return ResponseEntity.ok().headers(headers).build();
  }
}
