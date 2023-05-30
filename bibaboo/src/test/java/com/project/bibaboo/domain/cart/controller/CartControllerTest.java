package com.project.bibaboo.domain.cart.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bibaboo.domain.cart.dto.CartDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CartControllerTest {

  @Autowired
  WebApplicationContext context;

  // MockMvc는 WAS의 역할을 대신해준다.
  // WAS는 클라이언트로부터 요청을 받고 요청에 해당하는 웹 어플리케이션을 실행 시켜 응답을 내보낸다.
  // 그렇기 때문에 (클라이언트로부터 요청을 받는)컨트롤러 테스트 시 WAS가 필요한데, MockMVC가 WAS의 역할을 대신해준다.
  MockMvc mocMvc;

  @Before
  public void prepare() {
    mocMvc = MockMvcBuilders.webAppContextSetup(context).build();
    /*
     * mockMvc = MockMvcBuilders.standaloneSetup(new CartController()) .setControllerAdvice(new
     * ExceptionAdvice()) .build();
     * 
     * 주석처리한 코드는 standalone 방식으로 MocMvc 생성하면서, 컨트롤러어드바이스 필요시 작성되는 코드이다.
     */
  }

  @Test
  public void addCartTest() throws Exception {

    CartDTO cartDTO = new CartDTO();
    cartDTO.setUserId(1);
    cartDTO.setCategoryId(1);
    cartDTO.setCount(2);

    ObjectMapper objectMapper = new ObjectMapper();

    String content = objectMapper.writeValueAsString(cartDTO);

    RequestBuilder reqBuilder = post("/cart").contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8").content(content);
    
    mocMvc.perform(reqBuilder)
          .andExpect(status().is4xxClientError())
          .andDo(print());
  }
}
