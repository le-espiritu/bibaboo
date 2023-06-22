package com.project.bibaboo.domain.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPageDTO;
import com.project.bibaboo.domain.review.dto.ReviewPhotoDTO;
import com.project.bibaboo.domain.review.service.ReviewService;
import com.project.bibaboo.global.common.dto.Criteria;
import com.project.bibaboo.global.common.service.PhotoUploadLogicService;

@Controller
@RequestMapping("/review")
public class ReviewController {

  ReviewService reviewService;
  PhotoUploadLogicService photoUploadLogicService;
  
  @Autowired
  public ReviewController(ReviewService reviewService, PhotoUploadLogicService photoUploadLogicService) {
    this.reviewService=reviewService;
    this.photoUploadLogicService = photoUploadLogicService;
  }
  
  @PostMapping
  public String enrollReview(@ModelAttribute ReviewDTO reviewDTO, HttpSession session) throws IllegalStateException, IOException {
    
    String path = session.getServletContext().getRealPath("/resources/static/img/upload");
    List<MultipartFile> files = reviewDTO.getFiles();
    
    List<ReviewPhotoDTO> reviewPhotoDTOList = new ArrayList<>();
    
    //파일 리스트 업로드 
    for(MultipartFile multipartFile : files) {
      
      if(multipartFile.isEmpty()) {
        continue;
      }
      
      String newFileName = photoUploadLogicService.uploadPhoto(multipartFile, path);
      
      ReviewPhotoDTO reviewPhotoDTO = new ReviewPhotoDTO();
      reviewPhotoDTO.setName(newFileName);
      
      reviewPhotoDTOList.add(reviewPhotoDTO);
    }
    
    //db 저장 
    reviewDTO.setReviewPhotos(reviewPhotoDTOList);
    reviewService.enrollReview(reviewDTO);
    
    return"redirect:/alterations/"+reviewDTO.getAlterId();
  }
  
  @PostMapping("/check")
  public ResponseEntity<Object> reviewExistsCheck(@RequestBody ReviewDTO reviewDTO){
    // @ModelAttribute 는 form 데이터를 받아서 자바 객체로 매핑할때 사용
    // @RequestBody는 request body를 통해서 전달된 json 데이터를 자바 객체로 매핑할때 사용
    
    reviewService.reviewExistsCheck(reviewDTO);
    
    return ResponseEntity.ok().build();
    
  }
  
  @GetMapping("/{alterId}")
  @ResponseBody
  public ReviewPageDTO getReviews(@PathVariable(name="alterId") int alterId, Criteria criteria) {
    
    criteria.setAlterId(alterId);
    
    return reviewService.getReviewsAndPage(criteria);
  }
  
  @GetMapping("/update-page")
  public ModelAndView getReviewUpdateView(ReviewDTO reviewDTO) {
    
    ReviewDTO reviewInfo = reviewService.getReviewForUpdate(reviewDTO.getId());
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("reviewInfo", reviewInfo);
    mv.addObject("userId", reviewDTO.getUserId());
    mv.setViewName("review-update-popup-view");
    
    return mv;
  }
  
  @PatchMapping
  public String upadateReview(@ModelAttribute ReviewDTO reviewDTO) {

    reviewService.updateReview(reviewDTO);
    
    return"redirect:/alterations/"+reviewDTO.getAlterId();
  }
  
  @DeleteMapping
  public ResponseEntity<Object> deleteReview(@RequestBody ReviewDTO reviewDTO){
    
    reviewService.deleteReview(reviewDTO);
    
    return ResponseEntity.ok().build();
  }

}
