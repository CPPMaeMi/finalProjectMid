package com.jhta.project.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.project.dao.MScheduleDao;
import com.jhta.project.vo.MScheduleListVo;
import com.jhta.project.vo.MScheduleVo;

@Service
public class MScheduleService {
	@Autowired
	private MScheduleDao msDao;
	//전체 구매한 영화목록 보여주기 위한 서비스단
	public MScheduleListVo showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("service타기");
		return msDao.showAllMovieSchedule(map);
	}
	
	public List<HashMap<String, Object>> list(int branchNum){
		return msDao.list(branchNum);
	}
	
	@Transactional
	public int insert(int[] theatherNum, String date, String time, int purchasefilmNum, Date filmDeadline) {
		int n=0;
		for(int i=0;i<theatherNum.length;i++) {
			//date타입 string으로 변환...
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			String film=df.format(filmDeadline);
			
			//상영요청한 날짜
			String[] day=date.split("-"); // [0]년도--[1]월--[2]일
			System.out.println(day[0]);
			int days=Integer.parseInt(day[2]);
			System.out.println("상영할 날짜:"+days);
			
			//상영 종료하는 날짜
			String[] dead=film.split("-"); //[0]년도--[1]월--[2]일
			int die=Integer.parseInt(dead[2]);
			System.out.println("종료할 날짜:"+die);
			
			//삽입될 시간 메소드
			for(int j=0;days<=die;j++) {
				String[] timer=time.split(":"); //[0] 시간 [1] 분
				int timers=Integer.parseInt(timer[0]);
				while(timers<=20) {
					String startTime=date+" "+timers+":"+timer[1];
					MScheduleVo vo1=new MScheduleVo(0, startTime, theatherNum[i], purchasefilmNum);
					Date d=new Date(filmDeadline.getYear(),filmDeadline.getMonth(),Integer.parseInt(day[2]),Integer.parseInt(timer[0]),Integer.parseInt(timer[1]));
					d.setDate(days);
					d.setHours(timers);
					vo1.setD(d);
					n+=msDao.insert(vo1);
					timers += 4;
					days += 1;
					
				}
			}
		}
		return n;
	}
}
