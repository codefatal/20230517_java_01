package kh.test.mybatis.common;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	public static SqlSession getSqlSession() {
		String resource = "mybatis/mybatis-config.xml";
		SqlSession session = null; // Connection 역활을 하는 mybatis의 객체
		try {
			// InputStream으로 Mybatis의 설정 정보를 읽어 온다
			InputStream is = Resources.getResourceAsStream(resource);
			// 읽어 온 Mybatis의 설정 정보를 바탕으로 SqlSessionFactoryBuilder를 실행한다.
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	// 안씀
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis/mybatis-config.xml";
		SqlSessionFactory factory = null;
		try {
			// InputStream으로 Mybatis의 설정 정보를 읽어 온다
			InputStream is = Resources.getResourceAsStream(resource);
			// 읽어 온 Mybatis의 설정 정보를 바탕으로 SqlSessionFactoryBuilder를 실행한다.
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(is);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return factory;
	}
}
