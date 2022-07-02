package com.spring.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myapp.dto.Accident;


@Repository
public class AccidentRepositoryImpl implements AccidentRepository {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(Accident accident) {
		sqlSession.insert("com.spring.myapp.AccidentMapper.insert", accident);
	}

	@Override
	public void delete() {
		sqlSession.delete("com.spring.myapp.AccidentMapper.delete");
	}

	@Override
	public Accident selectOne() {
		return sqlSession.selectOne("com.spring.myapp.AccidentMapper.selectOne");
	}

	@Override
	public List<Accident> selectList() {		
		return sqlSession.selectList("com.spring.myapp.AccidentMapper.selectList");
	}

}
