package com.project.bibaboo.domain.order.dto;

public class OrderCategoryDTO {

  //alter_order_category 테이블 기본 키
  private int orderCategoryId;
  // 주문 번호
  private int orderId;
  
  private int alterId;

  private int categoryId;

  private int count;

  private int state;

  private int categoryPrice;

  private int totalPrice;

  public int getAlterId() {
    return alterId;
  }

  public void setAlterId(int alterId) {
    this.alterId = alterId;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getOrderCategoryId() {
    return orderCategoryId;
  }

  public void setOrderCategoryId(int orderCategoryId) {
    this.orderCategoryId = orderCategoryId;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getCategoryPrice() {
    return categoryPrice;
  }

  public void setCategoryPrice(int categoryPrice) {
    this.categoryPrice = categoryPrice;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public String toString() {
    return "OrderCategoryDTO [orderCategoryId=" + orderCategoryId + ", orderId=" + orderId
        + ", alterId=" + alterId + ", categoryId=" + categoryId + ", count=" + count + ", state="
        + state + ", categoryPrice=" + categoryPrice + ", totalPrice=" + totalPrice + "]";
  }

}
