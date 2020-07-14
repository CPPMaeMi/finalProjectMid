package com.jhta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.project.service.RestService;

@Controller
public class SchedulerController {
	@Autowired
	private RestService service;
	
	
	@RequestMapping("/schedule/scheduler.do")
	public String schedule() {
		return ".schedule.scheduler";
	}
	
	@RequestMapping(value="/schedule/slist.do",produces={MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String slist(String workDate) {
		System.out.println(workDate);
		String url = "http://localhost:9090/projectdb/schedule/slist.do?workDate="+workDate;
		System.out.println(workDate);
		String code="fail";
		try {
			code = service.get(url).trim();
		}catch (NullPointerException e) {
			System.out.println("≥°");
		}
		return code;
	}
	
	@RequestMapping(value="/schedule/sadd.do",produces={MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String sadd(@RequestParam(value="branchNum",defaultValue = "1")int branchNum) {
		String url = "http://localhost:9090/projectdb/schedule/sadd.do?branchNum="+branchNum;
		String code = "fail";
		try {
			code = service.get(url).trim();
			System.out.println("Ω∫ƒ…¡Ï:"+code);
		}catch (NullPointerException e) {
			System.out.println("≥°");
		}
		return code;
	}
}
