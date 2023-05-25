package com.project.bibaboo.domain.alterations.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bibaboo.domain.alterations.dao.AlterationsDao;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsDTO;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.domain.alterations.dto.Criteria;
import com.project.bibaboo.domain.alterations.dto.PageDTO;

@Service
public class AlterationsServiceImpl implements AlterationsService {

  private AlterationsDao alterationsDao;

  @Autowired
  public AlterationsServiceImpl(AlterationsDao alterationsDao) {
    this.alterationsDao = alterationsDao;
  }

  @Transactional
  @Override
  public void insert(AlterationsDTO alterationsDto, AlterPhotoDTO alterPhotoDto) {
    alterationsDao.insert(alterationsDto);
    alterationsDao.photoNameInsert(alterPhotoDto);
  }

  @Override
  public List<AlterationsDTO> selectAll() {
    return alterationsDao.selectAll();
  }

  @Override
  public AlterationsDTO selectById(AlterationsDTO alterationsDto) {
    return alterationsDao.selectById(alterationsDto);
  }
  
  @Transactional
  @Override
  public AlterationsWithPagingDTO getListWithPaging(Criteria criteria) {

    int total = alterationsDao.getTotal(criteria);
    PageDTO pageDTO = new PageDTO(criteria, total);

    AlterationsWithPagingDTO alterationsWithPagingDTO = new AlterationsWithPagingDTO();
    
    alterationsWithPagingDTO.setAlterList(alterationsDao.getListWithPaging(criteria));
    alterationsWithPagingDTO.setPageDTO(pageDTO);

    return alterationsWithPagingDTO;
  }

  @Override
  public void update(AlterationsDTO alterationsDto) {
    alterationsDao.update(alterationsDto);
  }
  
  @Override
  public void delete(Integer id) {
    alterationsDao.delete(id);
  }

}
