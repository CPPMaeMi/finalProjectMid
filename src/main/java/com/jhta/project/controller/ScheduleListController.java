package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.project.service.MScheduleService;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.MScheduleListVo;

@Controller
public class ScheduleListController {

	@Autowired
	private RestService service;
	private MScheduleService msService;
	@RequestMapping("/schedule.showScheduleList")
	//전체 구매한 영화목록 보여주기 위한 컨트롤러
	public String scheduleList(Model model,@RequestParam(value="purchasefilmNum",defaultValue = "1")int purchasefilmNum,
			@RequestParam(value="theatherNum",defaultValue = "1")int theatherNum) {
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("purchasefilmNum", purchasefilmNum);
		map.put("theatherNum", theatherNum);
		List<MScheduleListVo> allmap=msService.showAllMovieSchedule(map);
		model.addAttribute(allmap);
		return ".schedule.scheduleInsert";
	}
}
