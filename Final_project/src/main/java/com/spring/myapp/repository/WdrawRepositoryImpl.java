package com.spring.myapp.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myapp.dto.Wdraw;

@Repository
public class WdrawRepositoryImpl implements WdrawRepository{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Wdraw wdraw) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.spring.myapp.WdrawMapper.insert", wdraw);
	}

	@Override
	public Wdraw selectOne(String email) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.spring.myapp.WdrawMapper.selectOne", email);
	}

	@Override
	public List<Wdraw> selectList(Map<String, String> wmap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.spring.myapp.WdrawMapper.selectList", wmap);
	}
}
