package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController5 {
	//로그정보 처리객 체생성
	private static final Logger logger  = LoggerFactory.getLogger(SampleController5.class);

	// 맵핑
	// http://localhost:8088/test/doJSON
	// 프레임워크를 사용하는 가장 큰 이유는 json데이터처리를 위해서.
	// REST API : 
	
	//JSON데이터로 만들기 1.라이브러리 복붙 2.doJSON()메서드생성
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
		logger.info("doJSON 실행");
		
		ProductVO vo = new ProductVO("radio", 1000);
		
		return vo;
	}
}
