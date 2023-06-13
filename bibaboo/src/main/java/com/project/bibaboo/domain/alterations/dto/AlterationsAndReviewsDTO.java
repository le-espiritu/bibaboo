package com.project.bibaboo.domain.alterations.dto;

import java.util.List;
import com.project.bibaboo.domain.review.dto.ReviewDTO;

public class AlterationsAndReviewsDTO {
  
  private AlterationsDTO alterationsDTO;
  private List<ReviewDTO> reviewList;
  public AlterationsDTO getAlterationsDTO() {
    return alterationsDTO;
  }
  public void setAlterationsDTO(AlterationsDTO alterationsDTO) {
    this.alterationsDTO = alterationsDTO;
  }
  public List<ReviewDTO> getReviewList() {
    return reviewList;
  }
  public void setReviewList(List<ReviewDTO> reviewList) {
    this.reviewList = reviewList;
  }
  
  @Override
  public String toString() {
    return "AlterationsAndReviewsDTO [alterationsDTO=" + alterationsDTO + ", reviewList="
        + reviewList + "]";
  }
  
}
