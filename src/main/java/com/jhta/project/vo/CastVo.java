package com.jhta.project.vo;

public class CastVo {
	private int castNum;
	private String castName;
	private int filmNum;
	public CastVo(int castNum, String castName, int filmNum) {
		super();
		this.castNum = castNum;
		this.castName = castName;
		this.filmNum = filmNum;
	}
	public CastVo() {
		super();
	}
	public int getCastNum() {
		return castNum;
	}
	public void setCastNum(int castNum) {
		this.castNum = castNum;
	}
	public String getCastName() {
		return castName;
	}
	public void setCastName(String castName) {
		this.castName = castName;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	
}
