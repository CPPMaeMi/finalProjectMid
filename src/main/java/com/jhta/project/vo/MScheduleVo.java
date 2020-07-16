package com.jhta.project.vo;

import java.util.Date;

public class MScheduleVo {
	private int mScheduleNum;
	private String mStartTime;
	private int purchaseFilmNum;
	private int theatherNum;
	private Date d;
	public MScheduleVo() {}
	public MScheduleVo(int mScheduleNum, String mStartTime, int purchaseFilmNum, int theatherNum) {
		super();
		this.mScheduleNum = mScheduleNum;
		this.mStartTime = mStartTime;
		this.purchaseFilmNum = purchaseFilmNum;
		this.theatherNum = theatherNum;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public Date getD() {
		return d;
	}
	public int getmScheduleNum() {
		return mScheduleNum;
	}
	public void setmScheduleNum(int mScheduleNum) {
		this.mScheduleNum = mScheduleNum;
	}
	public String getmStartTime() {
		return mStartTime;
	}
	public void setmStartTime(String mStartTime) {
		this.mStartTime = mStartTime;
	}
	public int getPurchaseFilmNum() {
		return purchaseFilmNum;
	}
	public void setPurchaseFilmNum(int purchaseFilmNum) {
		this.purchaseFilmNum = purchaseFilmNum;
	}
	public int getTheatherNum() {
		return theatherNum;
	}
	public void setTheatherNum(int theatherNum) {
		this.theatherNum = theatherNum;
	}
	
}
