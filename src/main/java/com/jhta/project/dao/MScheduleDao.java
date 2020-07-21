package com.jhta.project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.project.vo.MScheduleListVo;
import com.jhta.project.vo.MScheduleVo;

@Repository
public class MScheduleDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.mschedule";
	private final String NAMESPACE2="com.jhta.mybatis.mapper.seat";
	
	//전체 구매한 영화목록 보여주기 위한 dao단
	public MScheduleListVo showAllMovieSchedule(HashMap<String, Object> map){
		System.out.println("dao가 타고 있어요");
		return sqlSession.selectOne(NAMESPACE+".getList",map);
	}
	
	//mschedule에 values insert
	public int insert(MScheduleVo vo) {
		System.out.println("들리는 줄 알았겠지만 유감이야");
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
	
	//mschedule 날짜 노출하기
	public List<HashMap<String, Object>> list(int branchNum,String regDate) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("branchNum", branchNum);
		map.put("regDate", regDate);
		return sqlSession.selectList(NAMESPACE+".list", map);
	}
	
	//좌석 갯수 노출하기
	public List<HashMap<String, Object>> scount(int branchNum) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("branchNum", branchNum);
		return sqlSession.selectList(NAMESPACE2+".scount", map);
	}
	
}
