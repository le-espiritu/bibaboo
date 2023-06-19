package com.project.bibaboo.domain.review.service;

import com.project.bibaboo.domain.review.dto.ReviewDTO;

public interface ReviewService {
  
  public void enrollReview(ReviewDTO reviewDTO);
  public void reviewExistsCheck(ReviewDTO reviewDTO);
  public void updateReview(ReviewDTO reviewDTO);
  public ReviewDTO getReviewForUpdate(int reviewId);
  public void deleteReview(ReviewDTO reviewDTO);
}
