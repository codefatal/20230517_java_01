package kh.chun.techuniv.mybatis.classes.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.chun.techuniv.mybatis.classes.model.dto.ClassesDTO;

public class ClassesDAO {
	
	public List<ClassesDTO> selectList(SqlSession session) {
		System.out.println("[Class DAO selectList]");
		List<ClassesDTO> result = session.selectList("classMapper.selectList");
//		System.out.println("[Class DAO selectList] return : " + result);
		return result;
	}
	
	public ClassesDTO selectOne(SqlSession session, String classNo) {
		System.out.println("[Class DAO selectOne]");
		ClassesDTO result = session.selectOne("classMapper.selectOne", classNo);
//		System.out.println("[Class DAO selectOne] return : " + result);
		return result;
	}
}
