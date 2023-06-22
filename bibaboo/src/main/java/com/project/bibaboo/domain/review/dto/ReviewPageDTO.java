package com.project.bibaboo.domain.review.dto;

import java.util.List;
import com.project.bibaboo.global.common.dto.PageDTO;

public class ReviewPageDTO {

  private List<ReviewDTO> reviewList;
  private PageDTO pageDTO;
  
  public List<ReviewDTO> getReviewList() {
    return reviewList;
  }
  public void setReviewList(List<ReviewDTO> reviewList) {
    this.reviewList = reviewList;
  }
  public PageDTO getPageDTO() {
    return pageDTO;
  }
  public void setPageDTO(PageDTO pageDTO) {
    this.pageDTO = pageDTO;
  }
  
  @Override
  public String toString() {
    return "ReviewPageDTO [reviewList=" + reviewList + ", pageDTO=" + pageDTO + "]";
  }
  
}
