package com.project.bibaboo.domain.review.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bibaboo.domain.review.dao.ReviewDao;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPageDTO;
import com.project.bibaboo.domain.review.dto.ReviewPhotoDTO;
import com.project.bibaboo.domain.review.exception.ReviewDuplicatedException;
import com.project.bibaboo.global.common.dto.Criteria;
import com.project.bibaboo.global.common.dto.PageDTO;

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
    //카테고리 score값 업데이트
    reviewDao.updateCategoryAvgScore(reviewDTO);
  }

  @Override
  public void reviewExistsCheck(ReviewDTO reviewDTO) {
    boolean isReviewExist = reviewDao.reviewExistsCheck(reviewDTO);
    if(isReviewExist == true) {
      throw new ReviewDuplicatedException("리뷰를 이미 작성하였습니다.");
    }
  }

  @Override
  @Transactional
  public void updateReview(ReviewDTO reviewDTO) {
    reviewDao.updateReview(reviewDTO);
    
    if(reviewDTO.getPreviousScore()!=reviewDTO.getScore()) {
      //수선집의 avg_score 값 업데이트
      reviewDao.updateAvgScore(reviewDTO);
      //카테고리 별점 합점 업데이트 
      reviewDao.updateCategoryAvgScore(reviewDTO);
    }
  }

  @Override
  public ReviewDTO getReviewForUpdate(int reviewId) {
    return reviewDao.getReviewForUpdate(reviewId);
  }

  @Override
  public void deleteReview(ReviewDTO reviewDTO) {
    
    reviewDao.deleteReview(reviewDTO.getId());
    //수선집의 avg_score 값 업데이트
    reviewDao.updateAvgScore(reviewDTO);
    //카테고리 별점  업데이트
    reviewDao.updateCategoryAvgScore(reviewDTO);
  }

  @Override
  @Transactional
  public ReviewPageDTO getReviewsAndPage(Criteria criteria) {
    
    List<ReviewDTO>reviewList = reviewDao.getReviewList(criteria);
    for(ReviewDTO review : reviewList) {
      List<ReviewPhotoDTO> reviewPhotos = reviewDao.getReviewPhoto(review.getId());
      review.setReviewPhotos(reviewPhotos);
    }
    
    ReviewPageDTO reviewPageDTO = new ReviewPageDTO();
    reviewPageDTO.setReviewList(reviewList);
    
    PageDTO pageDTO = new PageDTO(criteria,reviewDao.getReviewTotal(criteria));
    reviewPageDTO.setPageDTO(pageDTO);
    
    return reviewPageDTO;
  }

}
