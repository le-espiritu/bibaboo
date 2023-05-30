package com.project.bibaboo.domain.cart.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.project.bibaboo.domain.cart.dto.CartDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CartServiceTest {
  
  static Logger loogger = LoggerFactory.getLogger(CartServiceTest.class);
  
  @Autowired
  CartService cartService;
  
  @Test
  public void addCartTest() {
    CartDTO cartDTO = new CartDTO();
    cartDTO.setUserId(1);
    cartDTO.setCategoryId(1);
    cartDTO.setCount(2);
    
    cartService.addCart(cartDTO);
  }

}
