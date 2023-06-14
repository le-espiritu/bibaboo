package com.project.bibaboo.domain.review.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bibaboo.domain.review.dao.ReviewDao;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPhotoDTO;

@Service
public class ReviewServiceImpl implements ReviewService {
  
  ReviewDao reviewDao;
  
  @Autowired
  public ReviewServiceImpl(ReviewDao reviewDao) {
    this.reviewDao=reviewDao;
  }

  @Override
  @Transactional
  public void enrollReview(ReviewDTO reviewDTO) {
    //후기 등록
    reviewDao.enrollReview(reviewDTO);
    
    //사진 업로드
    if(reviewDTO.getReviewPhotos().size()>0) {
      reviewDao.insertPhotoNameList(reviewDTO);
    }
    
    //수선집의 avg_score 값 업데이트
    reviewDao.updateAvgScore(reviewDTO);
    //카테고리 score값 더해주기 
    reviewDao.plusCategoryScore(reviewDTO);
  }

}