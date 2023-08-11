package kh.test.mybatis.department.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.mybatis.common.MyBatisTemplate;
import kh.test.mybatis.department.model.dao.DepartmentDAO;
import kh.test.mybatis.department.model.vo.DepartmentVO;

public class DepartmentService {
	private DepartmentDAO dao;
	
	public DepartmentService() {
		dao = new DepartmentDAO();
	}
	
	public List<DepartmentVO> selectList() {
		List<DepartmentVO> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.selectList(session);
		return result;
	}
}
