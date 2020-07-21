package com.jhta.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.project.service.MScheduleService;

@Controller
public class ScheduleInsertController {
	@Autowired
	private MScheduleService service;
	
	@PostMapping("/schedule/scheduleInsert.do")
	public String insert(int[] theatherNum, String date, String time, int purchasefilmNum, @DateTimeFormat(pattern="yyyy-MM-dd")Date filmDeadline, int branchNum, Model model) {
		try {
			System.out.println("얍");
			service.insert(theatherNum, date, time, purchasefilmNum, filmDeadline);
			System.out.println("아오");
			List<HashMap<String,Object>> list=service.list(branchNum,date);
			System.out.println("ㅇ어헣ㅇ");
			//List<HashMap<String,Object>> seatCount=new ArrayList<HashMap<String,Object>>();
			System.out.println("ㅎㅇ후홓아");
			List<HashMap<String,Object>> sCount=service.scount(branchNum);
			model.addAttribute("scount", sCount);
			model.addAttribute("list", list);
			model.addAttribute("weeklist",week(date));
			return ".schedule.scheduler";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
	}
	
	@GetMapping("/schedule/scheduleInsert.do") 
	public String scheduleList(int branchNum, Model model,String regDate) throws ParseException {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);
		Date date = new Date();
		String regD=sf.format(date);
		if(regDate==null) regDate=regD;
		List<HashMap<String,Object>> list=service.list(branchNum,regDate);
		System.out.println("여기지금 schedulinsert컨트롤러임:"+list.toString());
		List<HashMap<String,Object>> sCount=service.scount(branchNum);
		System.out.println("ㅎㅇ후홓아");
		model.addAttribute("scount", sCount);
		System.out.println("강아지"+list.toString());
		model.addAttribute("list", list);
		model.addAttribute("weeklist",week(regDate));
		return ".schedule.scheduler";
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
