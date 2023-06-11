package com.project.bibaboo.domain.alterations.service;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.global.common.dto.Criteria;

public interface AlterationsService {
  
  public List<AlterationsDTO> selectAll();
  public AlterationsDTO selectById(int id);
  public AlterationsWithPagingDTO getListWithPaging(Criteria criteria);
  public void insert(AlterationsDTO alterationsDto, AlterPhotoDTO alterPhotoDto);
  public void update(AlterationsDTO alterationsDto);
  public void delete(Integer id);

}
