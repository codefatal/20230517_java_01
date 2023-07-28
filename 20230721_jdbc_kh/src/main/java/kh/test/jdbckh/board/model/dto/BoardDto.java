package kh.test.jdbckh.board.model.dto;

public class BoardDto {
//	BNO	NUMBER
//	BTITLE	VARCHAR2(300 BYTE)
//	BCONTENT	VARCHAR2(4000 BYTE)
//	BWRITE_DATE	TIMESTAMP(6)
//	MID	VARCHAR2(20 BYTE)
//	BREF	NUMBER
//	BRE_LEVEL	NUMBER
//	BRE_STEP	NUMBER
	private int bno;
	private String btitle; 
	private String bcontent;
	private String bwriteDate;
	private String mid;
	private int bref;
	private int breLevel;
	private int breStep;
	
	// public BoardDto() {}
	
	// selectOne dao --> controller --> view
	public BoardDto(int bno, String btitle, String bcontent, String bwriteDate, String mid, int bref, int breLevel, int breStep) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriteDate = bwriteDate;
		this.mid = mid;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}
	
	// selectList(content 없음) dao --> controller --> view
	public BoardDto(int bno, String btitle, String bwriteDate, String mid, int bref, int breLevel, int breStep) {
		this.bno = bno;
		this.btitle = btitle;
		// content 없음
		this.bwriteDate = bwriteDate;
		this.mid = mid;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}

	// 원본글 등록 view --> controller --> dao
	public BoardDto(String btitle, String bcontent, String mid) {
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mid = mid;
	}
	
	// 답글 등록 view --> controller --> dao
	public BoardDto(int bno, String btitle, String bcontent, String mid) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mid = mid;
	}
	
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriteDate=" + bwriteDate
				+ ", mid=" + mid + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep=" + breStep + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriteDate() {
		return bwriteDate;
	}

	public void setBwriteDate(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getBref() {
		return bref;
	}

	public void setBref(int bref) {
		this.bref = bref;
	}

	public int getBreLevel() {
		return breLevel;
	}

	public void setBreLevel(int breLevel) {
		this.breLevel = breLevel;
	}

	public int getBreStep() {
		return breStep;
	}

	public void setBreStep(int breStep) {
		this.breStep = breStep;
	}
	
	
}
