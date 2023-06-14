package com.project.bibaboo.domain.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.project.bibaboo.domain.review.dto.ReviewDTO;
import com.project.bibaboo.domain.review.dto.ReviewPhotoDTO;
import com.project.bibaboo.domain.review.service.ReviewService;
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
}
