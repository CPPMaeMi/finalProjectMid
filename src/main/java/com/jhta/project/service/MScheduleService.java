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
	//��ü ������ ��ȭ��� �����ֱ� ���� ���񽺴�
	public MScheduleListVo showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("serviceŸ��");
		return msDao.showAllMovieSchedule(map);
	}
	
	//insert�� ��� list�� ���̱�
	public List<HashMap<String, Object>> list(int branchNum,String regDate){
		return msDao.list(branchNum,regDate);
	}
	
	//��ȭ�� ��ȭ����, Date�� ���ÿ� insert�ϱ�
	@Transactional
	public int insert(int[] theatherNum, String date, String time, int purchasefilmNum, Date filmDeadline) {
		int n=0;
		for(int i=0;i<theatherNum.length;i++) {
			//dateŸ�� string���� ��ȯ...
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			String film=df.format(filmDeadline);
			
			//�󿵿�û�� ��¥
			String[] day=date.split("-"); // [0]�⵵--[1]��--[2]��
			System.out.println(day[0]);
			int days=Integer.parseInt(day[2]);
			System.out.println("���� ��¥:"+days);
			
			//�� �����ϴ� ��¥
			String[] dead=film.split("-"); //[0]�⵵--[1]��--[2]��
			int die=Integer.parseInt(dead[2]);
			System.out.println("������ ��¥:"+die);
			
			//���Ե� �ð� �޼ҵ�
			for(;days<=die;) {
				String[] timer=time.split(":"); //[0] �ð� [1] ��
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
