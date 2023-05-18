package com.project.bibaboo.domain.alterations.service;

import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

public interface AlterationsService {
  
  public void insert(AlterationsDto alterationsDto, AlterPhotoDto alterPhotoDto);

}
