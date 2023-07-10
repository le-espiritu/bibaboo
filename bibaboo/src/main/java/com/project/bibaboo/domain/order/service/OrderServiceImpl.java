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
import com.project.bibaboo.domain.order.dto.OrderCancleDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryAndPageDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryStateDTO;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderListAndPageDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderPageDTO;
import com.project.bibaboo.global.common.dto.Criteria;
import com.project.bibaboo.global.common.dto.PageDTO;

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

  @Override
  @Transactional
  public OrderListAndPageDTO getOrderList(Criteria criteria) {
    
    List<OrderDTO> list = orderDao.getOrderList(criteria);
    int total = orderDao.getOrderTotal(criteria);
    PageDTO pageDTO = new PageDTO(criteria, total);
    
    OrderListAndPageDTO orderListAndPageDTO = new OrderListAndPageDTO();
    orderListAndPageDTO.setOrderDTOList(list);
    orderListAndPageDTO.setPageDTO(pageDTO);
    
    return orderListAndPageDTO;
  }

  @Override
  @Transactional
  public void orderCancle(OrderCancleDTO orderCancleDTO) {
    orderDao.orderCancle(orderCancleDTO);
    orderDao.orderCategoryCancle(orderCancleDTO);
  }
  
  @Override
  public void cancleByOrderCategoryId(OrderCancleDTO orderCancleDTO) {
    orderDao.cancleByOrderCategoryId(orderCancleDTO);
  }

  @Override
  public List<OrderCategoryDTO> getOrderCategories(int orderId) {
    return orderDao.getOrderCategories(orderId);
  }

  @Override
  @Transactional
  public OrderCategoryAndPageDTO getCategoriesAndUserInfoByAlterId(Criteria criteria) {
    
    OrderCategoryAndPageDTO orderCategoryPage = new OrderCategoryAndPageDTO();
    
    orderCategoryPage.setOrderCategoryList(orderDao.getCategoriesAndUserInfoByAlterId(criteria));
    PageDTO pageDTO = new PageDTO(criteria, orderDao.countOrderCategoriesByAlterId(criteria));
    orderCategoryPage.setPageDTO(pageDTO);
    
    return orderCategoryPage;
  }

  @Override
  public void updateOrderCategoryState(OrderCategoryStateDTO orderCategoryStateDTO) {
    orderDao.updateOrderCategoryState(orderCategoryStateDTO);
    
  }

  @Override
  public String orderCategoryStateCheckForReview(int orderCategoryId) {
    return orderDao.orderCategoryStateCheckForReview(orderCategoryId);
  }

}
