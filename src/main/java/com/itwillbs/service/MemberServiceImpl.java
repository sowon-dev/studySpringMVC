package com.itwillbs.service;

import java.util.List;

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
		System.out.println("S : 회원가입() 실행");
		if(vo == null) {
			//처리
			return;
		}
		mdao.insertMember(vo);
	}

	//로그인기능
	@Override
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("S : 컨트롤러에서 호출받으면 필요한 정보를 받아서 DAO로 전달");
		MemberVO returnVO = null;
		try {
			returnVO = mdao.readMemberWithIDPW(vo.getUserid(), vo.getUserpw());
		} catch (Exception e) {
			e.printStackTrace();
			returnVO = null; //실행하다 문제가 생겼을때 해당 데이터를 보내지않겠다는 의미 = 예외처리
		}
		return returnVO; //null이 반환되면 앞의 코드가 문제가 있다는 것을 바로 알수있다.
	}

	//회원정보보기
	@Override
	public MemberVO readMember(String id) {
		System.out.println("S : readMember()실행");
		MemberVO vo = null;
		
		try {
			vo = mdao.readMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	//회원정보수정
	@Override
	public void updateMember(MemberVO vo) {
		try {
			mdao.updateMember(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//회원정보삭제
	@Override
	public void deleteMember(MemberVO vo) {
		try {
			mdao.deleteMember(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//관리자용 회원목록
	@Override
	public List<MemberVO> getMemberList() {
		//List<MemberVO> memberList = mdao.getMemberList();
		//return memberList;
		return mdao.getMemberList();
	}



	
	

}
