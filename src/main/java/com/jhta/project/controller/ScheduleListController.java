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
import com.jhta.project.vo.PurchaseFilmVo;

@Controller
public class ScheduleListController {

	@Autowired
	private MScheduleService msService;
	@RequestMapping("/schedule.showScheduleList.do")
	//전체 구매한 영화목록 보여주기 위한 컨트롤러

	public String scheduleList(@RequestParam(value="purchasefilmNum",defaultValue = "1")int purchasefilmNum,
			@RequestParam(value="theatherNum",defaultValue = "1")int branchNum, Model model) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("purchasefilmNum", purchasefilmNum);
		map.put("branchNum", branchNum);
		List<MScheduleListVo> allList=msService.showAllMovieSchedule(map);
		//PurchaseFilmVo purchaseVo=new PurchaseFilmVo();
		//MScheduleListVo vo=new MScheduleListVo(purchasefilmNum, purchaseDate, filmDeadline, filmNum, branchNum, filmName, filmStory, generName, movieimgUrl);
		//MScheduleListVo mslVo=new MScheduleListVo(purchasefilmNum, null, null, 1, 1, filmName, filmStory, generName, movieimgUrl)
		System.out.println("map에 뭐가 담겼나"+allList);
		model.addAttribute(allList);
		return ".schedule.scheduleInsert";
	
	/* 지은이가 한거~ 백업
	public String scheduleList(Model model,@RequestParam(value="purchasefilmNum",defaultValue = "1")int purchasefilmNum,
			@RequestParam(value="theatherNum",defaultValue = "1")int theatherNum) {
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("purchasefilmNum", purchasefilmNum);
		map.put("theatherNum", theatherNum);
		System.out.println("map찍어보기"+map);
		PurchaseFilmVo purchaseVo=new PurchaseFilmVo();
		MScheduleListVo msvo=new MScheduleListVo(purchasefilmNum, purchaseDate, filmDeadline, filmNum, branchNum, filmName, filmStory, generName, movieimgUrl);
		//MScheduleListVo mslVo=new MScheduleListVo(purchasefilmNum, null, null, 1, 1, filmName, filmStory, generName, movieimgUrl)
		List<MScheduleListVo> allList=msService.showAllMovieSchedule(map);
		System.out.println("map에 뭐가 담겼나"+allList);
		model.addAttribute(allList);
		return ".schedule.scheduleInsert";
	*/
		
	}
}



