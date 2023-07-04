package com.project.bibaboo.domain.alterations.dao;

import java.util.List;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterTop5DTO;
import com.project.bibaboo.global.common.dto.Criteria;

public interface AlterationsDao {
  
  public List<AlterationsDTO> selectAll();
  public AlterationsDTO selectById(int id);
  public AlterationsDTO selectByUserId(int userId);
  public List<AlterationsDTO> getListWithPaging(Criteria criteria);
  public int insert(AlterationsDTO alterationsDto);
  public int photoNameInsert(AlterPhotoDTO alterPhotoDto);
  public int update(AlterationsDTO alterationsDto);
  public int delete(Integer id);
  public int getTotal(Criteria criteria);
  public List<AlterationsDTO> getTopFive(AlterTop5DTO alterTop5DTO);
  public boolean alterationsExistCheck(AlterationsDTO alterationsDTO);

}
