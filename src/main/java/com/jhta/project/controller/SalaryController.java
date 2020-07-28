package com.jhta.project.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.project.service.RestService;


@Controller
public class SalaryController {
	
	@Autowired
	private RestService service;
	
	@RequestMapping("/salary/saManagement.do")
	public String goSalaryManagement(Model model) throws JsonProcessingException {
		String url = "http://localhost:9090/projectdb/salary/saManagement.do";
		HashMap<String,Object> map = new HashMap<String,Object>();
		ObjectMapper mapper = new ObjectMapper();
		Gson gson=new Gson();
		//시작기간 끝 기간 받아서 넘기기
		map.put("","");
		map.put("","");
		String sString = mapper.writeValueAsString(map);
		String slist = service.post(url,sString).trim();
		TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {};
		List<HashMap<String, Object>> list = mapper.readValue(slist, typeRef);
		model.addAttribute("list",list);
		return ".salary.salary";
	}
	
}
