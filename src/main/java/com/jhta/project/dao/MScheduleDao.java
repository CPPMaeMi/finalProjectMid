package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.MScheduleListVo;

@Repository
public class MScheduleDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.mschedule";
	//전체 구매한 영화목록 보여주기 위한 dao단
	public List<MScheduleListVo> showAllMovieSchedule(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+"getList",map);
	}
}
