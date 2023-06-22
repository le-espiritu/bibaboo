package com.project.bibaboo.domain.review.service;

import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPageDTO;
import com.project.bibaboo.global.common.dto.Criteria;

public interface ReviewService {
  
  public void enrollReview(ReviewDTO reviewDTO);
  public void reviewExistsCheck(ReviewDTO reviewDTO);
  public void updateReview(ReviewDTO reviewDTO);
  public ReviewPageDTO getReviewsAndPage(Criteria criteria);
  public ReviewDTO getReviewForUpdate(int reviewId);
  public void deleteReview(ReviewDTO reviewDTO);
}
