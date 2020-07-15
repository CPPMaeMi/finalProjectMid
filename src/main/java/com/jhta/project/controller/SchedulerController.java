package com.jhta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.WSModalistOkVo;

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
			System.out.println("场");
		}
		return code;
	}
	
	@RequestMapping(value="/schedule/modalist.do",produces={MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String modalist(String workDate) {
		String url = "http://localhost:9090/projectdb/schedule/modalist.do?workDate="+workDate;
		String code = "fail";
		try {
			code = service.get(url).trim();
			System.out.println("胶纳领:"+code);
		}catch (NullPointerException e) {
			System.out.println("场");
		}
		return code;
	}
	
	@RequestMapping(value="/schedule/modalistOk.do",produces={MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String modalistOk(int[] namecheck,String startime,String endtime, String workDate) {
		System.out.println("mid 盀");
		String url="http://localhost:9090/projectdb/schedule/modalistOk.do";
		WSModalistOkVo vo = new WSModalistOkVo(namecheck, startime, endtime, workDate);
		Gson gson = new Gson();
		String jsonString = gson.toJson(vo);
		System.out.println(jsonString);
		String code = service.post(url, jsonString).trim();
		return code;
	}
	
	@RequestMapping(value="/schedule/update.do",produces={MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String update(int snum,String workDate) {
		String url="http://localhost:9090/projectdb/schedule/update.do?sNum="+snum;
		String code = service.get(url).trim();
		if(code.equals("success")) {
			String url1 = "http://localhost:9090/projectdb/schedule/slist.do?workDate="+workDate;
			System.out.println(workDate);
			String code1="fail";
			try {
				code1 = service.get(url1).trim();
			}catch (NullPointerException e) {
				System.out.println("场");
			}
			return code1;
		}else {
			return null;
		}
	}
}
