package com.project.bibaboo.domain.alterations.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.domain.alterations.dto.AlterTop5DTO;
import com.project.bibaboo.global.common.dto.Criteria;
import com.project.bibaboo.domain.alterations.service.AlterationsService;
import com.project.bibaboo.global.common.service.PhotoUploadLogicService;

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

  @PostMapping("/check")
  @PreAuthorize("hasAnyRole('OWNER,ADMIN')")
  public ResponseEntity<Object> AlterationsExistCheck(@RequestBody AlterationsDTO alterationsDTO){
    alterationsService.alterationsExistCheck(alterationsDTO);
    
    return ResponseEntity.ok().build();
  }
  
  @PostMapping
  @PreAuthorize("hasAnyRole('OWNER,ADMIN')")
  public String registerAlterations(@ModelAttribute AlterationsDTO alterationsDto, HttpSession session)
      throws IllegalStateException, IOException {

    MultipartFile file = alterationsDto.getFile();
    String path = session.getServletContext().getRealPath("/resources/static/img/upload");

    // 파일(사진) 업로드
    String newFileName = photoUploadLogicService.uploadPhoto(file, path);
    AlterPhotoDTO alterPhotoDto = new AlterPhotoDTO();
    alterPhotoDto.setName(newFileName);

    // db저장
    alterationsService.insert(alterationsDto, alterPhotoDto);

    return "redirect:/";
  }
  
  @GetMapping
  public ModelAndView getListByArea(@ModelAttribute Criteria criteria) {
    AlterationsWithPagingDTO alterationsWithPagingDto = alterationsService.getListWithPaging(criteria);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("alterationsWithPagingDto", alterationsWithPagingDto);
    mv.setViewName("alter/alter-list");
    
    return mv;
  }

  @PatchMapping("/{id}")
  public String update(@PathVariable(name = "id") int id,
      @ModelAttribute AlterationsDTO alterationsDto, HttpServletRequest request) {
    
    alterationsDto.setId(id);
    alterationsService.update(alterationsDto);

    String referer = request.getHeader("Referer");
    
    return "redirect:"+referer;
  }
  
  @DeleteMapping("/{id}")
  public String deleteAlterations(@PathVariable(name = "id") int id) {
    alterationsService.delete(id);
    return "redirect:/admin/alterations";
  }

  @GetMapping("/whole-top5")
  public ModelAndView getWholeTopFive(@ModelAttribute AlterTop5DTO alterTop5DTO) {
    
    AlterTop5DTO top5Response = alterationsService.getTopFive(alterTop5DTO);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("top5Response", top5Response);
    mv.setViewName("alter/whole-top5");
    
    return mv;
  }
  
  @GetMapping("/area-top5")
  public ModelAndView getAreaTopFive(@ModelAttribute AlterTop5DTO alterTop5DTO) {
    
    AlterTop5DTO top5Response = alterationsService.getTopFive(alterTop5DTO);
    
    ModelAndView mv = new ModelAndView();
    mv.addObject("top5Response", top5Response);
    mv.setViewName("alter/area-top5");
    
    return mv;
  }
}
