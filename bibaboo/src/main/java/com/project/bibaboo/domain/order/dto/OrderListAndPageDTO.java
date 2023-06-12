package com.project.bibaboo.domain.order.dto;

import java.util.List;
import com.project.bibaboo.global.common.dto.PageDTO;

public class OrderListAndPageDTO {

  private List<OrderDTO> orderDTOList;
  private PageDTO pageDTO;

  public List<OrderDTO> getOrderDTOList() {
    return orderDTOList;
  }

  public void setOrderDTOList(List<OrderDTO> orderDTOList) {
    this.orderDTOList = orderDTOList;
  }

  public PageDTO getPageDTO() {
    return pageDTO;
  }

  public void setPageDTO(PageDTO pageDTO) {
    this.pageDTO = pageDTO;
  }

  @Override
  public String toString() {
    return "OrderListAndPageDTO [orderDTOList=" + orderDTOList + ", pageDTO=" + pageDTO + "]";
  }

}
