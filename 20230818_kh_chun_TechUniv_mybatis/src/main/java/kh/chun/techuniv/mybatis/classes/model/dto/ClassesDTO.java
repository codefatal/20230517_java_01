package kh.chun.techuniv.mybatis.classes.model.dto;

public class ClassesDTO {
//	CLASS_NO	VARCHAR2(10 BYTE)
//	DEPARTMENT_NO	VARCHAR2(20 BYTE)
//	PREATTENDING_CLASS_NO	VARCHAR2(20 BYTE)
//	CLASS_NAME	VARCHAR2(60 BYTE)
//	CLASS_TYPE	VARCHAR2(20 BYTE)
	private String classNo;
	private String departmentNo;
	private String preattendingClassNo;
	private String className;
	private String classType;
	
	@Override
	public String toString() {
		return "ClassesDTO [classNo=" + classNo + ", departmentNo=" + departmentNo + ", preattendingClassNo="
				+ preattendingClassNo + ", className=" + className + ", classType=" + classType + "]";
	}
	
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getPreattendingClassNo() {
		return preattendingClassNo;
	}
	public void setPreattendingClassNo(String preattendingClassNo) {
		this.preattendingClassNo = preattendingClassNo;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
}
