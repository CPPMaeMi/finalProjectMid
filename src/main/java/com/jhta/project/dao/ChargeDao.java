package com.jhta.project.dao;

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
	public List<ChargeVo> genderList(){
		return sqlSession.selectList(NAMESPACE+".genderList");
	}
}
