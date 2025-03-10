package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	//DB연결 (xml에서 만들어진 객체를 가져다 사용하고자함 = 의존 주입)
	@Inject
	private SqlSession sqlSession; //mapper위치까지 접근 가능 but mapper가 여러개일수있음 => mapper구분필요
	
	//mapper구분하는 값 namespace
	private static final String namespace = "com.itwillbs.mappers.memberMapper";
	
	@Override
	public String getTime() {
		String result = sqlSession.selectOne(namespace+".getTime"); //괄호안에 쿼리구문입력하기
		return result;
	}

	//회원가입구현 -> memberMapper.xml 작성 후 아래 메서드 작성 -> MemberDAOtest.java 이동
	@Override
	public void insertMember(MemberVO vo) {
		System.out.println("#####");
		sqlSession.insert(namespace+".insertMember", vo); //괄호안은 (쿼리구문, 매개변수)순으로 입력하기
	}

	//회원 정보 조회-사용자 ID 해당하는 정보 가져오기
	@Override
	public MemberVO readMember(String userid) throws Exception {
		//테스트(컨트롤러) 호출 -> 정보를 저장 -> DB로이동
		MemberVO vo = sqlSession.selectOne(namespace+".readMember", userid); //괄호안의 물음표를 콤마뒤에 쓰는거임
		return vo;
	}

	//인터페이스 선언 -> 서브클래스 구현
	//회원 정보 조회 - ID,PW정보에 해당하는 사용자 정보
	@Override
	public MemberVO readMemberWithIDPW(String userid, String userpw) throws Exception {
		//테스트(컨트롤러) 호출 -> 정보를 저장 -> DB로이동
		
		//String인자를 2개를 가져갈 수 없기때문에 파라미터 두개를 객체인 Map에 넣어서 가지고 넘긴다
		//return sqlSession.selectOne(namespace+".readMemberWithIDPW", userid, userpw);		
		
		// DB로 정보를 전달하기 위해서는 sqlSeesion 객체 활용
		// * 1개 이상의 정보를 전달할때는 객체 단위로 전달
		// * 객체(VO) 안에 저장이 안되는 정보의 경우 Map을 사용
		// Map은 key-value형태 : 이때 key값은 sql구문의 #{ㅇㅇㅇ} 이름과 같아야함
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace+".readMemberWithIDPW", paramMap);		
	}

	//회원정보 수정(정보를 가지고 mapper로 이동)
	@Override
	public void updateMember(MemberVO vo) throws Exception {
		sqlSession.update(namespace+".updateMember", vo);		
	}

	//회원탈퇴
	@Override
	public void deleteMember(MemberVO vo) throws Exception {
		int check = sqlSession.delete(namespace+".deleteMember",vo);
		System.out.println("DAO : deleteMember() "+check);	
	}

	//관리자용 회원목록
	@Override
	public List<MemberVO> getMemberList() {
		//while문 대신 selectList하면 됨! 세상간단!
		List<MemberVO> memberList = sqlSession.selectList(namespace+".memberList");
		System.out.println("DAO: getMemberList결과 - "+memberList);
		return memberList;
		//아래처럼 나타낼 수 있으나 변수에 담은 이유는 캐스팅이 필요없음을 보여주고 콘솔에 출력하고자함임
		//return sqlSession.selectList(namespace+".memberList");
	}
	
	
	
}
