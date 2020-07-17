package com.jhta.project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.project.service.MScheduleService;

@Controller
public class ScheduleInsertController {
	@Autowired
	private MScheduleService service;
	
	@PostMapping("/schedule/scheduleInsert.do")
	public String insert(int[] theatherNum, String date, String time, int purchasefilmNum, @DateTimeFormat(pattern="yyyy-MM-dd")Date filmDeadline, int branchNum, Model model) {
		System.out.println("야 이거먼데"+filmDeadline);
		System.out.println(branchNum);
		try {
			service.insert(theatherNum, date, time, purchasefilmNum, filmDeadline);
//			System.out.println(theatherNum);
			System.out.println("된...다...");
			System.out.println("service:" + service );
			List<HashMap<String,Object>> list=service.list(branchNum);
//			System.out.println("아무래도 재시험:"+list.get(0).get("PURCHASEFILMNUM"));
//			ArrayList<Integer> purList=new ArrayList<Integer>();
//			for(HashMap<String, Object> i:list) {
//				int purNum=Integer.parseInt(i.get("PURCHASEFILMNUM").toString());
//				purList.add(purNum);
//			}
			model.addAttribute("list", list);
			
			return ".schedule.scheduler";
		}catch(Exception e) {
			System.out.println("영화관 파산");
			System.out.println(e.getMessage());
			return ".schedule.scheduler";
		}
	}
	
	@GetMapping("/schedule/scheduleInsert.do") 
	public String scheduleList(int branchNum, Model model) {
		List<HashMap<String,Object>> list=service.list(branchNum);
		model.addAttribute("list", list);
		return ".schedule.scheduler";
	}
}
