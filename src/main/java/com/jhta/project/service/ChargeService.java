package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.ChargeDao;
import com.jhta.project.vo.ChargeVo;

@Service
public class ChargeService {
	@Autowired
	private ChargeDao chargeDao;

	//성별 년도별 매출조회
	public List<ChargeVo> genderYearList(HashMap<String, String> map){ 
		return chargeDao.genderYearList(map); 
	}
	//성별 월별 매출조회
	public List<ChargeVo> genderMonthList(HashMap<String,String> map){ 
		return chargeDao.genderMonthList(map); 
	}
	//연령별 년도별 매출조회
	public List<ChargeVo> ageYearList(HashMap<String, String> map){ 
		return chargeDao.ageYearList(map); 
	}
	//연령별 월별 매출조회
	public List<ChargeVo> ageMonthList(HashMap<String,String> map){ 
		return chargeDao.ageMonthList(map); 
	}
}









