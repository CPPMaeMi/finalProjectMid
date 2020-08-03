package com.jhta.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.jhta.project.service.RestService;

@Controller
public class IncomeController {
	@Autowired
	private RestService service;
	
	//기간별 조회
	@RequestMapping("/sales/dateSalesInfo.do")
	public String dateSalesInfo() {
		return ".sales.dateSalesInfo";
	}
	//기간별 매출조회 일별
	@RequestMapping(value="/sales/dayList.do",method=RequestMethod.GET)
	@ResponseBody
	public String dayList(String date,String date1,HttpSession session) throws JsonEOFException{
		String brName= (String)session.getServletContext().getAttribute("brName");
		String url ="http://localhost:9090/projectdb/sales/dayList.do?date="+date+"&date1="+date1+"&brName="+brName;
		String code = service.get(url).trim();
		return code;
	}
	
	//기간별 매출조회 월별
	@RequestMapping(value="/sales/monthList.do",method=RequestMethod.GET)
	@ResponseBody
	public String monthList(String date,String date1,HttpSession session) throws JsonEOFException{
		String brName= (String)session.getServletContext().getAttribute("brName");
		String url ="http://localhost:9090/projectdb/sales/monthList.do?date="+date+"&date1="+date1+"&brName="+brName;
		String code = service.get(url).trim();
		return code;
	}
	//기간별 매출조회 년도별
	@RequestMapping(value="/sales/yearList.do",method=RequestMethod.GET)
	@ResponseBody
	public String yearList(String date,String date1,HttpSession session) throws JsonEOFException{
		String brName= (String)session.getServletContext().getAttribute("brName");
		String url ="http://localhost:9090/projectdb/sales/yearList.do?date="+date+"&date1="+date1+"&brName="+brName;
		String code = service.get(url).trim();
		return code;
	}
	
	
	//성별 조회
	@RequestMapping("/sales/genderInfo.do")
	public String genderInfo(Model model) {
		return ".sales.gender";
	}
	
	 //성별 매출조회 년도별
	 @RequestMapping(value="/sales/gender/yearList.do",method=RequestMethod.GET)
	 @ResponseBody
	 public String genderYearList(String date,String date1,HttpSession session) throws JsonEOFException{
		String brName= (String)session.getServletContext().getAttribute("brName");
		String url ="http://localhost:9090/projectdb/sales/gender/yearList.do?date="+date+"&date1="+date1+"&brName="+brName;
		String code = service.get(url).trim();
		return code;
	 } 
	 //성별 매출조회 월별
	 @RequestMapping(value="/sales/gender/monthList.do",method=RequestMethod.GET)
	 @ResponseBody
	 public String genderMonthList(String date,String date1,HttpSession session) throws JsonEOFException{ 
		String brName= (String)session.getServletContext().getAttribute("brName");
		String url ="http://localhost:9090/projectdb/sales/gender/monthList.do?date="+date+"&date1="+date1+"&brName="+brName;
		String code = service.get(url).trim();
		return code;
	 }
	 
	 
	 
	 //연령별 조회
	 @RequestMapping("/sales/ageInfo.do")
		public String ageInfo(Model model) {
			return ".sales.age";
		}
	 
	 //연령별 매출조회 년도별
	 @RequestMapping(value="/sales/age/yearList.do",method=RequestMethod.GET)
	 @ResponseBody
	 public String ageYearList(String date,String date1,HttpSession session)  throws JsonEOFException{
		String brName= (String)session.getServletContext().getAttribute("brName");
		String url ="http://localhost:9090/projectdb/sales/age/yearList.do?date="+date+"&date1="+date1+"&brName="+brName;
		String code = service.get(url).trim();
		return code;
	 } 
	 //연령별 매출조회 월별
	 @RequestMapping(value="/sales/age/monthList.do",method=RequestMethod.GET)
	 @ResponseBody
	 public String ageMonthList(String date,String date1,HttpSession session)  throws JsonEOFException{
		String brName= (String)session.getServletContext().getAttribute("brName");
		String url ="http://localhost:9090/projectdb/sales/age/monthList.do?date="+date+"&date1="+date1+"&brName="+brName;
		String code = service.get(url).trim();
		return code;
	 }
}










