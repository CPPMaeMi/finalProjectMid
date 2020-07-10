package com.jhta.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.FilmListDao;
import com.jhta.project.vo.GenreVo;

@Service
public class GenreService {
	@Autowired
	private FilmListDao dao;
	
	public GenreVo getinfo2(int genreNum){
		return dao.getinfo2(genreNum);
	}
}
