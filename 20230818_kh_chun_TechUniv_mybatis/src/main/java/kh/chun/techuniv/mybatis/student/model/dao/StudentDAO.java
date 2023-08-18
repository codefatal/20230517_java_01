package kh.chun.techuniv.mybatis.student.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.chun.techuniv.mybatis.student.model.dto.StudentDTO;

public class StudentDAO {
	
	public List<StudentDTO> selectList(SqlSession session) {
		System.out.println("[Student DAO selectList]");
		List<StudentDTO> result = session.selectList("studentMapper.selectList");
//		System.out.println("[Student DAO selectList] return : " + result);
		return result;
	}
	
	public StudentDTO selectOne(SqlSession session, String studentNo) {		
		System.out.println("[Student DAO selectOne]");
		StudentDTO result = session.selectOne("studentMapper.selectOne", studentNo);
//		System.out.println("[Student DAO selectOne] return : " + result);
		return result;
	}
	
	public int insert(SqlSession session, StudentDTO dto) {		
		System.out.println("[Student DAO insert] insert : " + dto);
		int result = session.insert("studentMapper.insert", dto);
//		System.out.println("[Student DAO insert] return : " + result);
		return result;
	}
}
