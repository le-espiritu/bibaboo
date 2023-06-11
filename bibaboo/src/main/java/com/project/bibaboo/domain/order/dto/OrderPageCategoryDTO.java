package com.project.bibaboo.domain.order.dto;

public class OrderPageCategoryDTO {
  
  // 뷰로부터 전달받을 값 
  private int categoryId;
  private int count;
  
  //db로부터 꺼내올 값
  private int alterId;
  private String alterName;
  private String categoryName;
  private int categoryPrice;
  
  //만들어 낼 값
  private int totalPrice;

  
  public int getAlterId() {
    return alterId;
  }

  public void setAlterId(int alterId) {
    this.alterId = alterId;
  }

  public String getAlterName() {
    return alterName;
  }

  public void setAlterName(String alterName) {
    this.alterName = alterName;
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
  
  public void initTotal() {
    this.totalPrice = this.categoryPrice*this.count;
  }

  @Override
  public String toString() {
    return "OrderPageCategoryDTO [categoryId=" + categoryId + ", count=" + count + ", alterId="
        + alterId + ", alterName=" + alterName + ", categoryName=" + categoryName
        + ", categoryPrice=" + categoryPrice + ", totalPrice=" + totalPrice + "]";
  }

}
