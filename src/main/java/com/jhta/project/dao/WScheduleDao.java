package com.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.WScheduleVo;


@Repository
public class WScheduleDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.wschedule";
	
	public List<WScheduleVo> slist() {
		System.out.println("dao");
		return sqlSession.selectList(NAMESPACE+".slist");
	}
}
