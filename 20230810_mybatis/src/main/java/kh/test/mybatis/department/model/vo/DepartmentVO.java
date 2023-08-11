package kh.test.mybatis.department.model.vo;

public class DepartmentVO {
//	DEPARTMENT_NO	VARCHAR2(10 BYTE)
//	DEPARTMENT_NAME	VARCHAR2(40 BYTE)
//	CATEGORY	VARCHAR2(40 BYTE)
//	OPEN_YN	CHAR(1 BYTE)
//	CAPACITY	NUMBER
	private String departmentNo;
	private String departmentName;
	private String category;
	private char openYn;
	private int capacity;
	
	public DepartmentVO() {}
	
	public DepartmentVO(String departmentNo, String departmentName, String category, char openYn, int capacity) {
		super();
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.category = category;
		this.openYn = openYn;
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "DepartmentVO [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", category="
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

	public char getOpenYn() {
		return openYn;
	}

	public void setOpenYn(char openYn) {
		this.openYn = openYn;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
