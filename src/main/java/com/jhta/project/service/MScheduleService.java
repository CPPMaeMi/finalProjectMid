package com.jhta.project.service;

import java.text.ParseException;
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

	public MScheduleListVo showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("service타기");
		return msDao.showAllMovieSchedule(map);
	}
	
	//insert한 결과 list로 보이기
	public List<HashMap<String, Object>> list(int branchNum,String regDate){
		return msDao.list(branchNum,regDate);
	}
	
	//좌석 노출
	public List<HashMap<String, Object>> scount(int branchNum) {
		return msDao.scount(branchNum);
	}
	
	
	@Transactional
	public int insert(int[] theatherNum, String date, String time, int purchasefilmNum, Date filmDeadline) throws ParseException {
		System.out.println("들려다오...");
		int n=0;
		for(int i=0;i<theatherNum.length;i++) {
			//date type > string 변환
			
			Date lastDate=new Date(filmDeadline.getTime());
			String from=date+time;
			SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-ddHH:mm");
			Date to=fm.parse(from);
			Date offerDate=new Date(to.getTime());
			
			System.out.println("수치 내놓아보셈:"+offerDate);
			System.out.println("ㅇㅇ엉ㅇ엉어어ㅓ:"+lastDate);
			
			//상영요청한 날짜
			//String[] day=date.split("-"); // [0]년 [1]월--[2]일
			//System.out.println(day[0]);
			//int days=Integer.parseInt(day[2]);
			//System.out.println("상영요청한 날짜:"+days);
			
			//상영종료하는 날짜
			//String[] dead=film.split("-"); //[0]년--[1]월--[2]일
			//int die=Integer.parseInt(dead[2]);
			//System.out.println("상영종료하는 날짜:"+die);
			
			//상영시간
			for(long j=offerDate.getTime();j<=lastDate.getTime();j=j+86400000) {
				String[] timer=time.split(":"); //[0]시 [1]분
				int timers=Integer.parseInt(timer[0]);
				while(timers<=23) {
					SimpleDateFormat fj=new SimpleDateFormat("yyyy-MM-dd");
					String stime=fj.format(j);
					String[] day=stime.split("-");
					int days=Integer.parseInt(day[2]);
					
					String startTime=day[0]+"/"+day[1]+"/"+days+" "+timers+":"+timer[1];
					MScheduleVo vo1=new MScheduleVo(0, startTime, theatherNum[i], purchasefilmNum);
					//Date d=new Date(Integer.parseInt(day[0]),Integer.parseInt(day[1]),days,timers,Integer.parseInt(timer[1]));
					//vo1.setD(d);
					n+=msDao.insert(vo1);
					timers += 4;
				}
			}
		}
		return n;
	}
}
