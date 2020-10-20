package com.itwillbs.test;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith + @ContextConfiguration => 스프링으로 테스트하겠다는 의미
//@RunWith + @ContextConfiguration + @WebAppConfiguration => 스프링MVC로 테스트하겠다는 의미

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {
	//로그정보 처리객 체생성
	private static final Logger logger  = LoggerFactory.getLogger(SampleControllerTest.class);
	
	//객체 의존주입
	@Inject
	private WebApplicationContext wac;
	
	// MockMvc객체는 브라우저에서 페이지 요청과 응답을 처리하는 객체, 가상의 요청과 응답을 처리 for 테스트
	// @Before : test실행 전 준비사항
	private MockMvc mockMvc; 	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("mockMvc객체 생성완료");
	}
	
	@Test
	public void testDoA() throws Exception {
		logger.info(" Junit을 사용해서 컨트롤러 동작 실행 ");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		
	}
}
