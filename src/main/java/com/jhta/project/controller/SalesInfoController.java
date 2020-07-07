package com.jhta.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SalesInfoController {
	@RequestMapping("/sales/dateSalesInfo.do")
	public String dateSalesInfo() {
		return ".sales.dateSalesInfo";
	}
}
