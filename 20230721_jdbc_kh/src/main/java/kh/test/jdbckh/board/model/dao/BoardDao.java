package kh.test.jdbckh.board.model.dao;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.board.model.dto.BoardDto;

public class BoardDao {
	// 모든 행 읽기
	public List<BoardDto> selectList(Connection conn) {
		System.out.println("[Board dao selectList]");
		List<BoardDto> result = new ArrayList<BoardDto>();
		String query = "select * from BOARD";
		query += " order by bref desc, bre_step asc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next() ) {
				BoardDto dto = new BoardDto(
						rs.getInt("BNO"),
						rs.getString("BTITLE"),
						rs.getString("BWRITE_DATE"),
						rs.getString("MID"),
						rs.getInt("BREF"),
						rs.getInt("BRE_LEVEL"),
						rs.getInt("BRE_STEP")
						);
					result.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Board dao selectList] return:" + result);
		return result;
	}
	
	// 한 행 읽기 - PK로 where 조건 - 상세정보
	public BoardDto selectOne(Connection conn, int bno) {
		System.out.println("[Board dao selectOne] bno:"+bno);
		BoardDto result = null;
		String query = " select BNO, BTITLE, BCONTENT, to_char(BWRITE_DATE, 'yyyy-mm-dd') BWRITE_DATE, MID, BREF, BRE_LEVEL, BRE_STEP from BOARD ";
		query += " where BNO IN ?";
		query += " order by bref desc, bre_step asc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next() == true) {
				result = new BoardDto(
						rs.getInt("BNO"),
						rs.getString("BTITLE"),
						rs.getString("BCONTENT"),
						rs.getString("BWRITE_DATE"),
						rs.getString("MID"),
						rs.getInt("BREF"),
						rs.getInt("BRE_LEVEL"),
						rs.getInt("BRE_STEP")
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Board dao selectOne] return:" + result);
		return result;
	}
	
	// 한 행 삽입 - BoardDto의 자료형을 받아와야 함.
	public int insert(Connection conn, BoardDto dto) {
		System.out.println("[Board dao insert] dto: "+dto);
		int result = 0;
		PreparedStatement pstmt = null;
		String query = " insert into insert into BOARD values (SEQ_BOARD_BNO.nextval, ?, ?, default, 'kh'";
		if(dto.getBno() == dto.getBref()) {
			query += ", SEQ_BOARD_BNO.nextval, 0, 0)";
		} else {
			query += " , (select BREF from BOARD where BNO=?)";
			query += " , (select BRE_LEVEL+1 from BOARD where BNO=?)";
			query += " , (select BRE_STEP+1 from BOARD where BNO=?))";
		}
		try {
			pstmt = conn.prepareStatement(query);
			if(dto.getBno() == dto.getBref()) {				
				pstmt.setInt(1, dto.getBno());
				pstmt.setString(2, dto.getBtitle());
			} else {
				pstmt.setInt(1, dto.getBno());
				pstmt.setString(2, dto.getBtitle());				
				pstmt.setString(3, dto.getBcontent());
				pstmt.setInt(4, dto.getBno());
				pstmt.setInt(5, dto.getBno());
			}
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[Board dao insert] return:" + result);
		return result;
	}

	// 한 행 수정 - BoardDto 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
	public int update(Connection conn, BoardDto dto) {
		System.out.println("[Board dao update] dto: "+dto);
		int result = 0;
		PreparedStatement pstmt = null;
		String query = " update BOARD set BRE_STEP = BRE_STEP + 1";
		query += " where BRE_STEP > (select BRE_STEP from BOARD where BNO=?)";
		query += "and BREF = (select BREF from BOARD where BNO=?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getBno());
			pstmt.setInt(2, dto.getBno());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[Board dao update] return:" + result);
		return result;
	}
	
	// 한 행 삭제 - 주로 PK로 where 조건
	public int delete(Connection conn, int bno) {
		System.out.println("[Board dao delete] bno: "+bno);
		int result = 0;
		PreparedStatement pstmt = null;
		String query = " delete from BOARD where BNO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[Board dao delete] return:" + result);
		return result;
	}
	
	// 페이징 처리(pageSize!=0 아닐때) + 검색(있다면 where 처리)
	public int getTotalCount(Connection conn, String searchWord) {
		System.out.println("[Board dao getTotalCount]");
		
		int result = 0;
		String query = "select count(*) cnt from BOARD";
		if(searchWord != null) {
			query += " where BTITLE like ? or BCONTENT like ? or MID ?";
			searchWord = "%"+searchWord+"%";
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			if(searchWord != null) {
				pstmt.setString(1, searchWord);
				pstmt.setString(2, searchWord);
				pstmt.setString(3, searchWord);
			}
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[Board dao getTotalCount] return:"+result);
		return result;
	}
	
	public List<BoardDto> selectList(Connection conn, int currentPage, int pageSize, int totalCount, String searchWord) {
		System.out.println("[Board dao selectList] currentPage:"+currentPage+", pageSize:"+pageSize+", totalCount:"+totalCount+", searchWord:"+searchWord);
		
		// 페이징처리 방정식
		int startRownum = 0;
		int endRownum = 0;
		if(pageSize > 0) {
			startRownum = (currentPage-1)*pageSize+1;
			endRownum = ((currentPage*pageSize) > totalCount) ? totalCount: (currentPage*pageSize);
			System.out.println("startRownum:"+startRownum+", endRownum:"+endRownum);
		}
		
		List<BoardDto> result = new ArrayList<BoardDto>();
		String subquery = " select BNO, BTITLE, to_char(BWRITE_DATE, 'yyyy-mm-dd') BWRITE_DATE, MID, BREF, BRE_LEVEL, BRE_STEP from BOARD";
		if(searchWord != null) {
			subquery += " where BTITLE like ? or BCONTENT like ? or MID ?";
			searchWord = "%"+searchWord+"%";
		}
		subquery += " order by bref desc, bre_step asc";
		String query = subquery;
		if(pageSize > 0) { // 페이징 처리(pageSize!=0 아닐때)
			query = " select * from (select ROWNUM rnum, tb1.* from " +"(" + subquery + ")";
			query += " where rnum between ? and ?";
		}
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			if(searchWord != null) { // 검색(있다면 where 처리)
				pstmt.setString(1, searchWord);
				pstmt.setString(2, searchWord);
				pstmt.setString(3, searchWord);
			}
			if(searchWord != null && pageSize > 0) { // 검색(있다면 where 처리) // 페이징 처리(pageSize!=0 아닐때)
				pstmt.setInt(4, startRownum);
				pstmt.setInt(5, endRownum);
			} else if(searchWord == null && pageSize > 0) { // 페이징 처리(pageSize!=0 아닐때)
				pstmt.setInt(1, startRownum);
				pstmt.setInt(2, endRownum);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				BoardDto dto = new BoardDto(
						rs.getInt("BNO"),
						rs.getString("BTITLE"),
						rs.getString("BWRITE_DATE"),
						rs.getString("MID"),
						rs.getInt("BREF"),
						rs.getInt("BRE_LEVEL"),
						rs.getInt("BRE_STEP")
						);
				result.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Board dao selectList] return:"+result);
		return result;
	}
}
