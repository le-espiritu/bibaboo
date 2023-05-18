package com.project.bibaboo.domain.alterations.dao;

import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

public interface AlterationsDao {
  
  public void insert(AlterationsDto alterationsDto);
  public void photoNameInsert(AlterPhotoDto alterPhotoDto);

}
