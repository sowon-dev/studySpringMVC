package com.itwillbs.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	
	//DB처리객체 생성 ->MemberDAO 인터페이스라서 객체 생성할 수없다 -> 의존 주입 @Inject 추가
	@Inject
	private MemberDAO mdao;
	
	//@Test
	public void testDAO(){
		System.out.println("테스트 : DAO객체생성 "+ mdao);
	}
	
	@Test
	public void testGetTime() throws Exception {
		//DAO getTime() 메서드 사용가능한지 테스트
		System.out.println(mdao.getTime());
	}
	
	//회원가입테스트 -> DB 테이블에서 확인 -> 테스트완료하면 어노테이션 주석할 것. 다른 기능 테스트할때 중복 insert되어 에러발생함
	@Test
	public void testInsertMember() {
		MemberVO vo = new MemberVO("userHhu","1234password", "휘슬", "huh@email.com", null, null);
		mdao.insertMember(vo);
	}
	
	//회원 정보 조회-사용자 ID
	//@Test
	public void testReadMember() throws Exception {
		//mdao.readMember("userSeo");
		System.out.println("@@@ " + mdao.readMember("userSeo"));
	}
	
	//회원 정보 조회-사용자 ID와 PW
	//@Test
	public void testReadMemberWithIDPW() throws Exception {
		System.out.println("@@@ " + mdao.readMemberWithIDPW("admin", "1234password1"));
	}
	
	//회원정보수정
}
