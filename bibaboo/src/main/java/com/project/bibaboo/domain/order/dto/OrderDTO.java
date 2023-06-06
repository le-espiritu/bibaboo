package com.project.bibaboo.domain.order.dto;

import java.util.List;

public class OrderDTO {

  private int id;
  private int userId;
  private int alterId;
  private int totalPrice;
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

  public int getAlterId() {
    return alterId;
  }

  public void setAlterId(int alterId) {
    this.alterId = alterId;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
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
    return "OrderDTO [id=" + id + ", userId=" + userId + ", alterId=" + alterId + ", totalPrice="
        + totalPrice + ", createDate=" + createDate + ", state=" + state + ", orders=" + orders
        + ", userEmail=" + userEmail + ", userName=" + userName + ", userPhoneNumber="
        + userPhoneNumber + "]";
  }

}
