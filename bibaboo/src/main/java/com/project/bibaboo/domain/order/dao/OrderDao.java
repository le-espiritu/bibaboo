package com.project.bibaboo.domain.order.dao;

import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;

public interface OrderDao {
  
  public OrderPageCategoryDTO getGoodsInfoForOrder(int categoryId);
  public int enrollOrder(OrderDTO orderDTO);
  public int enrollOrderCategory(OrderDTO orderDTO);

}
