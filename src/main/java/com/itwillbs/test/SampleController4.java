package com.itwillbs.test;

import java.lang.ProcessBuilder.Redirect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController4 {

	//로그정보 처리객체생성
	private static final Logger logger  = LoggerFactory.getLogger(SampleController4.class);

	// 맵핑
	// http://localhost:8088/test/doE
	@RequestMapping("/doE")
	public String doE(Model model, RedirectAttributes rttr) {
		logger.info("doE()호출");
		//return "doF";
		
		// `redirect: 또는 forward:` 페이지이동 메서드에서 String 리턴시 주소앞에 사용
		// jsp페이지를 찾는 것이 아니라 메서드를 호출하는 것
		// return "redirect:doF"; //주소변경O, 페이지변경O
		// return "forward:doF"; //주소변경X, 페이지변경O
		
		// model.addAttribute("msg", "4567test");
		// model.addAttribute("1234test");//매개변수명을 지정하지 않으면 데이터타입으로 전달됨 string
		// model.addAttribute(132);//매개변수명을 지정하지 않으면 데이터타입으로 전달됨 integer
		// model.addAttribute("msg", new ProductVO("moniter", 2000)); //redirect로 파라미터 전달안됨
		
		rttr.addFlashAttribute("msg", "flash!"); //주소줄에 안보임, El표현식가능, jsp표현식불가능, 새로고침하면 사라짐(즉 1회성 데이터)
		// rttr.addAttribute("msg", "add!"); //주소줄에 보임, El표현식가능, jsp표현식가능, 새로고침해도 그대로
		// 예를 들어 카운트를 올릴때 새로고침시 계속 조회수가 올라가는 것이 아니라 한번 올라가게끔 만들때 addFlashAttribute 사용
		
		return "redirect:/doF"; 
	}
	
	// http://localhost:8088/test/doF
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String msg) {
		logger.info("doF()호출");
	}	
}
