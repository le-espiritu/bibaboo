package com.project.bibaboo.domain.cart.dto;

public class CartDTO {

  private int id;
  private int categoryId;
  private int userId;
  private int count;
  
  private String alterName;
  private String categoryName;
  private int categoryPrice;
  
  private int totalPrice;

  public void initTotal() {
    this.totalPrice=this.categoryPrice * this.count;
  }
  
  public String getAlterName() {
    return alterName;
  }

  public void setAlterName(String alterName) {
    this.alterName = alterName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
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
    return "CartDTO [id=" + id + ", categoryId=" + categoryId + ", userId=" + userId + ", count="
        + count + ", alterName=" + alterName + ", categoryName=" + categoryName + ", categoryPrice="
        + categoryPrice + ", totalPrice=" + totalPrice + "]";
  }

}
