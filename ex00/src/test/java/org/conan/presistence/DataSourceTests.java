package org.conan.presistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// java 설정을 사용하는 경우
// @ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests {
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource; // DataSource 인터페이스변수
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
//	@Test
//	public void testConnection() {
//		try(Connection conn = dataSource.getConnection()){
//			log.info(conn);
//			
//		} catch(Exception e) {
//			fail(e.getMessage());
//		}
//	}
	
	@Test
	public void testMyBatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
			Connection conn = session.getConnection();){
			log.info(session);
			log.info(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
