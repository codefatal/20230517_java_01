package kh.test.jdbckh.professor.model.vo;

public class ProfessorVo {
//	PROFESSOR_NO
//	PROFESSOR_NAME
//	PROFESSOR_SSN
//	PROFESSOR_ADDRESS
//	DEPARTMENT_NO
	private String professorNo; 
	private String professorName;
	private String professorSsn;
	private String professorAddress;
	private String departmentNo;
	
	@Override
	public String toString() {
		return "ProfessorVo [professorNo=" + professorNo + ", professorName=" + professorName + ", professorSsn="
				+ professorSsn + ", professorAddress=" + professorAddress + ", departmentNo=" + departmentNo + "]";
	}
	
	public String getProfessorNo() {
		return professorNo;
	}
	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getProfessorSsn() {
		return professorSsn;
	}
	public void setProfessorSsn(String professorSsn) {
		this.professorSsn = professorSsn;
	}
	public String getProfessorAddress() {
		return professorAddress;
	}
	public void setProfessorAddress(String professorAddress) {
		this.professorAddress = professorAddress;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	
}
