package com.jhta.project.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.TheatherVo;

@Repository
public class TheatherDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.theather";
	
	public List<TheatherVo> list(int branchNum){
		return sqlSession.selectList(NAMESPACE+".list", branchNum);
	}
	
}
