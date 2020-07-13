package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.WScheduleDao;
import com.jhta.project.vo.WScheduleVo;
@Service
public class WScheduleService {
	@Autowired
	private WScheduleDao wScheduleDao;
	public List<WScheduleVo> slist() {
		List<WScheduleVo> list = wScheduleDao.slist();
		System.out.println("service:"+list);
		return list;
	}
}
