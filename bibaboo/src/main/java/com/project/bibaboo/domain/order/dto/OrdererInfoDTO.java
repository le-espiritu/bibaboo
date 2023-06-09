package com.project.bibaboo.domain.order.dto;

public class OrdererInfoDTO {

  private Integer id;
  private String email;
  private String name;
  private String phoneNumber;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  @Override
  public String toString() {
    return "OrdererInfoDTO [id=" + id + ", email=" + email + ", name=" + name + ", phoneNumber="
        + phoneNumber + "]";
  }
  
}
