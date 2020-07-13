package com.jhta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.project.service.FilmService;
import com.jhta.project.vo.PurchaseFilmVo;

@Controller
public class FilmInsertController {
	@Autowired
	private FilmService service;
	
	@RequestMapping(value="/fm/filmbranchlist", method=RequestMethod.POST)
	public String insert(PurchaseFilmVo vo) {
		System.out.println("ddd:"+vo.getFilmDeadline());
		try {
			service.insert(vo);
			System.out.println("����");
			return "fm/filmbranchlist";
		}catch(Exception e) {
			System.out.println("����");
			System.out.println(e.getMessage());
			return "fm/filmlist";
		}
	}
}
