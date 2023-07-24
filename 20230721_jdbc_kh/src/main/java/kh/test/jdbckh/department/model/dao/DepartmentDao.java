package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.department.model.vo.DepartmentVo;

public class DepartmentDao {
	
	public DepartmentVo selectOneDepartment(String DepartmentNo) {
		System.out.println("DAO selectOneDepartment() arg:"+ DepartmentNo);

		DepartmentVo result = null;
		String query = "select * from tb_department join tb_student using (department_no) where department_no = "+"'"+DepartmentNo+"'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","159236");
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new DepartmentVo();
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setDepartmentName(rset.getString("Department_Name"));
				result.setCategory(rset.getString("Category"));
				result.setOpenYn(rset.getString("Open_Yn"));
				result.setCapacity(rset.getString("Capacity"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}
	
	
	public List<DepartmentVo> selectListDepartment() {
		List<DepartmentVo> result = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "159236");
			if(conn != null) {
				System.out.println("DB연결 성공!!!!!!!!!");
			} else {
				System.out.println("------ DB 연결 실패------");
			}
			
			String query = "select * from tb_department";
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			result = new ArrayList<DepartmentVo>();
			while(rs.next() == true) {
				DepartmentVo vo = new DepartmentVo();
				vo.setDepartmentNo(rs.getString("Department_No"));
				vo.setDepartmentName(rs.getString("Department_Name"));
				vo.setCategory(rs.getString("Category"));
				vo.setOpenYn(rs.getString("Open_Yn"));
				vo.setCapacity(rs.getString("Capacity"));
				
				result.add(vo);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}
}
