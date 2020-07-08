package com.jhta.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.project.service.RevenuService;
import com.jhta.project.vo.RevenueVo;

@Controller
public class IncomeController {
	@Autowired
	private RevenuService revenuService;
	
	@RequestMapping("/sales/dateSalesInfo.do")
	public String dateSalesInfo(Model model) {
		List<RevenueVo> list=revenuService.yearList();
		model.addAttribute("list",list);
		return ".sales.dateSalesInfo";
	}
	
	
}
