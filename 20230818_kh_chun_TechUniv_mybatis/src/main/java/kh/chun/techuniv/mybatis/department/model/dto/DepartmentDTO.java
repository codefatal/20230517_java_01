package kh.chun.techuniv.mybatis.department.model.dto;

public class DepartmentDTO {
//	DEPARTMENT_NO	VARCHAR2(10 BYTE)
//	DEPARTMENT_NAME	VARCHAR2(40 BYTE)
//	CATEGORY	VARCHAR2(40 BYTE)
//	OPEN_YN	CHAR(1 BYTE)
//	CAPACITY	NUMBER
	private String departmentNo;
	private String departmentName;
	private String category;
	private String openYn;
	private int capacity;
	
	@Override
	public String toString() {
		return "DepartmentDTO [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", category="
				+ category + ", openYn=" + openYn + ", capacity=" + capacity + "]";
	}
	
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOpenYn() {
		return openYn;
	}
	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
