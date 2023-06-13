package com.project.bibaboo.domain.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

  ReviewService reviewService;
  
  @Autowired
  public ReviewController(ReviewService reviewService) {
    this.reviewService=reviewService;
  }
  
  @PostMapping
  public String enrollReview(ReviewDTO reviewDTO) {
    
    reviewService.enrollReview(reviewDTO);
    
    return"redirect:/alterations/"+reviewDTO.getAlterId();
  }
}
