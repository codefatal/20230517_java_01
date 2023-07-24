package kh.test.jdbckh.lclass.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.lclass.model.vo.ClassVo;

public class ClassDao {
	
	public ClassVo selectOneClass(String classNo) {
		System.out.println("DAO selectOneClass() arg:"+ classNo);

		ClassVo result = null;
		String query = "select * from tb_class where class_no = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","159236");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, classNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new ClassVo();
				result.setClassNo(rset.getString("Class_No"));
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setPreattendingClassNo(rset.getString("Preattending_Class_No"));
				result.setClassName(rset.getString("Class_Name"));
				result.setClassType(rset.getString("Class_Type"));
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
	
	
	public List<ClassVo> selectListClass() {
		List<ClassVo> result = null;
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
			
			String query = "select * from tb_class";
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			result = new ArrayList<ClassVo>();
			while(rs.next() == true) {
				ClassVo vo = new ClassVo();
				vo.setClassNo(rs.getString("Class_No"));
				vo.setDepartmentNo(rs.getString("Department_No"));
				vo.setPreattendingClassNo(rs.getString("Preattending_Class_No"));
				vo.setClassName(rs.getString("Class_Name"));
				vo.setClassType(rs.getString("Class_Type"));
				
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
