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
	
	//insert한 결과 list로 보이기
	public List<HashMap<String, Object>> list(int branchNum){
		return msDao.list(branchNum);
	}
	
	//영화를 영화관별, Date별 동시에 insert하기
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
			for(;days<=die;) {
				String[] timer=time.split(":"); //[0] 시간 [1] 분
				int timers=Integer.parseInt(timer[0]);
				while(timers<=23) {
					String startTime=day[0]+"/"+day[1]+"/"+days+" "+timers+":"+timer[1];
					MScheduleVo vo1=new MScheduleVo(0, startTime, theatherNum[i], purchasefilmNum);
					//Date d=new Date(Integer.parseInt(day[0]),Integer.parseInt(day[1]),days,timers,Integer.parseInt(timer[1]));
					//vo1.setD(d);
					n+=msDao.insert(vo1);
					timers += 4;
				}
				days += 1;
			}
		}
		return n;
	}
}
