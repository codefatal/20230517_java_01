package kh.test.jdbckh.professor.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.professor.model.vo.ProfessorVo;

public class ProfessorDao {
	
	public ProfessorVo selectOneProfessor(String ProfessorNo) {
		System.out.println("DAO selectOneProfessor() arg:"+ ProfessorNo);

		ProfessorVo result = null;
		String query = "select * from tb_Professor where Professor_no = ?"; // pstmt에 ? 위치 홀더 기능 사용 가능
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","159236");
			pstmt = conn.prepareStatement(query);
			// 여기에 ? 위치홀더 값을 넣어준다.
			pstmt.setString(1, ProfessorNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new ProfessorVo();
				result.setProfessorNo(rset.getString("Professor_No"));
				result.setProfessorName(rset.getString("Professor_Name"));
				result.setProfessorSsn(rset.getString("Professor_Ssn"));
				result.setProfessorAddress(rset.getString("Professor_Address"));
				result.setDepartmentNo(rset.getString("Department_No"));
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
	
	public List<ProfessorVo> selectListProfessor() {
		List<ProfessorVo> result = null;
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
			
			String query = "select * from tb_Professor";
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			result = new ArrayList<ProfessorVo>();
			while(rs.next() == true) {
				ProfessorVo vo = new ProfessorVo();
				vo.setProfessorNo(rs.getString("Professor_No"));
				vo.setProfessorName(rs.getString("Professor_Name"));
				vo.setProfessorSsn(rs.getString("Professor_Ssn"));
				vo.setProfessorAddress(rs.getString("Professor_Address"));
				vo.setDepartmentNo(rs.getString("Department_No"));
				
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
		return result;
	}
}
