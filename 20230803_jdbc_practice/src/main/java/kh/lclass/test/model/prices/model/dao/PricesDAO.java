package kh.lclass.test.model.prices.model.dao;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.lclass.test.model.prices.model.dto.PricesDTO;

public class PricesDAO {
	
	public List<PricesDTO> selectListLog(Connection conn) {
		List<PricesDTO> result = null;
		String query = "select * from prices";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<PricesDTO>();
			while(rs.next() == true) {
				PricesDTO dto = new PricesDTO();
				dto.setpNum(rs.getInt("pnum"));
				dto.setCoincode(rs.getString("coincode"));
				dto.setPrice(rs.getDouble("price"));
				dto.setVolumes(rs.getDouble("volumes"));
				dto.setDates(rs.getDate("dates"));
				result.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
