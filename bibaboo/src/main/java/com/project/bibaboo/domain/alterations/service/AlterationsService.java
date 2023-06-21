package com.project.bibaboo.domain.alterations.service;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsAndReviewsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.domain.alterations.dto.AlterTop5DTO;
import com.project.bibaboo.global.common.dto.Criteria;

public interface AlterationsService {
  
  public List<AlterationsDTO> selectAll();
  public AlterationsAndReviewsDTO selectById(int id);
  public AlterationsWithPagingDTO getListWithPaging(Criteria criteria);
  public void insert(AlterationsDTO alterationsDto, AlterPhotoDTO alterPhotoDto);
  public void update(AlterationsDTO alterationsDto);
  public void delete(Integer id);
  public AlterTop5DTO getTopFive(AlterTop5DTO alterTop5DTO);

}
