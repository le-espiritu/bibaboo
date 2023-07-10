package com.project.bibaboo.domain.alterations.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bibaboo.domain.alterations.dao.AlterationsCategoryDao;
import com.project.bibaboo.domain.alterations.dao.AlterationsDao;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsAndReviewsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.domain.alterations.exception.AlterationsDuplicatedException;
import com.project.bibaboo.domain.alterations.dto.AlterTop5DTO;
import com.project.bibaboo.domain.review.dao.ReviewDao;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPhotoDTO;
import com.project.bibaboo.global.common.dto.Criteria;
import com.project.bibaboo.global.common.dto.PageDTO;

@Service
public class AlterationsServiceImpl implements AlterationsService {

  private AlterationsDao alterationsDao;
  private AlterationsCategoryDao alterationsCategoryDao;
  private ReviewDao reviewDao;

  @Autowired
  public AlterationsServiceImpl(AlterationsDao alterationsDao,
      AlterationsCategoryDao alterationsCategoryDao, ReviewDao reviewDao) {
    this.alterationsDao = alterationsDao;
    this.alterationsCategoryDao = alterationsCategoryDao;
    this.reviewDao = reviewDao;
  }

  @Transactional
  @Override
  public void insert(AlterationsDTO alterationsDto, AlterPhotoDTO alterPhotoDto) {
    alterationsDao.insert(alterationsDto);
    alterationsDao.photoNameInsert(alterPhotoDto);
  }

  @Override
  public List<AlterationsDTO> selectAll() {
    return alterationsDao.selectAll();
  }
  
  @Override
  @Transactional
  public AlterationsDTO selectById(int id) {
    
    AlterationsDTO alterationsDTO = alterationsDao.selectById(id);
    alterationsDTO.setCategoryList(alterationsCategoryDao.getCategories(id));
    
    return alterationsDTO;
  }

  @Override
  @Transactional
  public AlterationsAndReviewsDTO getAlterDetailAndReviews(int id, Criteria criteria) {

    AlterationsDTO alterationsDTO = alterationsDao.selectById(id);
    alterationsDTO.setCategoryList(alterationsCategoryDao.getCategories(id));
    
    criteria.setAlterId(id);
    List<ReviewDTO>reviewList = reviewDao.getReviewList(criteria);
    for(ReviewDTO review : reviewList) {
      List<ReviewPhotoDTO> reviewPhotos = reviewDao.getReviewPhoto(review.getId());
      review.setReviewPhotos(reviewPhotos);
    }
    
    AlterationsAndReviewsDTO alterAndReviews = new AlterationsAndReviewsDTO();
    alterAndReviews.setAlterationsDTO(alterationsDTO);
    alterAndReviews.setReviewList(reviewList);
    
    PageDTO pageDTO = new PageDTO(criteria,reviewDao.getReviewTotal(criteria));
    alterAndReviews.setPageDTO(pageDTO);

    return alterAndReviews;
  }

  @Transactional
  @Override
  public AlterationsWithPagingDTO getListWithPaging(Criteria criteria) {

    int total = alterationsDao.getTotal(criteria);
    PageDTO pageDTO = new PageDTO(criteria, total);

    AlterationsWithPagingDTO alterationsWithPagingDTO = new AlterationsWithPagingDTO();

    alterationsWithPagingDTO.setAlterList(alterationsDao.getListWithPaging(criteria));
    alterationsWithPagingDTO.setPageDTO(pageDTO);

    return alterationsWithPagingDTO;
  }

  @Override
  public void update(AlterationsDTO alterationsDto) {
    alterationsDao.update(alterationsDto);
  }

  @Override
  public void delete(Integer id) {
    alterationsDao.delete(id);
  }

  @Override
  public AlterTop5DTO getTopFive(AlterTop5DTO alterTop5DTO) {
    List<AlterationsDTO> alterTop5List = alterationsDao.getTopFive(alterTop5DTO);
    alterTop5DTO.setAlterTop5List(alterTop5List);
    
    return alterTop5DTO;
  }

  @Override
  public void alterationsExistCheck(AlterationsDTO alterationsDTO) {
    boolean result = alterationsDao.alterationsExistCheck(alterationsDTO);
    if(result == true) {
      throw new AlterationsDuplicatedException("이미 수선집이 등록되었습니다.");
    }
    
  }

  @Override
  public AlterationsDTO selectByUserId(int userId) {
    return alterationsDao.selectByUserId(userId);
  }

}
