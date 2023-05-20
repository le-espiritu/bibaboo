package com.project.bibaboo.domain.alterations.service;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PhotoUploadLogicServiceTest {

  static Logger logger = LoggerFactory.getLogger(PhotoUploadLogicServiceTest.class);

  @Autowired
  PhotoUploadLogicService photoUploadLogicService;

  @Test
  public void fileUploadTest() throws IllegalStateException, IOException {
    MockMultipartFile file = new MockMultipartFile("testFile", "test.txt", "multipart/form-data",
        "Hello, World!".getBytes());
    String path = "/tmp";
    AlterPhotoDto dto = photoUploadLogicService.uploadPhoto(file, path);
    logger.info("AlterPhotoDto : {}", dto);
    Assert.assertNotNull(dto);
  }

}
