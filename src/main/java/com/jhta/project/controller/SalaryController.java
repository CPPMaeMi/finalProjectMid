package com.jhta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.project.service.RestService;

@Controller
public class SalaryController {
	
	@Autowired
	private RestService service;
	
	@RequestMapping("/salary/saManagement.do")
	public String goSalaryManagement() {
		
		return ".salary.salary";
	}
	
}
