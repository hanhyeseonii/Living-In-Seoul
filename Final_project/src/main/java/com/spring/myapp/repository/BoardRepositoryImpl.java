package com.spring.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myapp.dto.Accident;
import com.spring.myapp.dto.Board;
import com.spring.myapp.dto.Page;

@Repository
public class BoardRepositoryImpl implements BoardRepository{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Board board) {
		
		return sqlSession.insert("com.spring.myapp.BoardMapper.insert", board);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.BoardMapper.update", board);
	}

	@Override
	public int delete(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.spring.myapp.BoardMapper.delete", bnum);
	}

	@Override
	public Board selectOne(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.spring.myapp.BoardMapper.selectOne", bnum);
	}

	@Override
	public List<Board> selectList(Page page) {
		return sqlSession.selectList("com.spring.myapp.BoardMapper.selectList", page);
	}

	@Override
	public int selectTotalCnt(Page page) {
		// 전체게시물수 구하기
		return sqlSession.selectOne("com.spring.myapp.BoardMapper.selectTotalCnt", page);
	}

	@Override
	public int updateReadCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.BoardMapper.updateReadCnt", bnum);
	}

	@Override
	public int updateRemoveyn(int bnum) {
		//삭제여부 변경
		return sqlSession.update("com.spring.myapp.BoardMapper.updateRemoveyn", bnum);
	}

	@Override
	public int updateLikeCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.BoardMapper.updateLikeCnt", bnum);
	}

	@Override
	public int updateDisLikeCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.BoardMapper.updateDisLikeCnt", bnum);
	}
	
	@Override
	public List<Board> selectNew() {		
		return sqlSession.selectList("com.spring.myapp.BoardMapper.selectNew");
	}
	
	@Override
	public List<Board> selectHot() {		
		return sqlSession.selectList("com.spring.myapp.BoardMapper.selectHot");
	}

}
