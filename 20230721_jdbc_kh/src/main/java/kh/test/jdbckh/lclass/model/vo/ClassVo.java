package kh.test.jdbckh.lclass.model.vo;

public class ClassVo {
//	CLASS_NO
//	DEPARTMENT_NO
//	PREATTENDING_CLASS_NO
//	CLASS_NAME
//	CLASS_TYPE
	private String classNo; 
	private String departmentNo;
	private String preattendingClassNo;
	private String className;
	private String classType;
	
	

	@Override
	public String toString() {
		return "ClassVo [classNo=" + classNo + ", departmentNo=" + departmentNo + ", preattendingClassNo="
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
