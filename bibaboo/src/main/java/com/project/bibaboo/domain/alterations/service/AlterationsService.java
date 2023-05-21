package com.project.bibaboo.domain.alterations.service;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

public interface AlterationsService {
  
  public List<AlterationsDto> selectAll();
  public void insert(AlterationsDto alterationsDto, AlterPhotoDto alterPhotoDto);
  public void delete(Integer id);

}
