package com.project.bibaboo.domain.order.dto;

import java.util.List;
import com.project.bibaboo.global.common.dto.PageDTO;

public class OrderCategoryAndPageDTO {
  
  private List<OrderCategoryDTO> orderCategoryList;
  private PageDTO pageDTO;
  
  public List<OrderCategoryDTO> getOrderCategoryList() {
    return orderCategoryList;
  }
  public void setOrderCategoryList(List<OrderCategoryDTO> orderCategoryList) {
    this.orderCategoryList = orderCategoryList;
  }
  public PageDTO getPageDTO() {
    return pageDTO;
  }
  public void setPageDTO(PageDTO pageDTO) {
    this.pageDTO = pageDTO;
  }
  @Override
  public String toString() {
    return "OrderCategoryAndPageDTO [orderCategoryList=" + orderCategoryList + ", pageDTO="
        + pageDTO + "]";
  }
  
}
