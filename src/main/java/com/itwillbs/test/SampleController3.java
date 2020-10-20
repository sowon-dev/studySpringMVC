package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController3 {
	// 페이지 이동시 객체 정보를 가지고 이동
	// 로그정보 처리 객체
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	// 페이지 이동시 객체 정보를 가지고 이동
	
	// http://localhost:8088/test/doD
	@RequestMapping("doD")
	public String doD(Model model) {
		logger.info("doD() 호출!!!");
		
		//상품객체생성
		ProductVO vo = new ProductVO("phone", 100);
		
		// 기존에는 request.setAttribute로 객체를 넘겼는데 스프링에서는 model객체(스프링mvc에서 제공해주는 객체)를 사용
		// model 객체는 객체를 저장해서 뷰페이지로 전달
		// model 객체 생성 방법 두가지
		// 첫번째 방법: 키와값 쌍으로 전달
		model.addAttribute("vo", vo);
		// 두번째 방법: 키없이 객체만 전달한 경우 받을때는 클래스 첫글자를 소문자 변경해서 el표현식으로 호출해야함 
		model.addAttribute(vo);
		
		return "doDPage";
	}
}
