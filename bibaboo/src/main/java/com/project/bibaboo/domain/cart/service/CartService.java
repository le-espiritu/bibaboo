package com.project.bibaboo.domain.cart.service;

import java.util.List;
import com.project.bibaboo.domain.cart.dto.CartDTO;

public interface CartService {
  public void addCart(CartDTO cartDTO);
  public void deleteCart(int id);
  public void modifyCount(CartDTO cartDTO);
  public List<CartDTO> getCart(int userId);
  public CartDTO checkCart(CartDTO cartDTO);
}
