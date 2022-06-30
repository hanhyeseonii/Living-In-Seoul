package com.spring.myapp.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myapp.dto.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.spring.myapp.MemberMapper.insert", member);
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.MemberMapper.update", member);
	}

	@Override
	public int delete(String email) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.spring.myapp.MemberMapper.delete", email);
	}

	@Override
	public Member selectOne(String email) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.spring.myapp.MemberMapper.selectOne", email);
	}

	@Override
	public List<Member> selectList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.spring.myapp.MemberMapper.selectList", map);
	}

	@Override
	public int insert_simplejoin(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.spring.myapp.MemberMapper.insert_simplejoin", member);
	}

	@Override
	public Member id_selectOne(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.spring.myapp.MemberMapper.id_selectOne", member);
	}

	@Override
	public Member pw_selectOne(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.spring.myapp.MemberMapper.pw_selectOne", member);
	}

	@Override
	public int passwd_update(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.spring.myapp.MemberMapper.passwd_update", member);
	}

}
