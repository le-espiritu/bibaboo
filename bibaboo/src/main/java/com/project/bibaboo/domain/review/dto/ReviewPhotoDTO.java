package com.project.bibaboo.domain.review.dto;

public class ReviewPhotoDTO {
  private Integer id;
  private Integer reviewId;
  private String name;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getReviewId() {
    return reviewId;
  }
  public void setReviewId(Integer reviewId) {
    this.reviewId = reviewId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public String toString() {
    return "ReviewPhotoDTO [id=" + id + ", reviewId=" + reviewId + ", name=" + name + "]";
  }
  
}
