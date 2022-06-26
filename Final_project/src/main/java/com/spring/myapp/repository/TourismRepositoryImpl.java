package com.spring.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myapp.dto.Board;
import com.spring.myapp.dto.Page;
import com.spring.myapp.dto.Tourism;

@Repository
public class TourismRepositoryImpl implements TourismRepository{

	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public Tourism selectOne(int tnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.spring.myapp.TourismMapper.selectOne", tnum);
	}

	@Override
	public List<Tourism> selectList(Page page) {
		return sqlSession.selectList("com.spring.myapp.TourismMapper.selectList", page);
	}

	@Override
	public int selectTotalCnt(Page page) {
		// 전체게시물수 구하기
		return sqlSession.selectOne("com.spring.myapp.TourismMapper.selectTotalCnt", page);
	}

	@Override
	public int updateReadCnt(int tnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.TourismMapper.updateReadCnt", tnum);
	}

	@Override
	public int updateRemoveyn(int tnum) {
		//삭제여부 변경
		return sqlSession.update("com.spring.myapp.TourismMapper.updateRemoveyn", tnum);
	}

	@Override
	public int updateLikeCnt(int tnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.TourismMapper.updateLikeCnt", tnum);
	}

	@Override
	public int updateDisLikeCnt(int tnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.TourismMapper.updateDisLikeCnt", tnum);
	}

}
