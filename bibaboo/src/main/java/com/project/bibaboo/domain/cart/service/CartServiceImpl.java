package com.project.bibaboo.domain.cart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.bibaboo.domain.cart.dao.CartDao;
import com.project.bibaboo.domain.cart.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {

  private CartDao cartDao;
  
  @Autowired
  public CartServiceImpl(CartDao cartDao) {
    this.cartDao=cartDao;
  }
  
  @Override
  public void addCart(CartDTO cartDTO) {
    try {
      cartDao.addCart(cartDTO);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  public void deleteCart(int id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void modifyCount(CartDTO cartDTO) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<CartDTO> getCart(int userId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CartDTO checkCart(CartDTO cartDTO) {
    // TODO Auto-generated method stub
    return null;
  }

}
