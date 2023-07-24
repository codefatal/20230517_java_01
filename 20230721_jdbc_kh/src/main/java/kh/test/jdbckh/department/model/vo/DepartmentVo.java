package kh.test.jdbckh.department.model.vo;

public class DepartmentVo {
//	DEPARTMENT_NO
//	DEPARTMENT_NAME
//	CATEGORY
//	OPEN_YN
//	CAPACITY
	private String departmentNo;
	private String departmentName;
	private String category;
	private String openYn;
	private String capacity;
	
	@Override
	public String toString() {
		return "DepartmentVo [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", category="
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

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
}
