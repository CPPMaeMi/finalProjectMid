package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.FilmListDao;
import com.jhta.project.vo.MovieImgVo;

@Service
public class MovieImgService {
	@Autowired
	private FilmListDao dao;
	
	public MovieImgVo getinfo3(int filmNum) {
		return dao.getinfo3(filmNum);
	}
	
	public List<MovieImgVo> list3(HashMap<String,Object> map) {
		return dao.list3(map);
	}
}
