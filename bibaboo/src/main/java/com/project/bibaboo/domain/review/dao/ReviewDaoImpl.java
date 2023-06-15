package com.project.bibaboo.domain.review.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPhotoDTO;

@Repository
public class ReviewDaoImpl implements ReviewDao{

  SqlSession sqlSession;
  
  public ReviewDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }
  
  @Override
  public int enrollReview(ReviewDTO reviewDTO) {
    return sqlSession.insert("review.enrollReview", reviewDTO);
  }

  @Override
  public int updateAvgScore(ReviewDTO reviewDTO) {
    return sqlSession.update("review.updateAvgScore", reviewDTO);
  }

  @Override
  public int plusCategoryScore(ReviewDTO reviewDTO) {
    return sqlSession.update("review.plusCategoryScore", reviewDTO);
  }

  @Override
  public List<ReviewDTO> getReviewList(int alaterId) {
    return sqlSession.selectList("review.getReview", alaterId);
  }

  @Override
  public int insertPhotoNameList(ReviewDTO reviewDTO) {
    return sqlSession.insert("review.insertPhotoNameList", reviewDTO);
  }

  @Override
  public List<ReviewPhotoDTO> getReviewPhoto(int reviewId) {
    return sqlSession.selectList("review.getReviewPhoto", reviewId);
  }

  @Override
  public boolean reviewExistsCheck(ReviewDTO reviewDTO) {
    return sqlSession.selectOne("review.reviewExistsCheck", reviewDTO);
  }

}
