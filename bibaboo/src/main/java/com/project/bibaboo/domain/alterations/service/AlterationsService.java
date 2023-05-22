package com.project.bibaboo.domain.alterations.service;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.domain.alterations.dto.Criteria;

public interface AlterationsService {
  
  public List<AlterationsDTO> selectAll();
  public AlterationsWithPagingDTO getListWithPaging(Criteria criteria);
  public void insert(AlterationsDTO alterationsDto, AlterPhotoDTO alterPhotoDto);
  public void delete(Integer id);

}
