package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.DivisionDao;
import com.jhta.project.vo.DivisionVo;
@Service
public class DivisionService {
	@Autowired
	private DivisionDao sivisionDao;
	public List<DivisionVo> slist() {
		List<DivisionVo> list = sivisionDao.slist();
		System.out.println("service:"+list);
		return list;
	}
}
