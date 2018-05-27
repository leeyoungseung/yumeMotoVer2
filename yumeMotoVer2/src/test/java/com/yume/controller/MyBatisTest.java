package com.yume.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MyBatisTest {
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory(){
		
		System.out.println(sqlFactory);
	}
	@Test
	public void testSession() throws Exception{
		try(SqlSession session = sqlFactory.openSession()){
			
			System.out.println(session);
			System.out.println("------------------------------------------------------------");
			System.out.println("success connection");
			System.out.println("------------------------------------------------------------");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("------------------------------------------------------------");
			System.out.println("fail");
			System.out.println("------------------------------------------------------------");
		}
	}
}
