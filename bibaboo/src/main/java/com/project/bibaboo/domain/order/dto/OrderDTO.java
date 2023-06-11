package com.project.bibaboo.domain.order.dto;

import java.util.List;

public class OrderDTO {

  private int id;
  private int userId;
  private int payPrice;
  private String createDate;
  private String state;
  
  private List<OrderCategoryDTO> orders;

  private String userEmail;
  private String userName;
  private String userPhoneNumber;

  
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public List<OrderCategoryDTO> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderCategoryDTO> orders) {
    this.orders = orders;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getPayPrice() {
    return payPrice;
  }

  public void setPayPrice(int payPrice) {
    this.payPrice = payPrice;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

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

  @Override
  public String toString() {
    return "OrderDTO [id=" + id + ", userId=" + userId + ", payPrice=" + payPrice + ", createDate="
        + createDate + ", state=" + state + ", orders=" + orders + ", userEmail=" + userEmail
        + ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber + "]";
  }
  
}
