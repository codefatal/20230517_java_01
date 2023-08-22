package kh.chun.techuniv.mybatis.department.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.chun.techuniv.mybatis.department.model.dto.DepartmentDTO;

public class DepartmentDAO {
	
	public List<DepartmentDTO> selectList(SqlSession session) {
		System.out.println("[Department DAO selectList]");
		List<DepartmentDTO> result = session.selectList("departmentMapper.selectList");
//		System.out.println("[Department DAO selectList] return : " + result);
		return result;
	}
	
	public DepartmentDTO selectOne(SqlSession session, String departmentNo) {
		System.out.println("[Department DAO selectOne]");
		DepartmentDTO result = session.selectOne("departmentMapper.selectOne", departmentNo);
//		System.out.println("[Department DAO selectOne] return : " + result);
		return result;
	}
}
