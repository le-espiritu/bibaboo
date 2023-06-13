package com.project.bibaboo.domain.review.dto;

import java.util.Date;

public class ReviewDTO {
  private int id;
  private int userId;
  private Integer orderCategoryId;
  private int alterId;
  private int categoryId;
  private String content;
  private int score;
  private int enable;
  private Date createDate;
  
  private String categoryName;
  
  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
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
  public Integer getOrderCategoryId() {
    return orderCategoryId;
  }
  public void setOrderCategoryId(Integer orderCategoryId) {
    this.orderCategoryId = orderCategoryId;
  }
  public int getAlterId() {
    return alterId;
  }
  public void setAlterId(int alterId) {
    this.alterId = alterId;
  }
  public int getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public int getEnable() {
    return enable;
  }
  public void setEnable(int enable) {
    this.enable = enable;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  
  @Override
  public String toString() {
    return "ReviewDTO [id=" + id + ", userId=" + userId + ", orderCategoryId=" + orderCategoryId
        + ", alterId=" + alterId + ", categoryId=" + categoryId + ", content=" + content
        + ", score=" + score + ", enable=" + enable + ", createDate=" + createDate
        + ", categoryName=" + categoryName + "]";
  }
  
}
