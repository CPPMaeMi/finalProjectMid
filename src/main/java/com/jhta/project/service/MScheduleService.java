package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhta.project.dao.MScheduleDao;
import com.jhta.project.vo.MScheduleListVo;
import com.jhta.project.vo.MScheduleVo;

@Service
public class MScheduleService {
	@Autowired
	private MScheduleDao msDao;
	//전체 구매한 영화목록 보여주기 위한 서비스단
	public List<MScheduleListVo> showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("service타기");
		return msDao.showAllMovieSchedule(map);
	}
	
	public int insert(MScheduleVo vo) {
		return msDao.insert(vo);
	}
}
