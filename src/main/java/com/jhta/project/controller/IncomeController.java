package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.project.service.ChargeService;
import com.jhta.project.service.RevenuService;
import com.jhta.project.vo.ChargeVo;
import com.jhta.project.vo.RevenueVo;

@Controller
public class IncomeController {
	@Autowired
	private RevenuService revenuService;
	@Autowired
	private ChargeService chargeService;
	
	@RequestMapping("/sales/dateSalesInfo.do")
	public String dateSalesInfo() {
		return ".sales.dateSalesInfo";
	}
	//기간별 매출조회 일별
	@RequestMapping("/sales/dayList.do")
	@ResponseBody
	public List<RevenueVo> dayList(String date,String date1) {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("date", date);
		map.put("date1", date1);
		return revenuService.dayList(map);
	}
	//기간별 매출조회 월별
	@RequestMapping("/sales/monthList.do")
	@ResponseBody
	public List<RevenueVo> monthList(String date,String date1) {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("date", date);
		map.put("date1", date1);
		return revenuService.monthList(map);
	}
	//기간별 매출조회 년도별
	@RequestMapping("/sales/yearList.do")
	@ResponseBody
	public List<RevenueVo> yearList(String date,String date1) {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("date", date);
		map.put("date1", date1);
		return revenuService.yearList(map);
	}
	
	@RequestMapping("/sales/genderInfo.do")
	public String genderInfo(Model model) {
		return ".sales.gender";
	}
	
	 //성별 매출조회 년도별
	 @RequestMapping("/sales/gender/yearList.do")
	 @ResponseBody public List<ChargeVo> genderYearList(String date,String date1){
		 HashMap<String, String> map=new HashMap<String, String>(); 
		 map.put("date", date); 
		 map.put("date1", date1);
		 return chargeService.yearList(map); 
	 } 
	 //성별 매출조회 월별
	 @RequestMapping("/sales/gender/monthList.do")
	 @ResponseBody public List<ChargeVo> genderMonthList(String date,String date1){ 
		 HashMap<String, String>map=new HashMap<String, String>();
		 map.put("date", date); map.put("date1", date1); 
		 
		 List<ChargeVo> resultList = chargeService.monthList(map); 
		 
		 HashMap<String, Object> resultMap = new HashMap<String, Object>();
		 for(ChargeVo vo: resultList) {
			 if(resultMap.containsKey(vo.getChRegdate())) {
				 resultMap.put(key, value)
			 }
		 }
		 
		 
		 
		 return resultList;
	 }
}










