package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.page.util.PageUtil;
import com.jhta.project.service.RestService;


@Controller
public class FilmListController {
	@Autowired
	private RestService service;
	
	@RequestMapping("/fm/list.do")
	public ModelAndView list(@RequestParam(value="pageNum",defaultValue="1")int pageNum,HttpSession session) throws JsonMappingException, JsonProcessingException {
		int branchNum=(int)session.getServletContext().getAttribute("branchNum");
		ModelAndView mv=new ModelAndView(".fm.filmlist");
		HashMap<String,Object> map=new HashMap<String,Object>();
		String countUrl="http://localhost:9090/projectdb/fm/listCount.do";
		String stotalRowCount =service.get(countUrl).trim();
		int totalRowCount=Integer.parseInt(stotalRowCount);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 10);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("branchNum", branchNum);
		Gson gson=new Gson();
		String jsonString=gson.toJson(map);
		String url="http://localhost:9090/projectdb/fm/list.do";
		String code=service.post(url, jsonString).trim();
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {};
		List<HashMap<String, Object>> o = mapper.readValue(code, typeRef);
		
		mv.addObject("list",o);
		mv.addObject("pu",pu);
		return mv;
	}

}
