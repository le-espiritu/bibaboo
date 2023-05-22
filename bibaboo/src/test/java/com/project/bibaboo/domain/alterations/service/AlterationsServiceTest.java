package com.project.bibaboo.domain.alterations.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.project.bibaboo.domain.alterations.dto.AlterationsWithPagingDTO;
import com.project.bibaboo.domain.alterations.dto.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AlterationsServiceTest {

  static Logger logger = LoggerFactory.getLogger(AlterationsServiceTest.class);
  
  @Autowired
  AlterationsService alterationsService;
  
  @Test
  public void getListWithPaging() {
    Criteria criteria = new Criteria();
    AlterationsWithPagingDTO dto = alterationsService.getListWithPaging(criteria);
    logger.info(dto.toString());
  }
}
