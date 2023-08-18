package kh.chun.techuniv.mybatis.student.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.chun.techuniv.mybatis.common.MyBatisTemplate;
import kh.chun.techuniv.mybatis.student.model.dao.StudentDAO;
import kh.chun.techuniv.mybatis.student.model.dto.StudentDTO;

public class StudentService {
	private StudentDAO dao = new StudentDAO();
	
	public List<StudentDTO> selectList() {
		System.out.println("[Student Service selectList]");
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<StudentDTO> result = dao.selectList(session);
		session.close();
//		System.out.println("[Student Service selectList] return : " + result);
		return result;
	}
	
	public StudentDTO selectOne(String studentNo) {
		System.out.println("[Student Service selectOne]");
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		StudentDTO result = dao.selectOne(session, studentNo);
		session.close();
//		System.out.println("[Student Service selectOne] return : " + result);
		return result;
	}
	
	public int insert(StudentDTO dto) {
		System.out.println("[Student Service insert]");
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		int result = dao.insert(session, dto);
		session.close();
//		System.out.println("[Student Service insert] return : " + result);
		return result;
	}
	
}
