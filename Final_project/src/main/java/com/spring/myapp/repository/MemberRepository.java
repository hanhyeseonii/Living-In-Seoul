package com.spring.myapp.repository;

import java.util.List;
import java.util.Map;

import com.spring.myapp.dto.Member;
import com.spring.myapp.dto.Wdraw;

public interface MemberRepository {
	int insert (Member member);
	int update (Member member);
	int delete (String email);
	Member selectOne (String email);
	List<Member> selectList(Map<String, String> map);
	int insert_simplejoin(Member member);
	Member id_selectOne(Member member);
	Member pw_selectOne(Member member);
	int passwd_update(Member member);
	
}
