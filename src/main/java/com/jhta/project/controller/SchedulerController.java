package com.jhta.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SchedulerController {
	
	@RequestMapping("/schedule/scheduler.do")
	public String schedule() {
		return ".schedule.scheduler";
	}
}
