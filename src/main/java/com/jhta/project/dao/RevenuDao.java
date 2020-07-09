package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.RevenueVo;

@Repository
public class RevenuDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.revenue";
	public List<RevenueVo> monthList(HashMap<String, String> map){
		return sqlSession.selectList(NAMESPACE+".monthList",map);
	}
	public List<RevenueVo> dayList(HashMap<String, String> map){
		return sqlSession.selectList(NAMESPACE+".dayList",map);
	}
	public List<RevenueVo> yearList(HashMap<String, String> map){
		return sqlSession.selectList(NAMESPACE+".yearList",map);
	}
}
