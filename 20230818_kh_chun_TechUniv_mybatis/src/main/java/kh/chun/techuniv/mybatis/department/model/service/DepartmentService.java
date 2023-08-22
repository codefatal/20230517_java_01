package kh.chun.techuniv.mybatis.department.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.chun.techuniv.mybatis.common.MyBatisTemplate;
import kh.chun.techuniv.mybatis.department.model.dao.DepartmentDAO;
import kh.chun.techuniv.mybatis.department.model.dto.DepartmentDTO;

public class DepartmentService {

	private DepartmentDAO dao = new DepartmentDAO();
	
	public List<DepartmentDTO> selectList() {
		System.out.println("[Department Service selectList]");
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		List<DepartmentDTO> result = dao.selectList(session);
//		System.out.println("[Department Service selectList] return : " + result);
		return result;
	}
	
	public DepartmentDTO selectOne(String departmentNo) {
		System.out.println("[Department Service selectOne]");
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		DepartmentDTO result = dao.selectOne(session, departmentNo);
//		System.out.println("[Department Service selectOne] return : " + result);
		return result;
	}
}
