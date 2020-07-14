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
	private String man;//회원 성별
	private String woman;//회원 성별
	private int teens;//10대
	private int twenties;//20대
	private int thirties;//30대
	private int forties;//40대
	private int fifties;//50대
	private int sixties;//60대

	public ChargeVo() {}

	public ChargeVo(int chargeNum, int memNum, int cDetailNum, String payment, String memStatus, String chRegdate,
			int bookNum, String phone, int totalbill, String man, String woman, int teens, int twenties, int thirties,
			int forties, int fifties, int sixties) {
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
		this.man = man;
		this.woman = woman;
		this.teens = teens;
		this.twenties = twenties;
		this.thirties = thirties;
		this.forties = forties;
		this.fifties = fifties;
		this.sixties = sixties;
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

	public String getMan() {
		return man;
	}

	public void setMan(String man) {
		this.man = man;
	}

	public String getWoman() {
		return woman;
	}

	public void setWoman(String woman) {
		this.woman = woman;
	}

	public int getTeens() {
		return teens;
	}

	public void setTeens(int teens) {
		this.teens = teens;
	}

	public int getTwenties() {
		return twenties;
	}

	public void setTwenties(int twenties) {
		this.twenties = twenties;
	}

	public int getThirties() {
		return thirties;
	}

	public void setThirties(int thirties) {
		this.thirties = thirties;
	}

	public int getForties() {
		return forties;
	}

	public void setForties(int forties) {
		this.forties = forties;
	}

	public int getFifties() {
		return fifties;
	}

	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	public int getSixties() {
		return sixties;
	}

	public void setSixties(int sixties) {
		this.sixties = sixties;
	}

}
