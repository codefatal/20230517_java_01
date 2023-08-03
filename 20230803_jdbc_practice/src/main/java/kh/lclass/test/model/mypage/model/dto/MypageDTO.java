package kh.lclass.test.model.mypage.model.dto;

public class MypageDTO {
//	ID	NUMBER
//	MONEY	FLOAT
//	USER_BTC	FLOAT
//	USER_ETH	FLOAT
	private int id;
	private double money;
	private double userBtc;
	private double userEth;
	
	private String username;
	
	@Override
	public String toString() {
		return "MypageDTO [id=" + id + ", money=" + money + ", userBtc=" + userBtc + ", userEth=" + userEth
				+ ", username=" + username + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getUserBtc() {
		return userBtc;
	}

	public void setUserBtc(double userBtc) {
		this.userBtc = userBtc;
	}

	public double getUserEth() {
		return userEth;
	}

	public void setUserEth(double userEth) {
		this.userEth = userEth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
