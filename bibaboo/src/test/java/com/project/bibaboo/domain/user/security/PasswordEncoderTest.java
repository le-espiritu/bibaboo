package com.project.bibaboo.domain.user.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class PasswordEncoderTest {
  
  static Logger logger = LoggerFactory.getLogger(PasswordEncoderTest.class);
  
  @Autowired
  PasswordEncoder passwordEncoder;
  
  @Test
  public void passwordEncodeTest() {
    String encodedPassword = passwordEncoder.encode("admin");
    logger.info("%%%%%%%%%%%%%%5인코딩 된 패스워드 : {} ",encodedPassword);
  }
}
