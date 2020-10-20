package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	//로그정보를 처리하는 객체 생성
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	// 특정 주소에 따른 처리 메서드
	// - 메서드의 리턴타입이 void인 경우 [주소.jsp] 페이지 호출
	// - 메소드 리턴타입이 String인 경우 [리턴되는_문자열.jsp] 페이지 호출
	// -- jsp주소가 다른 경우 주로 사용
	
	
	// http://localhost:8088/test/home
	@RequestMapping("home")
	private void doA() {
		System.out.println("doA 메서드 호출");
		logger.info("Logger: doA()호출");
	}
	
	// http://localhost:8088/test/index
	@RequestMapping("index")
	private void doB() {
		System.out.println("doB 메서드 호출~");
		logger.info("Logger: doB()호출");
	}
	
}
