package com.jhta.project.vo;

public class ChargeVo {
	private int chargeNum;
	private int memNum;
	private int cDetailNum;
	private String payment;
	private String memStatus;
	private String chRegdate;
	private int bookNum;
	private String phone;
	private int totalbill;//결제금액
	private String birth;//회원 생일(연령대/성별)알기위해

	public ChargeVo() {}

	public ChargeVo(int chargeNum, int memNum, int cDetailNum, String payment, String memStatus, String chRegdate,
			int bookNum, String phone, int totalbill, String birth) {
		super();
		this.chargeNum = chargeNum;
		this.memNum = memNum;
		this.cDetailNum = cDetailNum;
		this.payment = payment;
		this.memStatus = memStatus;
		this.chRegdate = chRegdate;
		this.bookNum = bookNum;
		this.phone = phone;
		this.totalbill = totalbill;
		this.birth = birth;
	}

	public int getChargeNum() {
		return chargeNum;
	}

	public void setChargeNum(int chargeNum) {
		this.chargeNum = chargeNum;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public int getcDetailNum() {
		return cDetailNum;
	}

	public void setcDetailNum(int cDetailNum) {
		this.cDetailNum = cDetailNum;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getMemStatus() {
		return memStatus;
	}

	public void setMemStatus(String memStatus) {
		this.memStatus = memStatus;
	}

	public String getChRegdate() {
		return chRegdate;
	}

	public void setChRegdate(String chRegdate) {
		this.chRegdate = chRegdate;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTotalbill() {
		return totalbill;
	}

	public void setTotalbill(int totalbill) {
		this.totalbill = totalbill;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
}
