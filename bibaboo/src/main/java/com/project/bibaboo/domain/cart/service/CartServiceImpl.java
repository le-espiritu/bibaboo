package com.project.bibaboo.domain.cart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.project.bibaboo.domain.cart.dao.CartDao;
import com.project.bibaboo.domain.cart.dto.CartDTO;
import com.project.bibaboo.domain.cart.exception.CategoryAlreadyExistInCartException;

@Service
public class CartServiceImpl implements CartService {

  private CartDao cartDao;

  @Autowired
  public CartServiceImpl(CartDao cartDao) {
    this.cartDao = cartDao;
  }

  @Override
  public void addCart(CartDTO cartDTO) {
    try {
      cartDao.addCart(cartDTO);
    } catch (DataIntegrityViolationException e) {
      throw new CategoryAlreadyExistInCartException("이미 장바구니에 동일한 품목을 담았습니다.");
    }

  }

  @Override
  public void deleteCart(int id) {
    cartDao.deleteCart(id);

  }

  @Override
  public void modifyCount(CartDTO cartDTO) {
    cartDao.modifyCount(cartDTO);
  }

  @Override
  public List<CartDTO> getCart(int userId) {

    List<CartDTO> cartList = cartDao.getCart(userId);

    for (CartDTO cartDTO : cartList) {
      cartDTO.initTotal();
    }

    return cartList;
  }

  @Override
  public CartDTO checkCart(CartDTO cartDTO) {
    // TODO Auto-generated method stub
    return null;
  }

}
