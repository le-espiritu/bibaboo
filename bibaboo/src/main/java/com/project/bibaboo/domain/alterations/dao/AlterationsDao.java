package com.project.bibaboo.domain.alterations.dao;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

public interface AlterationsDao {
  
  public List<AlterationsDto> selectAll();
  public int insert(AlterationsDto alterationsDto);
  public int photoNameInsert(AlterPhotoDto alterPhotoDto);

}
