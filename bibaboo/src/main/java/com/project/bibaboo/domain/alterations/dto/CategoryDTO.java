package com.project.bibaboo.domain.alterations.dto;

public class CategoryDTO {

  Integer alterId;
  String name;
  Integer price;
  public Integer getAlterId() {
    return alterId;
  }
  public void setAlterId(Integer alterId) {
    this.alterId = alterId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getPrice() {
    return price;
  }
  public void setPrice(Integer price) {
    this.price = price;
  }
  
  @Override
  public String toString() {
    return "CategoryDTO [alterId=" + alterId + ", name=" + name + ", price=" + price + "]";
  }

}
