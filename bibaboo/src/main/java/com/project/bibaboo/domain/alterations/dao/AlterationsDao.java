package com.project.bibaboo.domain.alterations.dao;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.Criteria;

public interface AlterationsDao {
  
  public List<AlterationsDTO> selectAll();
  public List<AlterationsDTO> getListWithPaging(Criteria criteria);
  public int insert(AlterationsDTO alterationsDto);
  public int photoNameInsert(AlterPhotoDTO alterPhotoDto);
  public int delete(Integer id);
  public int getTotal(Criteria criteria);

}
