package com.project.bibaboo.domain.order.dto;

import java.sql.Date;

public class OrderCategoryDTO {

  //alter_order_category 테이블 기본 키
  private int orderCategoryId;
  // 주문 번호
  private int orderId;
  private int alterId;
  private int categoryId;
  private int count;
  private String state;
  private int categoryPrice;
  private int totalPrice;
  
  // from alterations 
  private String alterName;
  // from category 
  private String categoryName;
  
  // from alter_order
  private String userEmail;
  private String userName;
  private String userPhoneNumber;
  private Date createDate;
  
  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPhoneNumber() {
    return userPhoneNumber;
  }

  public void setUserPhoneNumber(String userPhoneNumber) {
    this.userPhoneNumber = userPhoneNumber;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getAlterName() {
    return alterName;
  }

  public void setAlterName(String alterName) {
    this.alterName = alterName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

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

  public String getState() {
    return state;
  }

  public void setState(String state) {
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
        + state + ", categoryPrice=" + categoryPrice + ", totalPrice=" + totalPrice + ", alterName="
        + alterName + ", categoryName=" + categoryName + ", userEmail=" + userEmail + ", userName="
        + userName + ", userPhoneNumber=" + userPhoneNumber + ", createDate=" + createDate + "]";
  }

}
