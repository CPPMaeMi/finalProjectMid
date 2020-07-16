package com.jhta.project.vo;

public class WScheduleVo {
	private int sNum;
	private int staffNum;
	private String workStart;
	private String workEnd;
	private String workDate;
	public WScheduleVo(int sNum, int staffNum, String workStart, String workEnd, String workDate) {
		super();
		this.sNum = sNum;
		this.staffNum = staffNum;
		this.workStart = workStart;
		this.workEnd = workEnd;
		this.workDate = workDate;
	}
	public WScheduleVo() {
		super();
	}
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	public int getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
	public String getWorkStart() {
		return workStart;
	}
	public void setWorkStart(String workStart) {
		this.workStart = workStart;
	}
	public String getWorkEnd() {
		return workEnd;
	}
	public void setWorkEnd(String workEnd) {
		this.workEnd = workEnd;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	
}
