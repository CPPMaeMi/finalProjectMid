package com.jhta.project.vo;

import java.sql.Date;

public class MScheduleListVo {
	private int purchasefilmNum; //영화상영권구매 시퀀스
	private Date purchaseDate; //지점내상영시작일
	private Date filmDeadline; //지점내상영종료일
	private int filmNum; //영화번호 시퀀스
	private int branchNum; //지점번호시퀀스
	private String filmName; //영화이름
	private String filmStory; //영화줄거리
	private String genreName; //장르종류
	private String movieimgUrl; //이미지경로
	
	public MScheduleListVo() {}

	public MScheduleListVo(int purchasefilmNum, Date purchaseDate, Date filmDeadline, int filmNum, int branchNum,
			String filmName, String filmStory, String genreName, String movieimgUrl) {
		super();
		this.purchasefilmNum = purchasefilmNum;
		this.purchaseDate = purchaseDate;
		this.filmDeadline = filmDeadline;
		this.filmNum = filmNum;
		this.branchNum = branchNum;
		this.filmName = filmName;
		this.filmStory = filmStory;
		this.genreName = genreName;
		this.movieimgUrl = movieimgUrl;
	}

	public int getPurchasefilmNum() {
		return purchasefilmNum;
	}

	public void setPurchasefilmNum(int purchasefilmNum) {
		this.purchasefilmNum = purchasefilmNum;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getFilmDeadline() {
		return filmDeadline;
	}

	public void setFilmDeadline(Date filmDeadline) {
		this.filmDeadline = filmDeadline;
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

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmStory() {
		return filmStory;
	}

	public void setFilmStory(String filmStory) {
		this.filmStory = filmStory;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getMovieimgUrl() {
		return movieimgUrl;
	}

	public void setMovieimgUrl(String movieimgUrl) {
		this.movieimgUrl = movieimgUrl;
	}
	

}
