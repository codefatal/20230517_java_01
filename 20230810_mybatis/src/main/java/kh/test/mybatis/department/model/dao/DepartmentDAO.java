package kh.test.mybatis.department.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.mybatis.department.model.vo.DepartmentVO;

public class DepartmentDAO {
	public List<DepartmentVO> selectList(SqlSession session) {
		List<DepartmentVO> result = null;
		result = session.selectList("department1.selectList");
		return result;
	}
}
