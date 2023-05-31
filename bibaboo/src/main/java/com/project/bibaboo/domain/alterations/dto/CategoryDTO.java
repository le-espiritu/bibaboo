package com.project.bibaboo.domain.alterations.dto;

public class CategoryDTO {

  Integer id;
  Integer alterId;
  String name;
  Integer price;
  String alterName;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getAlterName() {
    return alterName;
  }
  public void setAlterName(String alterName) {
    this.alterName = alterName;
  }
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
    return "CategoryDTO [id=" + id + ", alterId=" + alterId + ", name=" + name + ", price=" + price
        + ", alterName=" + alterName + "]";
  }
  
}
