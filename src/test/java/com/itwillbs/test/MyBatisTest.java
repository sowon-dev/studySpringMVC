package com.itwillbs.test;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyBatisTest {
	//SqlSessionFactory객체 생성
	@Inject
	private SqlSessionFactory sqlFactory;

	//객체 주입 확인해보는 메서드
	@Test
	public void testFactory() throws Exception{
		System.out.println("@@@ 객체주입확인: "+sqlFactory);
	}

	//리턴되는 정보인 객체로부터 생성된 세션객체 확인
	//SqlSessionFactory라는 인터페이스를 구현한것이아니라 그 하위클래스(SqlSessionFactoryBean)의 객체를 구현한 것이므로 return이 있음
	//xml코드로 SqlSessionFactoryBean객체를 생성한 뒤 주입해서 SqlSessionFactory 형변환(업캐스팅)한 거라서 인터페이스 구현한 것처럼 보임
	@Test
	public void openSessionTest() throws Exception {
		SqlSession session = sqlFactory.openSession();
		System.out.println("@@@ 오픈세션리턴확인: "+ session);
	}
	
	
	//DB연결 확인해보는 메서드

}
