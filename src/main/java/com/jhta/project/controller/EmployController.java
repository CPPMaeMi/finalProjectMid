package com.jhta.project.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.page.util.PageUtil;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.QnaVo;

@Controller
public class EmployController {
	
	@Autowired
	private RestService service;
	
	@RequestMapping("/employee/emInsert.do")
	public String goEmployeeInsert() 
			throws JsonProcessingException {
		return ".employee.emInsert";
	}
	
	@RequestMapping("/employee/emSelect.do")
	public String goEmployeeSelect(String[] br,String[] sf,String[] di,Model model,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum) throws JsonProcessingException {
		String countUrl = "http://localhost:9090/projectdb/employee/getCount.do";
		String selectUrl = "http://localhost:9090/projectdb/employee/emSelect.do";
		String getBrNameUrl = "http://localhost:9090/projectdb/employee/getBrName.do";
		String getSffPositionUrl = "http://localhost:9090/projectdb/employee/getSffPosition.do";
		String getDivisionNameUrl = "http://localhost:9090/projectdb/employee/getDivisionName.do";
		HashMap<String,Object> countMap = new HashMap<String,Object>();
		HashMap<String,Object> selectMap = new HashMap<String,Object>();
		ObjectMapper mapper = new ObjectMapper();
		countMap.put("br",br);
		countMap.put("sf",sf);
		countMap.put("di",di);
		selectMap.put("br",br);
		selectMap.put("sf",sf);
		selectMap.put("di",di);
		String countString = mapper.writeValueAsString(countMap);
		String count = service.post(countUrl,countString).trim();
		PageUtil pu = new PageUtil(pageNum,Integer.parseInt(count),10,5);
		selectMap.put("startRow",pu.getStartRow());
		selectMap.put("endRow",pu.getEndRow());
		String selectString = mapper.writeValueAsString(selectMap);
		String slist = service.post(selectUrl,selectString).trim();
		Gson gson=new Gson();
		HashMap<String,Object>[] map = gson.fromJson(slist, HashMap[].class);
		List<HashMap<String,Object>> list=Arrays.asList(map);
		//checkbox 데이터 가져오는 부분
		String getBrName = service.get(getBrNameUrl).trim();
		List<String> brList = Arrays.asList(gson.fromJson(getBrName,String[].class));
		String getSffPosition = service.get(getSffPositionUrl).trim();
		List<String> sfList = Arrays.asList(gson.fromJson(getSffPosition,String[].class));
		String getDivisionName = service.get(getDivisionNameUrl).trim();
		List<String> diList = Arrays.asList(gson.fromJson(getDivisionName,String[].class));
		model.addAttribute("brList",brList);
		model.addAttribute("sfList",sfList);
		model.addAttribute("diList",diList);
		model.addAttribute("br",br);
		model.addAttribute("sf",sf);
		model.addAttribute("di",di);
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		return ".employee.emSelect";
	}
}
