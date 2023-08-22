package kh.chun.techuniv.mybatis.classes.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.chun.techuniv.mybatis.classes.model.dao.ClassesDAO;
import kh.chun.techuniv.mybatis.classes.model.dto.ClassesDTO;
import kh.chun.techuniv.mybatis.common.MyBatisTemplate;

public class ClassesService {

	private ClassesDAO dao = new ClassesDAO();
	
	public List<ClassesDTO> selectList() {
		System.out.println("[Class Service selectList]");
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<ClassesDTO> result = dao.selectList(session);
//		System.out.println("[Class Service selectList] return : " + result);
		return result;
	}
	
	public ClassesDTO selectOne(String classNo) {
		System.out.println("[Class Service selectOne]");
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		ClassesDTO result = dao.selectOne(session, classNo);
//		System.out.println("[Class Service selectOne] return : " + result);
		return result;
	}
}
