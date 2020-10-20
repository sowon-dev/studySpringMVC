package com.itwillbs.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


//MySql서버에 접속이 가능한 지 확인하는 클래스
public class MySqlConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/springdb";
	private static final String DBID = "root";
	private static final String DBPW = "1234";
	
	// @Before : 테스트 이전에 미리 처리(준비) 되어야하는 동작/메서드
	// 위쪽에 사용됨.
	
	// @After : 테스트 실행 후 자동으로 실행된는 메서드에 사용
	
	@Before 
	public void beforeTest() throws Exception {
		System.out.println("테스트 이전 실행!!!");
	}
	
	//mysql 접속 테스트를 위한 메서드 구현
	@Test
	public void testCon() throws Exception {
		/*
		 * Class.forName(DRIVER); Connection con = DriverManager.getConnection(URL,
		 * DBID, DBPW); System.out.println("드라이브로드와 디비연결성공: "+con);
		 */
		
		//try with구문(jdk 1.7이상부터 사용 가능) 사용 = finally 구문을 제거한 try-catch구문
		// AutoCloseable인터페이스를 구현한 객체
		// => DB관련 동작
		//		try(자동자원해제 객체를 구현하는 객체) {
		//			
		//		}catch (Exception e) {
		//		
		//		}
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, DBID, DBPW)){
			System.out.println("DB연결 TRY WITH: "+con);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void afterTest() throws Exception{
		System.out.println("테스트 후 실행 !");
	}
	
}
