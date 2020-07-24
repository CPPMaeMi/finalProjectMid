package com.jhta.project.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MScheduleInsertVo {
	private int[] theatherNum;
	private String date;
	private String time;
	private int purchasefilmNum;
	private String filmDeadline;
	public MScheduleInsertVo() {
		super();
	}
	public MScheduleInsertVo(int[] theatherNum, String date, String time, int purchasefilmNum, String filmDeadline) {
		super();
		this.theatherNum = theatherNum;
		this.date = date;
		this.time = time;
		this.purchasefilmNum = purchasefilmNum;
		this.filmDeadline = filmDeadline;
	}
	public int[] getTheatherNum() {
		return theatherNum;
	}
	public void setTheatherNum(int[] theatherNum) {
		this.theatherNum = theatherNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPurchasefilmNum() {
		return purchasefilmNum;
	}
	public void setPurchasefilmNum(int purchasefilmNum) {
		this.purchasefilmNum = purchasefilmNum;
	}
	public String getFilmDeadline() {
		return filmDeadline;
	}
	public void setFilmDeadline(String filmDeadline) {
		this.filmDeadline = filmDeadline;
	}
	
}
