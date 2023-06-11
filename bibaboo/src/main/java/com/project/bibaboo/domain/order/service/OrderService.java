package com.project.bibaboo.domain.order.service;

import java.util.List;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderPageDTO;

public interface OrderService {

  public List<OrderPageCategoryDTO> getGoodsInfoForOrder(OrderPageDTO orderPageDTO);
  public void order(OrderDTO orderDTO);
}
