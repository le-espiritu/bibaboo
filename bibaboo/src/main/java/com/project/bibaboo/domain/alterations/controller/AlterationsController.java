package com.project.bibaboo.domain.alterations.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.service.AlterationsService;
import com.project.bibaboo.domain.alterations.service.PhotoUploadLogicService;

@Controller
@RequestMapping("/alterations")
public class AlterationsController {

  AlterationsService alterationsService;
  PhotoUploadLogicService photoUploadLogicService;

  @Autowired
  public AlterationsController(AlterationsService alterationsService,
      PhotoUploadLogicService photoUploadLogicService) {
    this.alterationsService = alterationsService;
    this.photoUploadLogicService = photoUploadLogicService;
  }

  @PostMapping
  public String register(@ModelAttribute AlterationsDTO alterationsDto, HttpSession session)
      throws IllegalStateException, IOException {
    
    System.out.println(alterationsDto);
    MultipartFile file = alterationsDto.getFile();
    String path = session.getServletContext().getRealPath("/resources/static/img/upload");
    // System.out.println(path);

    // 파일(사진) 업로드
    AlterPhotoDTO alterPhotoDto = photoUploadLogicService.uploadPhoto(file, path);

    // db저장
    alterationsService.insert(alterationsDto, alterPhotoDto);

    return "redirect:/";
  }

}
