package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	// 로그정보를 처리하는 객체 생성
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	// 특정 주소에 따른 처리 메서드
	// - 메서드의 리턴타입이 void인 경우 [주소.jsp] 페이지 호출
	// - 메소드 리턴타입이 String인 경우 [리턴되는_문자열.jsp] 페이지 호출
	// -- jsp주소가 다른 경우 주로 사용
	
	// http://localhost:8088/test/doC
	@RequestMapping("doC")
	private String doC() {
		logger.info("doC 메서드 호출");
		
		//return "abc";
		return " ";
	}
	
	//주소줄에 파라미터 정보를 가지고 페이지 이동
	// http://localhost:8088/test/testParam?msg="hi"
	@RequestMapping(value = "testParam")
	private String doC1(@ModelAttribute("msg") String msg, @ModelAttribute("name") String username) {
		logger.info("doC1 메서드 호출, 파라미터 메세지: "+msg+", 유저이름: "+username);
		return "doC";
		// return "doC?msg=냠냠";
		// Q. 에러의 이유가 'doC?msg=냠냠.jsp'로 매핑이 되서 그런거 아닌가요? 맞음
		// Q. 모델객체를 쓰면 return "doC?msg=냠냠"; 사용이 원하는대로 가능해지는 건가요? ㄴㄴ원래 안되는거임
	}

	// http://localhost:8088/test/doTotalC?name=강회장&tel=010-1234-5678
	@RequestMapping(value = "doTotalC")
	private String doTotalC(@ModelAttribute("name") String name, @ModelAttribute("tel") String tel) {
		logger.info("doC1 메서드 호출, 파라미터 메세지: "+name+", 유저이름: "+tel);
		return "doC";
		
	}
	

}
