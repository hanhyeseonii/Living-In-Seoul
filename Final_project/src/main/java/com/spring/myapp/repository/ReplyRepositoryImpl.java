package com.spring.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myapp.dto.Reply;

@Repository
public class ReplyRepositoryImpl implements ReplyRepository{
	@Autowired
	private SqlSession sqlSession; 

	@Override
	public int insert(Reply reply) {
		return sqlSession.insert("com.spring.myapp.ReplyMapper.insert", reply);
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.ReplyMapper.update", reply);
	}

	@Override
	public int delete(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.spring.myapp.ReplyMapper.delete", rnum);
	}

	@Override
	public Reply selectOne(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.spring.myapp.ReplyMapper.selectOne", rnum);
	}

	@Override
	public List<Reply> selectList(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.spring.myapp.ReplyMapper.selectList", bnum);
	}

	@Override
	public int updateRestep(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.ReplyMapper.updateRestep", reply);
	}

}
