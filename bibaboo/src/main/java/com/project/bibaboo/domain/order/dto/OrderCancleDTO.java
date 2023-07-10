package com.project.bibaboo.domain.order.dto;

public class OrderCancleDTO {
  private Integer userId;
  private int orderId;
  
  private Integer orderCategoryId;
  
  //redirect할때 사용될 paging 정보
  private String keyword;
  private int amount;
  private int pageNum;
  
  public Integer getOrderCategoryId() {
    return orderCategoryId;
  }
  public void setOrderCategoryId(Integer orderCategoryId) {
    this.orderCategoryId = orderCategoryId;
  }
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  public int getOrderId() {
    return orderId;
  }
  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }
  public String getKeyword() {
    return keyword;
  }
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }
  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }
  public int getPageNum() {
    return pageNum;
  }
  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }
  
  @Override
  public String toString() {
    return "OrderCancleDTO [userId=" + userId + ", orderId=" + orderId + ", orderCategoryId="
        + orderCategoryId + ", keyword=" + keyword + ", amount=" + amount + ", pageNum=" + pageNum
        + "]";
  }
  
}
