package com.project.bibaboo.domain.review.dao;

import java.util.List;
import com.project.bibaboo.domain.review.dto.ReviewDTO;

public interface ReviewDao {
  public int enrollReview(ReviewDTO reviewDTO);
  public int updateAvgScore(ReviewDTO reviewDTO);
  public int plusCategoryScore(ReviewDTO reviewDTO);
  public List<ReviewDTO> getReviewList(int alaterId);
}
