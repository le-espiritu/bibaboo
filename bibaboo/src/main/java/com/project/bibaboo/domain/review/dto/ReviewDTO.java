package com.project.bibaboo.domain.review.dto;

import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ReviewDTO {
  private int id;
  private int userId;
  private String userEmail;
  private Integer orderCategoryId;
  private int alterId;
  private int categoryId;
  private String content;
  private int score;
  private int enable;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
  private Date createDate;
  /*
   * Gson, Jackson 라이브러리를 사용해서 Date, LocalDateTime 타입의 데이터를
   * json으로 변환할 경우 "yyyy-MM-dd" 형식 변환되지 않는다고 합니다. 따라서 json으로 변환 대상인 Date, LocalDateTime 타입의 데이터에 어떠한
   * 형식(포맷)으로 변환할지를 지정 해주면 된다고 합니다.
   */

  private List<MultipartFile> files;
  private String categoryName;
  private String alterName;
  private List<ReviewPhotoDTO> reviewPhotos;
  private int previousScore;

  public String getAlterName() {
    return alterName;
  }

  public void setAlterName(String alterName) {
    this.alterName = alterName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public int getPreviousScore() {
    return previousScore;
  }

  public void setPreviousScore(int previousScore) {
    this.previousScore = previousScore;
  }

  public List<ReviewPhotoDTO> getReviewPhotos() {
    return reviewPhotos;
  }

  public void setReviewPhotos(List<ReviewPhotoDTO> reviewPhotos) {
    this.reviewPhotos = reviewPhotos;
  }

  public List<MultipartFile> getFiles() {
    return files;
  }

  public void setFiles(List<MultipartFile> files) {
    this.files = files;
  }

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
    return "ReviewDTO [id=" + id + ", userId=" + userId + ", userEmail=" + userEmail
        + ", orderCategoryId=" + orderCategoryId + ", alterId=" + alterId + ", categoryId="
        + categoryId + ", content=" + content + ", score=" + score + ", enable=" + enable
        + ", createDate=" + createDate + ", files=" + files + ", categoryName=" + categoryName
        + ", alterName=" + alterName + ", reviewPhotos=" + reviewPhotos + ", previousScore="
        + previousScore + "]";
  }

}
