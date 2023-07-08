package com.project.bibaboo.domain.order.service;

import java.util.List;
import com.project.bibaboo.domain.order.dto.OrderCancleDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryAndPageDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryStateDTO;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderListAndPageDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderPageDTO;
import com.project.bibaboo.global.common.dto.Criteria;

public interface OrderService {

  public List<OrderPageCategoryDTO> getGoodsInfoForOrder(OrderPageDTO orderPageDTO);
  public void order(OrderDTO orderDTO);
  public OrderListAndPageDTO getOrderList(Criteria criteria);
  public void orderCancle(OrderCancleDTO orderCancleDTO);
  public List<OrderCategoryDTO> getOrderCategories(int orderId);
  public OrderCategoryAndPageDTO getCategoriesAndUserInfoByAlterId(Criteria criteria);
  public void updateOrderCategoryState(OrderCategoryStateDTO orderCategoryStateDTO);
}
