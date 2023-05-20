package com.project.bibaboo.domain.alterations.dao;

import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

public interface AlterationsDao {
  
  public int insert(AlterationsDto alterationsDto);
  public int photoNameInsert(AlterPhotoDto alterPhotoDto);

}
