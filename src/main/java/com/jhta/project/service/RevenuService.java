package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.RevenuDao;
import com.jhta.project.vo.RevenueVo;

@Service
public class RevenuService {
	@Autowired
	private RevenuDao revenuDao;
	
	public List<RevenueVo> yearList(){
		return revenuDao.yearList();
	}
}









