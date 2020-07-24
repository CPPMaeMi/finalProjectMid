package com.jhta.project.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.MScheduleListVo;
import com.jhta.project.vo.TheatherVo;

@Controller
public class ScheduleListController {
	@Autowired
	private RestService service;
	
	@RequestMapping("/schedule/showScheduleList.do")
	public String scheduleList(@RequestParam(value="branchNum",defaultValue = "1")int branchNum, String purchasefilmNum, Model model) {
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("branchNum", branchNum);
		map.put("purchasefilmNum", purchasefilmNum);
		Gson gson=new Gson();
		String jsonString=gson.toJson(map);
		String showAllurl="http://localhost:9090/projectdb/fm/showAllMovieSchedule.do";
		String smVo=service.post(showAllurl, jsonString).trim();
		MScheduleListVo vo=gson.fromJson(smVo, MScheduleListVo.class);
		model.addAttribute("vo", vo);
		String listUrl="http://localhost:9090/projectdb/fm/theatherlist.do?branchNum="+branchNum;
		String showCode=service.get(listUrl).trim();
		System.out.println("성진아 살려줭:"+showCode);
		TheatherVo[] arrays= gson.fromJson(showCode, TheatherVo[].class);
		List<TheatherVo> vo1=Arrays.asList(arrays);
		model.addAttribute("vo1", vo1);
		return ".schedule.scheduleInsert";
	}

}



