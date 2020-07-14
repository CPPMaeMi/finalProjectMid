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
	//��ü ������ ��ȭ��� �����ֱ� ���� dao��
	public List<MScheduleListVo> showAllMovieSchedule(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+"getList",map);
	}
}
