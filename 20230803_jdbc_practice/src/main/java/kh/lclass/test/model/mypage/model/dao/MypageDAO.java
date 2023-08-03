package kh.lclass.test.model.mypage.model.dao;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.lclass.test.model.mypage.model.dto.MypageDTO;

public class MypageDAO {
	
	public MypageDTO selectUserMypage(Connection conn, int searchNum) {
		System.out.println("DAO [selectUserMypage]");
		MypageDTO result = null;
		String query = "select u.id, u.username, m.money, user_btc, user_eth from mypage m";
		query += " join site_user u on u.id = m.id";
		query += " where m.id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, searchNum);
			rs = pstmt.executeQuery();
			result = new MypageDTO();
			if(rs.next()) {
				result.setId(rs.getInt("id"));
				result.setUsername(rs.getString("username"));
				result.setMoney(rs.getDouble("money"));
				result.setUserBtc(rs.getDouble("user_btc"));
				result.setUserEth(rs.getDouble("user_eth"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("DAO [selectUserMypage] return : " + result);
		return result;
	}
}
