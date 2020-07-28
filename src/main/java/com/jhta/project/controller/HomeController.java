package com.jhta.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.BranchVo;

@Controller
public class HomeController {
	@Autowired
	private RestService service;
	
	private boolean bl=false;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		String cp=session.getServletContext().getContextPath();
		session.getServletContext().setAttribute("cp",cp);
		if(!bl) {
			return "log/login";
		}else {
			return ".main";
		}
	}
	
	@RequestMapping("/log/banchloging.do")
	public String banchloging(HttpSession session, String email, String pass,Model model) {
		String memId = email;
		String memPwd = pass;
		String url="http://localhost:9090/projectdb/log/banchloging.do?memId="+memId+"&memPwd="+memPwd;
		String code = service.get(url).trim();
		System.out.println("code[]:"+code);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
		if(code.equals("")||code.equals(null)) {
			model.addAttribute("msg","아이디 확인바랍니다.");
			return "log/login";
		}else {
			bl=true;
			BranchVo vo= gson.fromJson(code, BranchVo.class);
			session.getServletContext().setAttribute("branchNum",vo.getBranchNum());
			session.getServletContext().setAttribute("brName",vo.getBrName());
			session.getServletContext().setAttribute("brRegdate",vo.getBrRegdate());
			session.getServletContext().setAttribute("branchmemId",vo.getMemId());
			session.getServletContext().setAttribute("proNum",vo.getProNum());
			return ".main";
		}
	}
	
}
