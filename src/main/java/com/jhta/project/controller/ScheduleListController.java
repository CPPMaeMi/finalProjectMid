package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.project.service.MScheduleService;
import com.jhta.project.service.TheatherService;
import com.jhta.project.vo.MScheduleListVo;
import com.jhta.project.vo.TheatherVo;

@Controller
public class ScheduleListController {
	@Autowired
	private MScheduleService msService;
	@Autowired
	private TheatherService service;
	
	@RequestMapping("/schedule/showScheduleList.do")
	//��ü ������ ��ȭ��� �����ֱ� ���� ��Ʈ�ѷ�
	public String scheduleList(@RequestParam(value="branchNum",defaultValue = "1")int branchNum, String purchasefilmNum, Model model) {
		System.out.println("����������:"+branchNum+","+purchasefilmNum);
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("branchNum", branchNum);
		map.put("purchasefilmNum", purchasefilmNum);
		MScheduleListVo vo=msService.showAllMovieSchedule(map);
		model.addAttribute("vo", vo);
		System.out.println("��������");
		List<TheatherVo> vo1=service.list(branchNum);
		model.addAttribute("vo1", vo1);
		return ".schedule.scheduleInsert";
	}
	

	
	/* �����̰� �Ѱ�~ ���
	public String scheduleList(Model model,@RequestParam(value="purchasefilmNum",defaultValue = "1")int purchasefilmNum,
			@RequestParam(value="theatherNum",defaultValue = "1")int theatherNum) {
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("purchasefilmNum", purchasefilmNum);
		map.put("theatherNum", theatherNum);
		System.out.println("map����"+map);
		PurchaseFilmVo purchaseVo=new PurchaseFilmVo();
		MScheduleListVo msvo=new MScheduleListVo(purchasefilmNum, purchaseDate, filmDeadline, filmNum, branchNum, filmName, filmStory, generName, movieimgUrl);
		//MScheduleListVo mslVo=new MScheduleListVo(purchasefilmNum, null, null, 1, 1, filmName, filmStory, generName, movieimgUrl)
		List<MScheduleListVo> allList=msService.showAllMovieSchedule(map);
		System.out.println("map�� ���� ��峪"+allList);
		model.addAttribute(allList);
		return ".schedule.scheduleInsert";
	*/
		

}



