package com.jhta.project.vo;

import java.sql.Date;

public class MScheduleListVo {
	private int purchasefilmNum; //��ȭ�󿵱Ǳ��� ������
	private Date purchaseDate; //�������󿵽�����
	private Date filmDeadline; //��������������
	private int filmNum; //��ȭ��ȣ ������
	private int branchNum; //������ȣ������
	private String filmName; //��ȭ�̸�
	private String filmStory; //��ȭ�ٰŸ�
	private String generName; //�帣����
	private String movieimgUrl; //�̹������
	
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
