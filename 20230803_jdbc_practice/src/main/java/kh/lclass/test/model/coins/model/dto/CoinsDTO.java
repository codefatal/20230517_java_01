package kh.lclass.test.model.coins.model.dto;

public class CoinsDTO {
//	COINCODE	VARCHAR2(10 BYTE)
//	COINNAME	VARCHAR2(100 BYTE)
	private String coincode;
	private String coinname;
	
	@Override
	public String toString() {
		return "CoinsDTO [coincode=" + coincode + ", coinname=" + coinname + "]";
	}
	
	public String getCoincode() {
		return coincode;
	}
	public void setCoincode(String coincode) {
		this.coincode = coincode;
	}
	public String getCoinname() {
		return coinname;
	}
	public void setCoinname(String coinname) {
		this.coinname = coinname;
	}
	
}
