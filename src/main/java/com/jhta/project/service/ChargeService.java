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

	
	 public List<ChargeVo> yearList(HashMap<String, String> map){ 
		 return chargeDao.yearList(map); 
	 }
	 public List<ChargeVo> monthList(HashMap<String,String> map){ 
		 return chargeDao.monthList(map); 
	 }
}









