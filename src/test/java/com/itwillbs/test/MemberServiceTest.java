package com.itwillbs.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceTest {
	//서비스객체를 직접 생성하지 않고 의존 주입
	@Inject
	private MemberService service;
	
	@Test
	public void insertServiceTest() throws Exception {
		MemberVO vo = new MemberVO("uesrGang", "4321", "강조지", "jorge@com", null, null);
		service.insertMember(vo);
	}
}
