package com.jhta.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
import com.jhta.project.vo.MScheduleInsertVo;

@Controller
public class ScheduleInsertController {
	@Autowired
	private RestService service;
	
	@PostMapping("/schedule/scheduleInsert.do")
	public String insert(int[] theatherNum, String date, String time, int purchasefilmNum, String filmDeadline, int branchNum, Model model) {
		Gson gson=new Gson();
		try {
			MScheduleInsertVo vo=new MScheduleInsertVo(theatherNum, date, time, purchasefilmNum, filmDeadline);
			String insertUrl="http://localhost:9090/projectdb/schedule/scheduleinsert.do";
			String jsonString=gson.toJson(vo);
			service.post(insertUrl, jsonString).trim();
			String listUrl="http://localhost:9090/projectdb/schedule/list.do?branchNum="+branchNum+"&date="+date;
			String code=service.get(listUrl).trim();
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {};
			List<HashMap<String, Object>> list = mapper.readValue(code, typeRef);
			String scountUrl="http://localhost:9090/projectdb/schedule/scount.do?branchNum="+branchNum;
			String code1=service.get(scountUrl).trim();
			List<HashMap<String, Object>> sCount = mapper.readValue(code1, typeRef);
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);
			String prevDate=sf.format(sf.parse(date).getTime()-1000*60*60*24); 
			model.addAttribute("prevDate",prevDate);
			model.addAttribute("scount", sCount);
			model.addAttribute("list", list);
			model.addAttribute("weeklist",week(date));
			return ".schedule.schedulers";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
	}
	
	@GetMapping("/schedule/scheduleInsert.do") 
	public String scheduleList(int branchNum, Model model,String regDate) throws ParseException, JsonMappingException, JsonProcessingException {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);
		Date date = new Date();
		String regD=sf.format(date);
		if(regDate==null) regDate=regD;
		String listUrl="http://localhost:9090/projectdb/schedule/list.do?branchNum="+branchNum+"&date="+regDate;
		String code=service.get(listUrl).trim();
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {};
		List<HashMap<String, Object>> list = mapper.readValue(code, typeRef);
		String scountUrl="http://localhost:9090/projectdb/schedule/scount.do?branchNum="+branchNum;
		String code1=service.get(scountUrl).trim();
		List<HashMap<String, Object>> sCount = mapper.readValue(code1, typeRef);
		String prevDate=sf.format(sf.parse(regDate).getTime()-1000*60*60*24); 
		model.addAttribute("prevDate",prevDate);
		model.addAttribute("scount", sCount);
		model.addAttribute("list", list);
		model.addAttribute("weeklist",week(regDate));
		return ".schedule.schedulers";
	}
	
	
	public List<String> week(String regDate) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(regDate);
		List<String> weeklist=new ArrayList<String>();
		for(int i=0;i<7;i++) {
			String day=sdf.format(d.getTime()+1000*60*60*24*i);
			weeklist.add(day);
		}
		return weeklist;
	}
}
