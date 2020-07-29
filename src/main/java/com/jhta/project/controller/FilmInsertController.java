package com.jhta.project.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.PurchaseFilmVo;

@Controller
public class FilmInsertController {
	@Autowired
	private RestService service;
	
	@PostMapping("/fm/filminsert.do")
	public String insert(String filmDeadline,int filmNum,HttpSession session, Model model) throws ParseException {
		int branchNum=(int)session.getServletContext().getAttribute("branchNum");
		PurchaseFilmVo vo=new PurchaseFilmVo(0, filmDeadline, null, filmNum, branchNum);
		Gson gson=new Gson();
		String insertUrl="http://localhost:9090/projectdb/fm/insert.do";
		try {
			String jsonString=gson.toJson(vo);
			service.post(insertUrl, jsonString);
			String listUrl="http://localhost:9090/projectdb/fm/filminsert.do?branchNum="+branchNum;
			String code=service.get(listUrl).trim();
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {};
			List<HashMap<String, Object>> o = mapper.readValue(code, typeRef);
			model.addAttribute("branchList", o);
			return ".fm.filmbranchlist";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return ".fm.filmlist";
		}
	}
	
	@GetMapping("/fm/filminserts.do")
	public String allMovieList(Model model,HttpSession session) throws JsonMappingException, JsonProcessingException {
		int branchNum=(int)session.getServletContext().getAttribute("branchNum");
		String listUrl="http://localhost:9090/projectdb/fm/filminsert.do?branchNum="+branchNum;
		String code=service.get(listUrl).trim();
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {};
		List<HashMap<String, Object>> o = mapper.readValue(code, typeRef);
		model.addAttribute("branchList", o);
		return ".fm.filmbranchlist";
		
	}
}
