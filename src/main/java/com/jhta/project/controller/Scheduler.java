package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.project.service.MScheduleService;

@Controller
public class Scheduler {
	@Autowired
	private MScheduleService service;
	
	@RequestMapping("/schedule/scheduler.do")
	public String list(@RequestParam(value="branchNum",defaultValue="1")int branchNum, Model model){
		List<HashMap<String, Object>> list=service.list(branchNum);
		model.addAttribute("list", list);
		return ".schedule.scheduler";
	}
}
