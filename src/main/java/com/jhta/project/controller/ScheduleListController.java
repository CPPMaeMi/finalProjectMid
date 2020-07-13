package com.jhta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.project.service.RestService;

@Controller
public class ScheduleListController {

	@Autowired
	private RestService service;
	
	@RequestMapping("/schedule.showScheduleList")
	public String scheduleList(Model model,@RequestParam(value="purchasefilmNum",defaultValue = "1")int purchasefilmNum) {
		
		return ".schedule.scheduleInsert";
	}
}
