package kh.test.mybatis.student.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.mybatis.student.model.vo.StudentVO;

public class StudentDAO {
	
	public List<StudentVO> selectList(SqlSession session) {
		List<StudentVO> result = null;
		result = session.selectList("student1.selectList"); // "namespace.id"
		return result;
	}
	
	public StudentVO selectOne(SqlSession session, String studentNo) {
		StudentVO result = null;
		result = session.selectOne("student1.selectOne", studentNo); // "namespace.id", parameter
		return result;
	}
	
	public int insert(SqlSession session,StudentVO vo) {
		int result = 0;
		result = session.insert("student1.insert", vo);
		return result;
	}
}
