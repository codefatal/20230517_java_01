package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.student.model.vo.StudentVo;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;

public class StudentDao {
// PPT 내용구현
	
	// DB에서 tb_student 테이블의 전달받은 학번을 통해 학생1명의 상세정보를 읽어옴
	public StudentVo selectOneStudent(String studentNo) {
		System.out.println("DAO selectOneStudent() arg:"+ studentNo);

		StudentVo result = null;
		String query = "select * from tb_student join tb_department using (department_no) where student_no = "+"'"+studentNo+"'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","159236");
//			if(conn==null) {
//				System.out.println("연결실패");
//			}else {
//				System.out.println("연결 성공");
//			}
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new StudentVo();
				// while 동작시킬필요없음. query 결과가 단일행일 것이므로
				result.setAbsenceYn(rset.getString("Absence_Yn"));
				result.setCoachProfessorNo(rset.getString("Coach_Professor_No"));
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setEntranceDate(rset.getDate("Entrance_Date"));
				result.setStudentAddress(rset.getString("Student_Address"));
				result.setStudentName(rset.getString("student_Name"));
				result.setStudentNo(rset.getString("student_No"));
				result.setStudentSsn(rset.getString("Student_Ssn"));
				result.setDepartmentName(rset.getString("Department_name"));
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
	
	// DB에서 tb_student 테이블의 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent() {
		List<StudentVo> result = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			// 1. driver 있다면 로딩함. // 없다면 ClassNotFoundException 오류 발생
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성 // dbms와 연결
			conn =  DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "159236");
			if(conn != null) {
				System.out.println("DB연결 성공!!!!!!!!!");
			} else {
				System.out.println("------ DB 연결 실패------");
			}
			// 3. Statement/PrepareStatement 객체 생성 -conn 객체로부터 - query 문을 실어보냄
//			stmt = conn.createStatement();
			String query= "select * from tb_student";
			pstmt = conn.prepareStatement(query);
			// 4. query 문을 실행해달라고 함.- 그 결과값을 return 받음.
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			ResultSet rs = pstmt.executeQuery();
			
			// 5. ResultSet 에서 row(record)=한줄 읽어오기 위해 cursor(포인트)를 이동함.
			result = new ArrayList<StudentVo>();
			while(rs.next() == true) {
				//  한줄row/record 를 읽을 준비 완료
				// 확인용도. System.out.println( rs.getString("STUDENT_NAME") );
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo( rs.getString("department_no"));
				vo.setStudentName( rs.getString("Student_Name"));
				vo.setAbsenceYn( rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo( rs.getString("Coach_Professor_No"));
				vo.setStudentAddress( rs.getString("Student_Address"));
				vo.setEntranceDate( rs.getDate("Entrance_Date") );
				
				result.add(vo);
			}
		
		} catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dbms에 연결 실패
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//  확인용 System.out.println(result);
		return result;
	}

	public List<StudentVo> selectListStudent(String searchWord) {
		List<StudentVo> result = null;

		String query = "select * from tb_student where student_name like ? or student_address like ?";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. driver 있다면 로딩함. // 없다면 ClassNotFoundException 오류 발생
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성 // dbms와 연결
			conn =  DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "159236");
