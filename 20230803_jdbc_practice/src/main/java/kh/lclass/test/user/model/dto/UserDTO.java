package kh.lclass.test.user.model.dto;

public class UserDTO {
//	ID	NUMBER
//	USERNAME	VARCHAR2(255 BYTE)
//	PASSWORD	VARCHAR2(255 BYTE)
//	EMAIL	VARCHAR2(255 BYTE)
	private int id; 
	private String username;
	private String password;
	private String email;
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
