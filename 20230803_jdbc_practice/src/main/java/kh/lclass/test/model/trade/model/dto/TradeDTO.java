package kh.lclass.test.model.trade.model.dto;

public class TradeDTO {
//	ID	NUMBER
//	COINCODE	VARCHAR2(10 BYTE)
//	TRADE_TYPE	NUMBER
//	TRADE_PRICE	NUMBER
//	TRADE_ITEM	FLOAT
//	TRADE_MONEY	NUMBER
//	TRADE_COUNT	NUMBER
	private int id;
	private String coincode;
	private int tradeType;
	private int tradePrice;
	private double tradeItem;
	private int tradeMoney;
	private int tradeCount;
	
	@Override
	public String toString() {
		return "TradetestDTO [id=" + id + ", coincode=" + coincode + ", tradeType=" + tradeType + ", tradePrice="
				+ tradePrice + ", tradeItem=" + tradeItem + ", tradeMoney=" + tradeMoney + ", tradeCount=" + tradeCount
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoincode() {
		return coincode;
	}

	public void setCoincode(String coincode) {
		this.coincode = coincode;
	}

	public int getTradeType() {
		return tradeType;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}

	public int getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(int tradePrice) {
		this.tradePrice = tradePrice;
	}

	public Double getTradeItem() {
		return tradeItem;
	}

	public void setTradeItem(Double tradeItem) {
		this.tradeItem = tradeItem;
	}

	public int getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(int tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public int getTradeCount() {
		return tradeCount;
	}

	public void setTradeCount(int tradeCount) {
		this.tradeCount = tradeCount;
	}
	
}
