package kh.lclass.test.model.trade.model.dao;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.lclass.test.model.trade.model.dto.TradeDTO;

public class TradeDAO {
	
	public List<TradeDTO> selectListLog(Connection conn) {
		List<TradeDTO> result = null;
		String query = "select * from trade_test";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<TradeDTO>();
			while(rs.next() == true) {
				TradeDTO dto = new TradeDTO();
				dto.setId(rs.getInt("id"));
				dto.setCoincode(rs.getString("coincode"));
				dto.setTradeType(rs.getInt("trade_type"));
				dto.setTradePrice(rs.getInt("trade_price"));
				dto.setTradeItem(rs.getDouble("trade_item"));
				dto.setTradeMoney(rs.getInt("TradeMoney"));
				dto.setTradeCount(rs.getInt("trade_count"));
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
