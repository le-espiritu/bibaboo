package com.project.bibaboo.domain.alterations.service;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import com.project.bibaboo.global.common.service.PhotoUploadLogicService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 실제 프로젝트의 web.xml이 아닌 가상의 web.xml을 사용하기 위한 설정이다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PhotoUploadLogicServiceTest {

  static Logger logger = LoggerFactory.getLogger(PhotoUploadLogicServiceTest.class);

  @Autowired
  PhotoUploadLogicService photoUploadLogicService;
  
  @Autowired
  WebApplicationContext context;

  @Test
  public void fileUploadTest() throws IllegalStateException, IOException {
    MockMultipartFile file = new MockMultipartFile("testFile", "test.txt", "multipart/form-data",
        "Hello, World!".getBytes());
    String path = "/tmp";
    //String path = context.getServletContext().getRealPath("/resources/static/img/upload");
    String newFileName = photoUploadLogicService.uploadPhoto(file, path);
    
    logger.info("path : {}", path);
    logger.info("newFileName : {}", newFileName);
    
    Assert.assertNotNull(newFileName);
  }

}
