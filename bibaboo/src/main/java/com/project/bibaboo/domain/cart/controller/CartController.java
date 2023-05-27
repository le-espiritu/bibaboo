package com.project.bibaboo.domain.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
  public ResponseEntity<Object> addCart(@ModelAttribute CartDTO cartDTO){
    cartService.addCart(cartDTO);
    
    return ResponseEntity.ok().build();
  }
}
