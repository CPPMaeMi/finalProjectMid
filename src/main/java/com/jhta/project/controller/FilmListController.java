package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.page.util.PageUtil;
import com.jhta.project.service.FilmService;


@Controller
public class FilmListController {
	@Autowired
	private FilmService service;
	
	@RequestMapping("/fm/list.do")
	public ModelAndView list(@RequestParam
			(value="pageNum",defaultValue="1")int pageNum) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		int totalRowCount=service.count(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 10);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		ModelAndView mv=new ModelAndView(".fm.filmlist");
		List<HashMap<String,Object>> list=service.list(map);
		mv.addObject("list",list);
		mv.addObject("pu",pu);
		return mv;
	}

}
