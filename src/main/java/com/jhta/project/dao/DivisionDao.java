package com.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.DivisionVo;


@Repository
public class DivisionDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.division";
	
	public List<DivisionVo> slist() {
		System.out.println("dao");
		return sqlSession.selectList(NAMESPACE+".slist");
	}
}
