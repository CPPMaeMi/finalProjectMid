package com.jhta.project.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseFilmVo {
	private int purchaseFilmNum;
	private String filmDeadline;
	private String purchaseDate;
	private int filmNum;
	private int branchNum;
	public PurchaseFilmVo(int purchaseFilmNum, String filmDeadline, String purchaseDate, int filmNum, int branchNum) {
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
	public String getFilmDeadline() {
		return filmDeadline;
	}
	public void setFilmDeadline(String filmDeadline) {
		this.filmDeadline = filmDeadline;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
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
