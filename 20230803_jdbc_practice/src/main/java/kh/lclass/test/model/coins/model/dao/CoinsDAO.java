package kh.lclass.test.model.coins.model.dao;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.lclass.test.model.coins.model.dto.CoinsDTO;

public class CoinsDAO {
	
	public List<CoinsDTO> selectListCoins(Connection conn) {
		System.out.println("DAO [selectListCoins]");
		List<CoinsDTO> result = null;
		PreparedStatement pstmt = null;
		String query = "select * from coins";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<CoinsDTO>();
			while(rs.next() == true) {
				CoinsDTO dto = new CoinsDTO();
				dto.setCoincode(rs.getString("coincode"));
				dto.setCoinname(rs.getString("coinname"));
				result.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("DAO [selectListCoins] return : " + result);
		return result;
	}
}
