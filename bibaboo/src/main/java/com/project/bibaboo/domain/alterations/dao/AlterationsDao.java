package com.project.bibaboo.domain.alterations.dao;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;
import com.project.bibaboo.domain.alterations.dto.Criteria;

public interface AlterationsDao {
  
  public List<AlterationsDto> selectAll();
  public List<AlterationsDto> getListWithPaging(Criteria criteria);
  public int insert(AlterationsDto alterationsDto);
  public int photoNameInsert(AlterPhotoDto alterPhotoDto);
  public int delete(Integer id);
  public int getTotal();

}
