package com.project.bibaboo.domain.alterations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bibaboo.domain.alterations.dao.AlterationsDao;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

@Service
public class AlterationsServiceImpl implements AlterationsService {

  private AlterationsDao alterationsDao;

  @Autowired
  public AlterationsServiceImpl(AlterationsDao alterationsDao) {
    this.alterationsDao = alterationsDao;
  }

  @Transactional
  @Override
  public void insert(AlterationsDto alterationsDto, String photoName) {
    alterationsDao.insert(alterationsDto);
    alterationsDao.photoNameInsert(photoName);
  }

}
