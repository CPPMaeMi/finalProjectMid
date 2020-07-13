package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.FilmListDao;
import com.jhta.project.vo.FilmVo;
import com.jhta.project.vo.PurchaseFilmVo;

@Service
public class FilmService {
	@Autowired
	private FilmListDao dao;
	
	public int count(HashMap<String,Object> map) {
		return dao.count(map);
	}
	
	public List<HashMap<String, Object>> list(HashMap<String,Object> map){
		return dao.list(map);
	}
	
	public FilmVo getinfo(int filmNum) {
		return dao.getinfo(filmNum);
	}
	
	public int insert(PurchaseFilmVo vo) {
		return dao.insert(vo);
	}
	
	public List<HashMap<String, Object>> branchList(int branchNum){
		return dao.branchList(branchNum);
	}

}
