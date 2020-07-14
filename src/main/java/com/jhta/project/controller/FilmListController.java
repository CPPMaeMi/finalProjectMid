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
		//System.out.println("11111111111111111111");
		HashMap<String,Object> map=new HashMap<String,Object>();
		int totalRowCount=service.count(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 10);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		System.out.println(map);
		//System.out.println("222222222222222222");
		ModelAndView mv=new ModelAndView(".fm.filmlist");
		//System.out.println("333333333333333333");
		List<HashMap<String,Object>> list=service.list(map);
		//System.out.println("444444444444444444");
		//System.out.println("img:"+list.get(1).get("MOVIEIMGURL").toString());
		//System.out.println("num:"+list.get(0));
		
		mv.addObject("list",list);
		mv.addObject("pu",pu);
		
		return mv;
	}

}
