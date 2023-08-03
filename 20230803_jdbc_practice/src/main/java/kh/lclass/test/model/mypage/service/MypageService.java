package kh.lclass.test.model.mypage.service;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;

import kh.lclass.test.model.mypage.model.dao.MypageDAO;
import kh.lclass.test.model.mypage.model.dto.MypageDTO;

public class MypageService {
	
	private MypageDAO dao = new MypageDAO();
	
	public MypageDTO selectUserMypage(int searchNum) {
		Connection conn = getConnection();
		MypageDTO result = dao.selectUserMypage(conn, searchNum);
		close(conn);
		return result;
	}
}
