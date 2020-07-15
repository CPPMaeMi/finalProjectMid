package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.TheatherDao;
import com.jhta.project.vo.TheatherVo;

@Service
public class TheatherService {
	@Autowired
	private TheatherDao dao;
	
	public List<TheatherVo> list(int branchNum){
		return dao.list(branchNum);
	}
}
