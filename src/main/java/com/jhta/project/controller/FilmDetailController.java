package com.jhta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.project.service.CastService;
import com.jhta.project.service.FilmService;
import com.jhta.project.service.GenreService;
import com.jhta.project.service.MovieImgService;
import com.jhta.project.vo.CastVo;
import com.jhta.project.vo.FilmVo;
import com.jhta.project.vo.GenreVo;
import com.jhta.project.vo.MovieImgVo;

@Controller
public class FilmDetailController {
	@Autowired
	private FilmService service;
	@Autowired
	private CastService service1;
	@Autowired
	private GenreService service2;
	@Autowired
	private MovieImgService service3;
	
	@GetMapping("/fm/filmdetail.do")
	public ModelAndView map(int filmNum, int genreNum) {
		ModelAndView mv=new ModelAndView(".fm.filmdetail");
		FilmVo vo=service.getinfo(filmNum);
		System.out.println("�ʸ����̺����ϴ���:"+vo);
		CastVo vo1=service1.getinfo1(filmNum);
		System.out.println("�ֿ����̺����ϴ���:"+vo1);
		GenreVo vo2=service2.getinfo2(genreNum);
		System.out.println("�帣���̺� ���ϴ���:"+vo2);
		MovieImgVo vo3=service3.getinfo3(filmNum);
		System.out.println("��ȭ�̹������̺���:"+vo3);
		mv.addObject("vo",vo);
		mv.addObject("vo1",vo1);
		mv.addObject("vo2",vo2);
		mv.addObject("vo3",vo3);
		return mv;
		
	}
}



/*System.out.println("111111111111111");
HashMap<String, Object> map=service.full(filmNum);
//map�� ������ ������ ���ư� ������ �������
System.out.println(map);
System.out.println("111111111111111");
//List<HashMap<String,Object>> list=please;
//String a=list.get(0).get("FILMNAME").toString();
//System.out.println("Ȯ��:"+a);
model.addAttribute("list",map);
return ".views.filmlist";
*/
