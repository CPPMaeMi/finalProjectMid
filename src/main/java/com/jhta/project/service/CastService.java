package com.jhta.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.FilmListDao;
import com.jhta.project.vo.CastVo;

@Service
public class CastService {
	@Autowired
	private FilmListDao dao;
	
	public CastVo getinfo1(int filmNum) {
		return dao.getinfo1(filmNum);
	}
}
