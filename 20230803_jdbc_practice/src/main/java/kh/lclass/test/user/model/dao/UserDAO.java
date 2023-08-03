package kh.lclass.test.user.model.dao;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.lclass.test.user.model.dto.UserDTO;

public class UserDAO {
	public List<UserDTO> selectListUser(Connection conn) {
		List<UserDTO> result = null;
		String query = "select * from site_user";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<UserDTO>();
			while(rs.next() == true) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getInt("id"));
				dto.setUsername(rs.getString("username"));
				dto.setPassword("password");
				dto.setEmail(rs.getString("email"));
				
				result.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