//			if(conn != null) {
//				System.out.println("DB연결 성공!!!!!!!!!");
//			} else {
//				System.out.println("------ DB 연결 실패------");
//			}
			// 3. Statement/PrepareStatement 객체 생성 -conn 객체로부터 - query 문을 실어보냄
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
			searchWord = "%"+searchWord+"%"; //like 연산자인 경우 % 또는 _ 를 합쳐서 만듬
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
			// 4. query 문을 실행해달라고 함.- 그 결과값을 return 받음.
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			rs = pstmt.executeQuery();
			
			// 5. ResultSet 에서 row(record)=한줄 읽어오기 위해 cursor(포인트)를 이동함.
			result = new ArrayList<StudentVo>();
			while(rs.next() == true) {
				//  한줄row/record 를 읽을 준비 완료
				// 확인용도. System.out.println( rs.getString("STUDENT_NAME") );
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo( rs.getString("department_no"));
				vo.setStudentName( rs.getString("Student_Name"));
				vo.setAbsenceYn( rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo( rs.getString("Coach_Professor_No"));
				vo.setStudentAddress( rs.getString("Student_Address"));
				vo.setEntranceDate( rs.getDate("Entrance_Date") );
				
				result.add(vo);
			}
		
		} catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dbms에 연결 실패
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//  확인용 System.out.println(result);
		return result;
	}
	
	public List<StudentVo> selectListStudent(int currentPage, int pageSize ) {  // 페이징처리
		List<StudentVo> result = new ArrayList<StudentVo>();
		
		String queryTotalCnt= "select count(*) cnt from tb_student";  
		String query= " select * from "
				+ " (\r\n"
				+ " select tb1.*, rownum rn from"
				+ "    (select * from tb_student order by student_no asc) tb1"
				+ " ) tb2"
				+ " where rn between ? and ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalCnt = 0;  // 총글개수
		int startRownum = 0;
		int endRownum = 0;
		try {
			conn = getConnection();
			// 총글개수 알아오기 위한 query 실행
			pstmt = conn.prepareStatement(queryTotalCnt);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//오류 함수는 컬럼명이 될수 없음 -  totalCnt = rs.getInt("count(*)");
				totalCnt = rs.getInt("cnt");
				//totalCnt = rs.getInt(1);
			}
			System.out.println("총글개수:"+totalCnt);
			startRownum = (currentPage-1)*pageSize +1;
			endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
			System.out.println("startRownum:"+startRownum);
			System.out.println("endRownum:"+endRownum);

			// conn 생성으로 2개의 query(select)문을 실행할때
			close(rs);
			close(pstmt);
			
			// 페이지당 글 읽어오기 위한 query 실행
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			rs = pstmt.executeQuery();
			
			// 5. ResultSet 에서 row(record)=한줄 읽어오기 위해 cursor(포인트)를 이동함.
			while(rs.next() == true) {
				//  한줄row/record 를 읽을 준비 완료
				// 확인용도. System.out.println( rs.getString("STUDENT_NAME") );
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo( rs.getString("department_no"));
				vo.setStudentName( rs.getString("Student_Name"));
				vo.setAbsenceYn( rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo( rs.getString("Coach_Professor_No"));
				vo.setStudentAddress( rs.getString("Student_Address"));
				vo.setEntranceDate( rs.getDate("Entrance_Date") );
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		//  확인용 System.out.println(result);
		return result;
	}
	
	public int insertStudent(StudentVo vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. driver 있다면 로딩함. // 없다면 ClassNotFoundException 오류 발생
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성 // dbms와 연결
			conn =  DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "159236");
			
			System.out.println(vo.getStudentNo());
			// 3. Statement/PrepareStatement 객체 생성 -conn 객체로부터 - query 문을 실어보냄
			String query = "insert into tb_student (STUDENT_NO, DEPARTMENT_NO, STUDENT_NAME, STUDENT_SSN, STUDENT_ADDRESS, ENTRANCE_DATE, ABSENCE_YN, COACH_PROFESSOR_NO) values(?, ?, ?, ?, ?, to_date(?, 'dd-mm-yyyy'), ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getStudentNo());
			pstmt.setString(2, vo.getDepartmentNo());
			pstmt.setString(3, vo.getStudentName());
			pstmt.setString(4, vo.getStudentSsn());
			pstmt.setString(5, vo.getStudentAddress());
			pstmt.setString(6, vo.getEntranceDateString());
			pstmt.setString(7, vo.getAbsenceYn());
			pstmt.setString(8, vo.getCoachProfessorNo());
			// 4. query 문을 실행해달라고 함.- 그 결과값을 return 받음.
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dbms에 연결 실패
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}