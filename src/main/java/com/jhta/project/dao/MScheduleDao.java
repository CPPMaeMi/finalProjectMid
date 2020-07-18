package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.MScheduleListVo;
import com.jhta.project.vo.MScheduleVo;

@Repository
public class MScheduleDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.mschedule";
	//��ü ������ ��ȭ��� �����ֱ� ���� dao��
	public MScheduleListVo showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("daoŸ��");
		return sqlSession.selectOne(NAMESPACE+".getList",map);
	}
	
	//mschedule�� values insert
	public int insert(MScheduleVo vo) {
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
	
	//mschedule �󿵽ð�ǥ ����
	public List<HashMap<String, Object>> list(int branchNum,String regDate) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("branchNum", branchNum);
		map.put("regDate", regDate);
		return sqlSession.selectList(NAMESPACE+".list", map);
	}
	
}
