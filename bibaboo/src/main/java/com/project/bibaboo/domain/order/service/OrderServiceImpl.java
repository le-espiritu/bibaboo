package com.project.bibaboo.domain.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bibaboo.domain.cart.dao.CartDao;
import com.project.bibaboo.domain.cart.dto.CartDTO;
import com.project.bibaboo.domain.order.dao.OrderDao;
import com.project.bibaboo.domain.order.dto.OrderCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderPageDTO;

@Service
public class OrderServiceImpl implements OrderService {
  
  OrderDao orderDao;
  CartDao cartDao;
  
  @Autowired
  public OrderServiceImpl(OrderDao orderDao, CartDao cartDao) {
    this.orderDao =orderDao;
    this.cartDao = cartDao;
  }

  @Override
  public List<OrderPageCategoryDTO> getGoodsInfoForOrder(OrderPageDTO orderPageDTO) {
    
    List<OrderPageCategoryDTO> orders = orderPageDTO.getOrders();
    
    List<OrderPageCategoryDTO> result = new ArrayList<>();
    
    for(OrderPageCategoryDTO order : orders) {
      OrderPageCategoryDTO goodsInfo = orderDao.getGoodsInfoForOrder(order.getCategoryId());
      goodsInfo.setCount(order.getCount());
      goodsInfo.initTotal();
      result.add(goodsInfo);
      
    }
    return result;
  }

  @Override
  @Transactional
  public void order(OrderDTO orderDTO) {
    // db에 주문 등록
    orderDao.enrollOrder(orderDTO);
    // db에 주문 카테고리 상세 정보 등록
    orderDao.enrollOrderCategory(orderDTO);
    
    // 장바구니 db 비우기
    List<CartDTO> cartList = new ArrayList<>();
    for(OrderCategoryDTO ocDTO : orderDTO.getOrders()) {
      CartDTO cartDTO = new CartDTO();
      cartDTO.setUserId(orderDTO.getUserId());
      cartDTO.setCategoryId(ocDTO.getCategoryId());
      
      cartList.add(cartDTO);
    }
    Map<String, List<CartDTO>> cartListMap = new HashMap<>();
    cartListMap.put("cartList", cartList);
    cartDao.deleteCartAfterOrder(cartListMap);
    
  }

}
