package com.project.bibaboo.domain.cart.dao;

import java.util.List;
import com.project.bibaboo.domain.cart.dto.CartDTO;

public interface CartDao {
  public int addCart(CartDTO cartDTO);
  public int deleteCart(int id);
  public int modifyCount(CartDTO cartDTO);
  public List<CartDTO> getCart(int userId);
  public CartDTO checkCart(CartDTO cartDTO);
}
