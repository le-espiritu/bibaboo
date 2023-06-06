package com.project.bibaboo.domain.order.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.bibaboo.domain.order.dao.OrderDao;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderPageDTO;

@Service
public class OrderServiceImpl implements OrderService {
  
  OrderDao orderDao;
  
  @Autowired
  public OrderServiceImpl(OrderDao orderDao) {
    this.orderDao =orderDao;
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

}
