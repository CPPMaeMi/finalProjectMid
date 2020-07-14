package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.ChargeVo;

@Repository
public class ChargeDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.charge";
	
	//성별 년도별 매출조회
	public List<ChargeVo> genderYearList(HashMap<String, String> map){
		return sqlSession.selectList(NAMESPACE+".genderYearList", map);
	}
	//성별 월별 매출조회
	public List<ChargeVo> genderMonthList(HashMap<String, String> map){
		return sqlSession.selectList(NAMESPACE+".genderMonthList", map); 
	}
	//연령별 년도별 매출조회
	public List<ChargeVo> ageYearList(HashMap<String, String> map){
		return sqlSession.selectList(NAMESPACE+".ageYearList", map);
	}
	//연령별 월별 매출조회
	public List<ChargeVo> ageMonthList(HashMap<String, String> map){
		return sqlSession.selectList(NAMESPACE+".ageMonthList", map); 
	}
}
