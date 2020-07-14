package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jhta.project.dao.MScheduleDao;
import com.jhta.project.vo.MScheduleListVo;

@Service
public class MScheduleService {
	private MScheduleDao msDao;
	//전체 구매한 영화목록 보여주기 위한 서비스단
	public List<MScheduleListVo> showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("service타기");
		return msDao.showAllMovieSchedule(map);
	}
}
