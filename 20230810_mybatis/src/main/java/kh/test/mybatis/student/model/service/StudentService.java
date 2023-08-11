package kh.test.mybatis.student.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.mybatis.common.MyBatisTemplate;
import kh.test.mybatis.student.model.dao.StudentDAO;
import kh.test.mybatis.student.model.vo.StudentVO;

public class StudentService {
	private StudentDAO dao;
	
	public StudentService() {
		dao = new StudentDAO();
	}
	
	// connection 관리함. transaction 관리
	public List<StudentVO> selectList() {
		List<StudentVO> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.selectList(session);
		session.close();
		return result;
	}
	
	public StudentVO selectOne(String studentNo) {
		StudentVO result = null;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.selectOne(session, studentNo);
		session.close();
		return result;
	}
	
	public int insert(StudentVO vo) {
		int result = 0;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.insert(session, vo);
		return result;
	}
	
}
