package kh.chun.techuniv.mybatis.student.model.dto;

import java.time.LocalDateTime;

public class StudentDTO {
//	STUDENT_NO	VARCHAR2(10 BYTE)
//	DEPARTMENT_NO	VARCHAR2(10 BYTE)
//	STUDENT_NAME	VARCHAR2(40 BYTE)
//	STUDENT_SSN	VARCHAR2(14 BYTE)
//	STUDENT_ADDRESS	VARCHAR2(200 BYTE)
//	ENTRANCE_DATE	DATE
//	ABSENCE_YN	CHAR(1 BYTE)
//	COACH_PROFESSOR_NO	VARCHAR2(20 BYTE)
	private String studentNo;
	private String departmentNo;
	private String studentName;
	private String studentSsn;
	private String studentAddress;
	private String entranceDate;
	private String absenceYn;
	private String coachProfessorNo;
	
	public StudentDTO() {}
	
	public StudentDTO(String studentNo, String departmentNo, String studentName, String studentSsn,
			String studentAddress, String entranceDate, String absenceYn, String coachProfessorNo) {
		this.studentNo = studentNo;
		this.departmentNo = departmentNo;
		this.studentName = studentName;
		this.studentSsn = studentSsn;
		this.studentAddress = studentAddress;
		this.entranceDate = entranceDate;
		this.absenceYn = absenceYn;
		this.coachProfessorNo = coachProfessorNo;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [studentNo=" + studentNo + ", departmentNo=" + departmentNo + ", studentName=" + studentName
				+ ", studentSsn=" + studentSsn + ", studentAddress=" + studentAddress + ", entranceDate=" + entranceDate
				+ ", absenceYn=" + absenceYn + ", coachProfessorNo=" + coachProfessorNo + "]";
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSsn() {
		return studentSsn;
	}
	public void setStudentSsn(String studentSsn) {
		this.studentSsn = studentSsn;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getEntranceDate() {
		return entranceDate;
	}
	public void setEntranceDate(String entranceDate) {
		this.entranceDate = entranceDate;
	}
	public String getAbsenceYn() {
		return absenceYn;
	}
	public void setAbsenceYn(String absenceYn) {
		this.absenceYn = absenceYn;
	}
	public String getCoachProfessorNo() {
		return coachProfessorNo;
	}
	public void setCoachProfessorNo(String coachProfessorNo) {
		this.coachProfessorNo = coachProfessorNo;
	}
	
}
