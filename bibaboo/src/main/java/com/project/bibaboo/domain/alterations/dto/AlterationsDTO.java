package com.project.bibaboo.domain.alterations.dto;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class AlterationsDTO {

  private Integer id;
  private Integer userId;
  private String name;
  private String address;
  private String telNumber;
  private String openTime;
  private String closeTime;
  private float avgScore;
  private MultipartFile file;
  private String photoName;
  
  private List<CategoryDTO> categoryList;

  public AlterationsDTO() {
    
  }
  
  public AlterationsDTO(String name, String address, String telNumber,
      String openTime, String closeTime) {
    super();
    this.name = name;
    this.address = address;
    this.telNumber = telNumber;
    this.openTime = openTime;
    this.closeTime = closeTime;
  }

  public List<CategoryDTO> getCategoryList() {
    return categoryList;
  }

  public void setCategoryList(List<CategoryDTO> categoryList) {
    this.categoryList = categoryList;
  }

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }

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

  public String getPhotoName() {
    return photoName;
  }

  public void setPhotoName(String photoName) {
    this.photoName = photoName;
  }

  @Override
  public String toString() {
    return "AlterationsDTO [id=" + id + ", userId=" + userId + ", name=" + name + ", address="
        + address + ", telNumber=" + telNumber + ", openTime=" + openTime + ", closeTime="
        + closeTime + ", avgScore=" + avgScore + ", file=" + file + ", photoName=" + photoName
        + ", categoryList=" + categoryList + "]";
  }

}
