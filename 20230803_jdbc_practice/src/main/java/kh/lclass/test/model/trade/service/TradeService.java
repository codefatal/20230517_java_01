package kh.lclass.test.model.trade.service;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.lclass.test.model.trade.model.dao.TradeDAO;
import kh.lclass.test.model.trade.model.dto.TradeDTO;

public class TradeService {
	
	private TradeDAO dao = new TradeDAO();
	
	public List<TradeDTO> selectListLog() {
		Connection conn = getConnection();
		List<TradeDTO> result = dao.selectListLog(conn);
		close(conn);
		return result;
	}
}
