package com.project.bibaboo.domain.alterations.dao;

import java.sql.Connection;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.project.bibaboo.domain.alterations.dto.AlterationsDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AlterationsDaoTest {

  static Logger logger = LoggerFactory.getLogger(AlterationsDaoTest.class);

  @Autowired
  SqlSessionFactory sqlSessionFactory;

  @Autowired
  AlterationsDao alterationsDao;

  @Test
  public void configTest() throws Exception {
    // 아무 작업도 하지 않는다. 실행이 잘된다는 것은 Spring 설정이 잘 되어 있다는 것을 의미한다.
  }

  @Test
  public void connectionTest() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    Connection con = sqlSession.getConnection();
    logger.info("con : {}", con.toString());
    Assert.assertNotNull(con);
  }

  @Test
  public void insertTest() throws Exception {
    AlterationsDto alterationsDto =
        new AlterationsDto("테스트 수선집", "테스트 주소", "02-1234-5678", "오전 10시", "오후 8시");

    int rs = alterationsDao.insert(alterationsDto);
    Assert.assertEquals(1, rs);
  }

}
