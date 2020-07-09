package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.RevenuDao;
import com.jhta.project.vo.RevenueVo;

@Service
public class RevenuService {
	@Autowired
	private RevenuDao revenuDao;
	
	public List<RevenueVo> monthList(HashMap<String, String> map){
		return revenuDao.monthList(map);
	}
	public List<RevenueVo> dayList(HashMap<String, String> map){
		return revenuDao.dayList(map);
	}
	public List<RevenueVo> yearList(HashMap<String, String> map){
		return revenuDao.yearList(map);
	}
}









