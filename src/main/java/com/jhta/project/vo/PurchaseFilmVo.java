package com.jhta.project.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseFilmVo {
	private int purchaseFilmNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date filmDeadline;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date purchaseDate;
	private int filmNum;
	private int branchNum;
	public PurchaseFilmVo(int purchaseFilmNum, Date filmDeadline, Date purchaseDate, int filmNum, int branchNum) {
		super();
		this.purchaseFilmNum = purchaseFilmNum;
		this.filmDeadline = filmDeadline;
		this.purchaseDate = purchaseDate;
		this.filmNum = filmNum;
		this.branchNum = branchNum;
	}
	public PurchaseFilmVo() {
		super();
	};
	public int getPurchaseFilmNum() {
		return purchaseFilmNum;
	}
	public void setPurchaseFilmNum(int purchaseFilmNum) {
		this.purchaseFilmNum = purchaseFilmNum;
	}
	public Date getFilmDeadline() {
		return filmDeadline;
	}
	public void setFilmDeadline(Date filmDeadline) {
		this.filmDeadline = filmDeadline;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	
	
}
