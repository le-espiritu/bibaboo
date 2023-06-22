package com.project.bibaboo.domain.alterations.dto;

import java.util.List;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.global.common.dto.PageDTO;

public class AlterationsAndReviewsDTO {
  
  private AlterationsDTO alterationsDTO;
  private List<ReviewDTO> reviewList;
  private PageDTO pageDTO;
  
  public PageDTO getPageDTO() {
    return pageDTO;
  }
  public void setPageDTO(PageDTO pageDTO) {
    this.pageDTO = pageDTO;
  }
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
        + reviewList + ", pageDTO=" + pageDTO + "]";
  }
  
}
