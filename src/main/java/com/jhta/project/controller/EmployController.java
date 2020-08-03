package com.jhta.project.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.page.util.PageUtil;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.DivisionVo;
import com.jhta.project.vo.StaffTypeVo;
import com.jhta.project.vo.StaffVo;

@Controller
public class EmployController {
	
	@Autowired
	private RestService service;
	
	@RequestMapping("/employee/emInsert.do")
	public String goEmployeeInsert(Model model) 
			throws JsonProcessingException {
		
		String getSffPositionUrl = "http://localhost:9090/projectdb/employee/getSffPosition.do";
		String getDivisionNameUrl = "http://localhost:9090/projectdb/employee/getDivisionName.do";
		Gson gson=new Gson();
		String getSffPosition = service.get(getSffPositionUrl).trim();
		List<StaffTypeVo> sfList = Arrays.asList(gson.fromJson(getSffPosition,StaffTypeVo[].class));
		String getDivisionName = service.get(getDivisionNameUrl).trim();
		List<DivisionVo> diList = Arrays.asList(gson.fromJson(getDivisionName,DivisionVo[].class));
		model.addAttribute("sfList",sfList);
		model.addAttribute("diList",diList);
		return ".employee.emInsert";
	}
	
	@RequestMapping("/employee/emInsertOk.do")
	public String EmployeeInsertOk(String branchNum,String sffStatus,
			String sffName,String sffAge,String sffAddr,
			String jumin,String gender,String accountNum,String sffNum,
			String divisionNum,Model model) throws JsonProcessingException {
		StaffVo vo = new StaffVo(0,Integer.parseInt(sffNum),Integer.parseInt(divisionNum),sffName,sffAge,sffAddr,
				jumin,gender,Integer.parseInt(accountNum),sffStatus,Integer.parseInt(branchNum));
		String insertUrl = "http://localhost:9090/projectdb/employee/staffInsert.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(vo);
		String code=service.post(insertUrl,jsonString).trim();
		model.addAttribute("code",code);
		model.addAttribute("sffName",vo.getSffName());
		return ".employee.emInsertOk";
	}
	
	@RequestMapping("/employee/emUpdateOk.do")
	public String EmployeeUpdateOk(Model model,String staffNum,
			String account,String status,
			String divisionNum,String sffNum,String addr) throws JsonProcessingException {
		String updateUrl = "http://localhost:9090/projectdb/employee/staffUpdate.do";
		ObjectMapper mapper=new ObjectMapper();
		StaffVo vo = new StaffVo(Integer.parseInt(staffNum),Integer.parseInt(sffNum),Integer.parseInt(divisionNum),null,null,addr,null,null,Integer.parseInt(account),status,0);
		String jsonString= mapper.writeValueAsString(vo);
		String code=service.post(updateUrl,jsonString).trim();
		model.addAttribute("code2",code);
		model.addAttribute("sffName",vo.getSffName());
		return ".employee.emInsertOk";
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
