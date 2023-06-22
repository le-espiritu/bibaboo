package com.project.bibaboo.domain.review.dao;

import java.util.List;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPhotoDTO;
import com.project.bibaboo.global.common.dto.Criteria;

public interface ReviewDao {
  public int enrollReview(ReviewDTO reviewDTO);
  public int updateAvgScore(ReviewDTO reviewDTO);
  public int updateCategoryAvgScore(ReviewDTO reviewDTO);
  public List<ReviewDTO> getReviewList(Criteria criteria);
  public int getReviewTotal(int alterId);
  public int insertPhotoNameList(ReviewDTO reviewDTO);
  public List<ReviewPhotoDTO> getReviewPhoto(int reviewId);
  public boolean reviewExistsCheck(ReviewDTO reviewDTO);
  public int updateReview(ReviewDTO reviewDTO);
  public ReviewDTO getReviewForUpdate(int id);
  public int deleteReview(int reviewId);
}
