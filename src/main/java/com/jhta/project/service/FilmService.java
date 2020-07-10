package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.FilmListDao;
import com.jhta.project.vo.FilmVo;

@Service
public class FilmService {
	@Autowired
	private FilmListDao dao;
	
	public int Count(HashMap<String,Object> map) {
		return dao.count(map);
	}
	
	public List<HashMap<String, Object>> list(){
		return dao.list();
	}
	
	public FilmVo getinfo(int filmNum) {
		return dao.getinfo(filmNum);
	}

}
