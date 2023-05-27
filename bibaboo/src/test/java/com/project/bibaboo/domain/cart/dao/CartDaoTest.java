package com.project.bibaboo.domain.cart.dao;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.project.bibaboo.domain.cart.dto.CartDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CartDaoTest {
  
  static Logger logger = LoggerFactory.getLogger(CartDaoTest.class);
  
  @Autowired
  private CartDao cartDao;
  
  @Test
  public void addCartTest() throws Exception {
    CartDTO cartDTO = new CartDTO();
    cartDTO.setUserId(1);
    cartDTO.setCategoryId(1);
    cartDTO.setCount(2);
    
    int rs = cartDao.addCart(cartDTO);
    
    Assert.assertEquals(1, rs);
  }
  
  @Test
  public void getCartTest() {
    List<CartDTO> list = cartDao.getCart(1);
    for(CartDTO dto : list) {
      logger.info(dto.toString());
    }
    
    Assert.assertNotNull(list.get(0));
  }
  
  @Test
  public void checkCartTest() {
    CartDTO cartDTO = new CartDTO();
    cartDTO.setUserId(1);
    cartDTO.setCategoryId(1);
    
    CartDTO result = cartDao.checkCart(cartDTO);
    logger.info(result.toString());
    
    Assert.assertNotNull(result);
  }
  
  @Test
  public void modifyCountTest() {
    CartDTO cartDTO = new CartDTO();
    cartDTO.setId(1);
    cartDTO.setCount(3);
    
    int rs = cartDao.modifyCount(cartDTO);
    Assert.assertEquals(1, rs);
  }
  
  @Test
  public void deleteCartTest() {
    int rs = cartDao.deleteCart(1);
    
    Assert.assertEquals(1, rs);
  }

}
