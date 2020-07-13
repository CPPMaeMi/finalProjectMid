package com.jhta.project.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.WSListVo;

@Controller
public class SchedulerController {
	@Autowired
	private RestService service;
	
	
	@RequestMapping("/schedule/scheduler.do")
	public String schedule() {
		return ".schedule.scheduler";
	}
	
	@RequestMapping("/schedule/slist.do")
	@ResponseBody
	public String slist(String workDate) {
		String url = "http://localhost:9090/projectdb/schedule/slist.do?workDate="+workDate;
		String code = service.get(url).trim();
		//Gson gson = new Gson();
		//WSListVo[] array=gson.fromJson(code, WSListVo[].class);
		//List<WSListVo> list=Arrays.asList(array);
		return code;
	}
}
