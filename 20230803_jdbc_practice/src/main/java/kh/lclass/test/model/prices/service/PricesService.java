package kh.lclass.test.model.prices.service;

import static kh.lclass.test.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.lclass.test.model.prices.model.dao.PricesDAO;
import kh.lclass.test.model.prices.model.dto.PricesDTO;

public class PricesService {
	
	private PricesDAO dao = new PricesDAO();
	
	public List<PricesDTO> selectListLog() {
		Connection conn = getConnection();
		List<PricesDTO> result = dao.selectListLog(conn);
		close(conn);
		return result;
	}
}
