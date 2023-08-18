package kh.chun.techuniv.mybatis.common;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	
	public static SqlSession getSqlSession(boolean auto) {
		SqlSession session = null;
		SqlSessionFactory factory;
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			session = factory.openSession(auto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
