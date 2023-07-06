package com.project.bibaboo.domain.order.dto;

public class OrderCategoryStateDTO {
  private Integer orderCategoryId;
  private Integer alterId;
  private String state;
  
  public Integer getOrderCategoryId() {
    return orderCategoryId;
  }
  public void setOrderCategoryId(Integer orderCategoryId) {
    this.orderCategoryId = orderCategoryId;
  }
  public Integer getAlterId() {
    return alterId;
  }
  public void setAlterId(Integer alterId) {
    this.alterId = alterId;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  
}
