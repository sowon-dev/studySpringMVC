package com.itwillbs.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	//3-1. 서비스 처리 객체를 주입(DI)
	@Inject
	private MemberService service;
	
	private static final Logger l = LoggerFactory.getLogger(MemberController.class);
	
	/* 회원가입 처리하는 동작 */
	//insert라는 하나의 주소로 get과 post방식 즉 입력과 출력 둘 다 처리 가능

	// http://localhost:8088/test/insert
	// http://localhost:8088/test/member/insert
	// http://localhost:8088/member/insert
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	//value="/member/insert"에서 member를 빼도 됨
	public String insertGET() throws Exception {
		l.info("C: 회원가입 입력페이지");
		return "/member/insertMember";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	//value="/member/insertPro"에서 member를 빼도 됨
	public String insertPOST(MemberVO vo) throws Exception{
		
		//1. 한글처리 : request객체가 없다 => web.xml에서 filter태그로 인코딩해야한다.
		
		//2. 전달된 파라미터 받기
		//request.getParameter라는 내장객체가 없다. 따라서 메서드의 매개변수를 통해 가져올 수 있다.
		//l.info("C: "+ request.getParameter()); 에러발생
		l.info("C: "+ vo);
		
		//3. 서비스객체 생성(직접생성안하고 의존주입)
		//3-2. 서비스객체호출
		service.insertMember(vo);		
		l.info("C : 회원가입 완료!");
		
		//4. 로그인페이지로 이동(주소줄과 view페이지 동시에 insert->login 변경되어야함)
		return "redirect:/member/login";
	}
	
	/* 로그인 기능 */
	// http://localhost:8088/member/login

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() throws Exception{
		l.info("C: 로그인 입력페이지");
		return "/member/loginForm";
	}
	
	public String loginPOST(String userid, String userpw) throws Exception{
		l.info("C: 로그인 처리페이지");
		
		//1.한글처리 : web.xml에서 완료
		
		//2.전달받은 파라미터 저장
		
		//3.서비스객체호출 
		service.readMemberWithIDPW(userid, userpw);
		l.info("C : 로그인 완료!");
		
		//4.메인페이지로 이동(주소줄과 view페이지 동시에 main으로 변경되어야함)
		return "redirect:/main";
	}
	
}
