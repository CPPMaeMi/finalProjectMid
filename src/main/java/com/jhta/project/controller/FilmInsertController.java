package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.project.service.FilmService;
import com.jhta.project.vo.PurchaseFilmVo;

@Controller
public class FilmInsertController {
	@Autowired
	private FilmService service;
	
	@RequestMapping(value="/fm/filminsert.do", method=RequestMethod.POST)
	public String insert(PurchaseFilmVo vo, Model model) {
		System.out.println("ddd:"+vo.getFilmDeadline());
		System.out.println("������ȣ-���ϴ���:"+vo.getBranchNum());
		System.out.println("��ȭ��ȣ-���ϴ���:"+vo.getFilmNum());
		System.out.println("�곯��ȣ-���ϴ���:"+vo.getPurchaseFilmNum());
		System.out.println("�곯-���ϴ���:"+vo.getPurchaseDate());
		try {
			service.insert(vo);
			System.out.println("����");
			List<HashMap<String,Object>> branchList=service.branchList(vo.getBranchNum());
			model.addAttribute("branchList", branchList);
			return ".fm.filmbranchlist";
		}catch(Exception e) {
			System.out.println("����");
			System.out.println(e.getMessage());
			return ".fm.filmlist";
		}
	}
}
