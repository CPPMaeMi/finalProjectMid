package com.jhta.project.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.project.service.MScheduleService;

@Controller
public class ScheduleInsertController {
	@Autowired
	private MScheduleService service;
	
	@RequestMapping("/schedule/scheduleInsert.do")
	public String insert(int[] theatherNum, String date, String time, int purchasefilmNum, @DateTimeFormat(pattern="yyyy-MM-dd")Date filmDeadline) {
		System.out.println("�� �̰Ÿյ�"+filmDeadline);
		try {
			service.insert(theatherNum, date, time, purchasefilmNum, filmDeadline);
//			System.out.println(theatherNum);
			System.out.println("��...��...");
			return ".schedule.scheduler";
		}catch(Exception e) {
			System.out.println("��ȭ�� �Ļ�");
			System.out.println(e.getMessage());
			return ".schedule.schedulelist";
		}
	}
		
}
