package kh.lclass.test.model.prices.model.dto;

import java.sql.Date;

public class PricesDTO {
//	PNUM	NUMBER
//	COINCODE	VARCHAR2(10 BYTE)
//	PRICE	FLOAT
//	VOLUMES	FLOAT
//	DATES	TIMESTAMP(6)
	private int pNum;
	private String coincode;
	private double price;
	private double volumes;
	private Date Dates;
	
	@Override
	public String toString() {
		return "PricesDTO [pNum=" + pNum + ", coincode=" + coincode + ", price=" + price + ", volumes=" + volumes
				+ ", Dates=" + Dates + "]";
	}
	
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getCoincode() {
		return coincode;
	}
	public void setCoincode(String coincode) {
		this.coincode = coincode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVolumes() {
		return volumes;
	}
	public void setVolumes(double volumes) {
		this.volumes = volumes;
	}
	public Date getDates() {
		return Dates;
	}
	public void setDates(Date dates) {
		Dates = dates;
	}
	
}
