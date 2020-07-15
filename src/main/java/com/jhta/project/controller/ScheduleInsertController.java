package com.jhta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.project.service.MScheduleService;
import com.jhta.project.vo.MScheduleVo;

@Controller
public class ScheduleInsertController {
	@Autowired
	private MScheduleService service;
	
	@RequestMapping("/schedule/scheduleInsert.do")
	public String insert(MScheduleVo vo, String date, String time) {
		try {
			MScheduleVo vo1=new MScheduleVo(0, date+time, 0, 0);
			service.insert(vo1);
			System.out.println("된...다...");
			return ".schedule.scheduler";
		}catch(Exception e) {
			System.out.println("영화관 파산");
			System.out.println(e.getMessage());
			return ".schedule.schedulelist";
		}
	}
		
}
