package com.jhta.project.vo;

public class WSListVo {
	private int sNum;
	private String sffname;
	private String divisionname;
	private String sffposition;
	private String workstart;
	private String workend;
	public WSListVo() {}
	
	public WSListVo(int sNum, String sffname, String divisionname, String sffposition, String workstart,
			String workend) {
		super();
		this.sNum = sNum;
		this.sffname = sffname;
		this.divisionname = divisionname;
		this.sffposition = sffposition;
		this.workstart = workstart;
		this.workend = workend;
	}
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	public String getSffname() {
		return sffname;
	}
	public void setSffname(String sffname) {
		this.sffname = sffname;
	}
	public String getDivisionname() {
		return divisionname;
	}
	public void setDivisionname(String divisionname) {
		this.divisionname = divisionname;
	}
	public String getSffposition() {
		return sffposition;
	}
	public void setSffposition(String sffposition) {
		this.sffposition = sffposition;
	}
	public String getWorkstart() {
		return workstart;
	}
	public void setWorkstart(String workstart) {
		this.workstart = workstart;
	}
	public String getWorkend() {
		return workend;
	}
	public void setWorkend(String workend) {
		this.workend = workend;
	}
	
}
