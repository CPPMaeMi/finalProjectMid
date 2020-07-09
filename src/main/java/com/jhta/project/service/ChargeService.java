package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.ChargeDao;
import com.jhta.project.vo.ChargeVo;

@Service
public class ChargeService {
	@Autowired
	private ChargeDao chargeDao;

	public List<ChargeVo> genderList(){
		return chargeDao.genderList();
	}
}









