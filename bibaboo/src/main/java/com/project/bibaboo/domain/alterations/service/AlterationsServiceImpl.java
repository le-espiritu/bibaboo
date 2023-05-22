package com.project.bibaboo.domain.alterations.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bibaboo.domain.alterations.dao.AlterationsDao;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;
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
  public void insert(AlterationsDto alterationsDto, AlterPhotoDto alterPhotoDto) {
    alterationsDao.insert(alterationsDto);
    alterationsDao.photoNameInsert(alterPhotoDto);
  }

  @Override
  public List<AlterationsDto> selectAll() {
    return alterationsDao.selectAll();
  }

  @Transactional
  @Override
  public AlterationsWithPagingDTO getListWithPaging(Criteria criteria) {

    AlterationsWithPagingDTO alterationsWithPagingDTO = new AlterationsWithPagingDTO();
    alterationsWithPagingDTO.setAlterList(alterationsDao.getListWithPaging(criteria));

    int total = alterationsDao.getTotal();
    PageDTO pageDTO = new PageDTO(criteria, total);

    alterationsWithPagingDTO.setPageDTO(pageDTO);

    return alterationsWithPagingDTO;
  }

  @Override
  public void delete(Integer id) {
    alterationsDao.delete(id);
  }

}
