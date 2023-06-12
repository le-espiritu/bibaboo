package com.project.bibaboo.domain.order.dao;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.project.bibaboo.domain.order.dto.OrderDTO;
import com.project.bibaboo.global.common.dto.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderDaoTest {
  
  static Logger logger = LoggerFactory.getLogger(OrderDaoTest.class);

  @Autowired
  OrderDao orderDao;
  
  @Test
  public void getOrderListTest() {
    Criteria criteria = new Criteria();
    criteria.setKeyword(1+"");
    
    List<OrderDTO> list = orderDao.getOrderList(criteria);
    for(OrderDTO orderDTO : list) {
      logger.info(orderDTO.toString());
    }
    
    Assert.assertNotNull(list.get(0));
  }
  
  @Test
  public void getOrderTotalTest() {
    Criteria criteria = new Criteria();
    criteria.setKeyword(1+"");
    
    int rs = orderDao.getOrderTotal(criteria);
    logger.info(rs+"");
  }
}
