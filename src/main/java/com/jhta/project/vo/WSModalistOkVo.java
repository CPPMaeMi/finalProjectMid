package com.jhta.project.vo;

public class WSModalistOkVo {
	private int[] namecheck;
	private String startime;
	private String endtime;
	private String workDate;
	
	public WSModalistOkVo() {}
	
	public WSModalistOkVo(int[] namecheck, String startime, String endtime, String workDate) {
		super();
		this.namecheck = namecheck;
		this.startime = startime;
		this.endtime = endtime;
		this.workDate = workDate;
	}
	public int[] getNamecheck() {
		return namecheck;
	}
	public void setNamecheck(int[] namecheck) {
		this.namecheck = namecheck;
	}
	public String getStartime() {
		return startime;
	}
	public void setStartime(String startime) {
		this.startime = startime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	
	
}
