package com.jhta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.CastVo;
import com.jhta.project.vo.FilmVo;
import com.jhta.project.vo.GenreVo;
import com.jhta.project.vo.MovieImgVo;

@Controller
public class FilmDetailController {
	@Autowired
	private RestService service;
	
	@GetMapping(value="/fm/filmdetail.do")
	public ModelAndView map(int filmNum, int buy) {
		ModelAndView mv=new ModelAndView(".fm.filmdetail");
		Gson gson=new Gson();
		String fUrl="http://localhost:9090/projectdb/fm/filmgetInfo.do?filmNum="+filmNum;
		String sfvo=service.get(fUrl).trim();
		FilmVo vo=gson.fromJson(sfvo, FilmVo.class);
		String cUrl="http://localhost:9090/projectdb/fm/castgetInfo.do?filmNum="+filmNum;
		String scvo=service.get(cUrl).trim();
		CastVo vo1=gson.fromJson(scvo, CastVo.class);
		String gUrl="http://localhost:9090/projectdb/fm/genregetInfo.do?genreNum="+vo.getGenreNum();
		String sgvo=service.get(gUrl).trim();
		GenreVo vo2=gson.fromJson(sgvo, GenreVo.class);
		String mUrl="http://localhost:9090/projectdb/fm/mimggetInfo.do?filmNum="+filmNum;
		String imgvo=service.get(mUrl).trim();
		MovieImgVo vo3=gson.fromJson(imgvo, MovieImgVo.class);
		
		
		mv.addObject("vo",vo);
		mv.addObject("vo1",vo1);
		mv.addObject("vo2",vo2);
		mv.addObject("vo3",vo3);
		mv.addObject("buy",buy);
		return mv;
	}
}

