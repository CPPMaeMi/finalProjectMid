package com.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.StaffTypeVo;


@Repository
public class StaffTypeDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.stafftype";
	
	public List<StaffTypeVo> slist() {
		System.out.println("dao");
		return sqlSession.selectList(NAMESPACE+".slist");
	}
}
