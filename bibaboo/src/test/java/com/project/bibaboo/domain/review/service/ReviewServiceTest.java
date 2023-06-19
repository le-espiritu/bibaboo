package com.project.bibaboo.domain.review.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.project.bibaboo.domain.review.dto.ReviewDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ReviewServiceTest {

  static Logger loogger = LoggerFactory.getLogger(ReviewServiceTest.class);
  
  @Autowired
  ReviewService reviewService;
  
  @Test
  public void reviewExistsCheckTest() {
    ReviewDTO reviewDTO = new ReviewDTO();
    reviewDTO.setUserId(1);
    reviewDTO.setOrderCategoryId(1);
    
    reviewService.reviewExistsCheck(reviewDTO);
  }
}
