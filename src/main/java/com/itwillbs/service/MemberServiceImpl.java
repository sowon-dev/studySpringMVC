package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	//DB와 연결 (의존주입)
	@Inject
	private MemberDAO mdao;
	
	//회원가입
	@Override
	public void insertMember(MemberVO vo) {
		//컨트롤러 -> 서비스 호출 -> DAO 호출 -> Mapper -> DB
		System.out.print("S : 회원가입동작");
		if(vo == null) {
			//처리
			return;
		}
		mdao.insertMember(vo);
	}

	//로그인
	@Override
	public MemberVO readMemberWithIDPW(String userid, String userpw) throws Exception {
		mdao.readMemberWithIDPW(userid, userpw);
		return null;
	}

	

	
}
