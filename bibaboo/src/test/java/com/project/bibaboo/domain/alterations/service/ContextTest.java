package com.project.bibaboo.domain.alterations.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ContextTest {
  
  static Logger logger = LoggerFactory.getLogger(ContextTest.class);

  @Autowired
  WebApplicationContext context;
  
  @Test
  public void test() {
    String path = context.getServletContext().getRealPath("/resources/static/img/upload");
    logger.info("path : {}",path);
  }
  
}
