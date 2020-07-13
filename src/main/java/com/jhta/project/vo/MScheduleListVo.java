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
	private String generName; //장르종류
	private String movieimgUrl; //이미지경로
	
	public MScheduleListVo() {}

	public MScheduleListVo(int purchasefilmNum, Date purchaseDate, Date filmDeadline, int filmNum, int branchNum,
			String filmName, String filmStory, String generName, String movieimgUrl) {
		super();
		this.purchasefilmNum = purchasefilmNum;
		this.purchaseDate = purchaseDate;
		this.filmDeadline = filmDeadline;
		this.filmNum = filmNum;
		this.branchNum = branchNum;
		this.filmName = filmName;
		this.filmStory = filmStory;
		this.generName = generName;
		this.movieimgUrl = movieimgUrl;
	}
	

}
