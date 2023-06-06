package com.project.bibaboo.domain.order.dto;

import java.util.List;

public class OrderPageDTO {
  
  private List<OrderPageCategoryDTO> orders;

  public List<OrderPageCategoryDTO> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderPageCategoryDTO> orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "OrderPageDTO [orders=" + orders + "]";
  }
  
}
