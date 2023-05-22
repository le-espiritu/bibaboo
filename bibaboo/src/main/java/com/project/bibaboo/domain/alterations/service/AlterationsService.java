package com.project.bibaboo.domain.alterations.service;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.domain.alterations.dto.Criteria;

public interface AlterationsService {
  
  public List<AlterationsDto> selectAll();
  public AlterationsWithPagingDTO getListWithPaging(Criteria criteria);
  public void insert(AlterationsDto alterationsDto, AlterPhotoDto alterPhotoDto);
  public void delete(Integer id);

}
