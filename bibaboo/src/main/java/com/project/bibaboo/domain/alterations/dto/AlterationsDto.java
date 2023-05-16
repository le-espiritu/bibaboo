package com.project.bibaboo.domain.alterations.dto;

public class AlterationsDto {

  private Integer id;
  private Integer userId;
  private String name;
  private String address;
  private String telNumber;
  private String openTime;
  private String closeTime;
  private float avgScore;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTelNumber() {
    return telNumber;
  }

  public void setTelNumber(String telNumber) {
    this.telNumber = telNumber;
  }

  public String getOpenTime() {
    return openTime;
  }

  public void setOpenTime(String openTime) {
    this.openTime = openTime;
  }

  public String getCloseTime() {
    return closeTime;
  }

  public void setCloseTime(String closeTime) {
    this.closeTime = closeTime;
  }

  public float getAvgScore() {
    return avgScore;
  }

  public void setAvgScore(float avgScore) {
    this.avgScore = avgScore;
  }

  @Override
  public String toString() {
    return "AlterationsDto [id=" + id + ", userId=" + userId + ", name=" + name + ", address="
        + address + ", telNumber=" + telNumber + ", openTime=" + openTime + ", closeTime="
        + closeTime + ", avgScore=" + avgScore + "]";
  }

}
