package kh.lclass.test.user.service;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.lclass.test.user.model.dao.UserDAO;
import kh.lclass.test.user.model.dto.UserDTO;

public class UserService {
	
	private UserDAO dao = new UserDAO();
	
	public List<UserDTO> selectListUser() {
		System.out.println("[selectListUser]");
		Connection conn = getConnection();
		List<UserDTO> result = dao.selectListUser(conn);
		close(conn);
		System.out.println("[selectListUser] return : "+ result);
		return result;
	}
}
