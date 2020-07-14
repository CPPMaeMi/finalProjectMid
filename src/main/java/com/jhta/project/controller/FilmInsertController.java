package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.project.service.FilmService;
import com.jhta.project.vo.PurchaseFilmVo;

@Controller
public class FilmInsertController {
	@Autowired
	private FilmService service;
	
	@RequestMapping(value="/fm/filminsert.do", method=RequestMethod.POST)
	public String insert(PurchaseFilmVo vo, Model model) {
		System.out.println("ddd:"+vo.getFilmDeadline());
		System.out.println("지점번호-토하는중:"+vo.getBranchNum());
		System.out.println("영화번호-토하는중:"+vo.getFilmNum());
		System.out.println("산날번호-토하는중:"+vo.getPurchaseFilmNum());
		System.out.println("산날-토하는중:"+vo.getPurchaseDate());
		try {
			service.insert(vo);
			System.out.println("성공");
			List<HashMap<String,Object>> branchList=service.branchList(vo.getBranchNum());
			model.addAttribute("branchList", branchList);
			return ".fm.filmbranchlist";
		}catch(Exception e) {
			System.out.println("실패");
			System.out.println(e.getMessage());
			return ".fm.filmlist";
		}
	}
}
