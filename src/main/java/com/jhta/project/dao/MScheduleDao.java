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
	//전체 구매한 영화목록 보여주기 위한 dao단
	public MScheduleListVo showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("dao타기");
		return sqlSession.selectOne(NAMESPACE+".getList",map);
	}
	
	//mschedule에 values insert
	public int insert(MScheduleVo vo) {
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
	
	//mschedule 상영시간표 노출
	public List<HashMap<String, Object>> list(int branchNum) {
		return sqlSession.selectList(NAMESPACE+".list", branchNum);
	}
	
}
