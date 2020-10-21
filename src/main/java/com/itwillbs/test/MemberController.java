package com.itwillbs.test;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		l.info("C: 회원가입 입력페이지 GET");
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
		l.info("C: 회원가입 처리페이지 POST");
		
		//4. 로그인페이지로 이동(주소줄과 view페이지 동시에 insert->login 변경되어야함)
		return "redirect:/member/login";
	}
	
	/* 로그인 기능 */
	// http://localhost:8088/member/login
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() throws Exception{
		l.info("C: 로그인 입력페이지 GET");
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	//public String loginPOST(@ModelAttribute("userid") String id, @ModelAttribute("userpw") String pw) throws Exception{
	public String loginPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		l.info("C: 로그인 처리페이지 POST");
		
		//1.한글처리 => web.xml에서 완료
		
		//2.전달받은 파라미터 저장 => loginPOST()메서드의 파라미터값으로 저장함.
		l.info("C: "+ vo.getUserid() + vo.getUserpw());
		
		//3.서비스객체생성 => 22번째 코드로 의존주입완료
		//4.서비스 로그인 체크 동작(HttpSession)
		MemberVO returnVO = service.loginMember(vo);
		l.info("C: 리턴VO결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미) "+returnVO);
		
		//5.메인페이지로 이동(주소줄과 view페이지 동시에 main으로 변경되어야함)
		// 해당 정보 있는 경우 : => main페이지로 이동
		//if(returnVO.getUserid() != null) {
		//에러가 발생하는 이유:
		if(returnVO != null) {
			//5.세션값생성
			session.setAttribute("id", returnVO.getUserid());
			
			//Map<String, Object> map = new HashMap<String, Object>();
			//map.put("username", returnVO.getUsername());
			//map.put("useremail", returnVO.getUseremail());
			//rttr.addAttribute("mvo", map);
			
			rttr.addFlashAttribute("mvo", returnVO);
			//l.info("C: 모델에 뭐 들어있니?"+model);
			return "redirect:/member/main"; 
		} else {
			// 해당 정보 없는 경우 : => login페이지로 이동
			return "redirect:/member/login";
		}
	}//end of loginPOST()
	
	/* 메인페이지 */
	// http://localhost:8088/member/main
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET() throws Exception{
		//model.addAttribute("mvo", model);
		l.info("C: 메인 출력페이지 GET");
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logoutGET(HttpSession session) throws Exception{
		l.info("C: 로그아웃 GET");
		session.invalidate();
		// return "redirect:/member/main"; 얼럿창출력안하고싶을때 사용
	}
}
