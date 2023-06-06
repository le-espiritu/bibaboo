package com.project.bibaboo.domain.order.dao;

import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;

public interface OrderDao {
  
  public OrderPageCategoryDTO getGoodsInfoForOrder(int categoryId);

}
