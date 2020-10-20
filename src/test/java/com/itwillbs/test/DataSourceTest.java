package com.itwillbs.test;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith()의미 : 해당 파일을 테스트할 때 스프링을 불러서 테스트함
//@ContextConfiguration의미 : 해당 경로에 있는 XML파일을 읽어서 사용함

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	//DataSource 객체 생성필요 -> getBean()으로 의존주입했던 걸 @Inject으로 간편하게 의존주입가능
	//@Inject : 해당 객체를 locations에서 찾아서 의존주입
	@Inject
	private DataSource ds;
	
	//DB연결 확인해보는 메서드
	@Test
	public void testConn() throws Exception{
		try(Connection con = ds.getConnection()) {
			System.out.println("@@@ DB연결확인: "+ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
