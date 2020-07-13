package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.StaffTypeDao;
import com.jhta.project.vo.StaffTypeVo;
@Service
public class StaffService {
	@Autowired
	private StaffTypeDao staffTypeDao;
	public List<StaffTypeVo> slist() {
		List<StaffTypeVo> list = staffTypeDao.slist();
		System.out.println("service:"+list);
		return list;
	}
}
