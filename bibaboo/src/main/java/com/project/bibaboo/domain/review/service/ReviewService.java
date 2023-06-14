package com.project.bibaboo.domain.review.service;

import java.util.List;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPhotoDTO;

public interface ReviewService {
  
  public void enrollReview(ReviewDTO reviewDTO);
}
