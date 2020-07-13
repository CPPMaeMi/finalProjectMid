package com.jhta.project.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MScheduleDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE "com.jhta.mybatis.mapper.mschedule";
	public List<MScheduleListVo> showAllMovieSchedule(HashMap<String, Object> map){
		return sqlSession.selectList(statement)(map);
	}
}
