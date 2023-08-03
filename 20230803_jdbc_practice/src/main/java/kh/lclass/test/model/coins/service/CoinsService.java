package kh.lclass.test.model.coins.service;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.lclass.test.model.coins.model.dao.CoinsDAO;
import kh.lclass.test.model.coins.model.dto.CoinsDTO;

public class CoinsService {
	
	private CoinsDAO dao = new CoinsDAO();
	
	public List<CoinsDTO> selectListCoins() {
		System.out.println("Coins [selectListCoins]");
		Connection conn = getConnection();
		List<CoinsDTO> result = dao.selectListCoins(conn);
		close(conn);
		System.out.println("Coins [selectListCoins] return :" + result);
		return result;
	}
}
