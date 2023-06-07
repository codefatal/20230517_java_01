package kh.lclass.vo;

public class TestVo {
	private int boardNum;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	
	// 생성자
	public TestVo() {}
	// arguments 생성자
	public TestVo(int boardNum, String boardWriter, String boardTitle, String boardContent, String boardDate) {
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}
	// getter
	public int getBoardNum() {
		return boardNum;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	// setter
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public void setBoardWirter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	// toString
	public String toString() {
		return boardNum+"/"+boardWriter+"/"+boardTitle+"/"+boardContent+"/"+boardDate;
	}
}
