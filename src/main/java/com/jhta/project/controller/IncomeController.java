package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.project.service.RevenuService;
import com.jhta.project.vo.RevenueVo;

@Controller
public class IncomeController {
	@Autowired
	private RevenuService revenuService;
	
	@RequestMapping("/sales/dateSalesInfo.do")
	public String dateSalesInfo() {
		return ".sales.dateSalesInfo";
	}
	//일별
	@RequestMapping("/sales/dayList.do")
	@ResponseBody
	public List<RevenueVo> dayList(String date,String date1) {
		System.out.println("date------"+date);
		System.out.println("date1------"+date1);
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("date", date);
		map.put("date1", date1);
		return revenuService.dayList(map);
	}
	//월별
	@RequestMapping("/sales/monthList.do")
	@ResponseBody
	public List<RevenueVo> monthList(String date,String date1) {
		System.out.println("date------"+date);
		System.out.println("date1------"+date1);
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("date", date);
		map.put("date1", date1);
		return revenuService.monthList(map);
	}
	//년도별
	@RequestMapping("/sales/yearList.do")
	@ResponseBody
	public List<RevenueVo> yearList(String date,String date1) {
		System.out.println("date------"+date);
		System.out.println("date1------"+date1);
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("date", date);
		map.put("date1", date1);
		return revenuService.yearList(map);
	}
	
}
