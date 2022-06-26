package com.spring.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myapp.dto.BoardFile;

@Repository
public class BoardFileRepositoryImpl implements BoardFileRepository{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(BoardFile boardFile) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.spring.myapp.BoardFileMapper.insert", boardFile);
	}

	@Override
	public int update(BoardFile boardFile) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.BoardFileMapper.update", boardFile);
	}

	@Override
	public int delete(int bfnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.spring.myapp.BoardFileMapper.delete", bfnum);
	}

	@Override
	public BoardFile selectOne(int bfnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.spring.myapp.BoardFileMapper.selectOne", bfnum);
	}

	@Override
	public List<BoardFile> selectList(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.spring.myapp.BoardFileMapper.selectList", bnum);
	}

}
