package com.project.bibaboo.domain.order.dao;

import java.util.List;
import com.project.bibaboo.domain.order.dto.OrderCancleDTO;
import com.project.bibaboo.domain.order.dto.OrderCategoryDTO;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.domain.order.dto.OrderPageCategoryDTO;
import com.project.bibaboo.global.common.dto.Criteria;

public interface OrderDao {
  
  public OrderPageCategoryDTO getGoodsInfoForOrder(int categoryId);
  public List<OrderDTO> getOrderList(Criteria criteria);
  public int enrollOrder(OrderDTO orderDTO);
  public int enrollOrderCategory(OrderDTO orderDTO);
  public int getOrderTotal(Criteria criteria);
  public int orderCancle(OrderCancleDTO orderCancleDTO);
  public int orderCategoryCancle(OrderCancleDTO orderCancleDTO);
  public List<OrderCategoryDTO> getOrderCategories(int orderId);

}
