package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jhta.project.dao.MScheduleDao;
import com.jhta.project.vo.MScheduleListVo;

@Service
public class MScheduleService {
	private MScheduleDao msDao;
	//��ü ������ ��ȭ��� �����ֱ� ���� ���񽺴�
	public List<MScheduleListVo> showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("serviceŸ��");
		return msDao.showAllMovieSchedule(map);
	}
}
