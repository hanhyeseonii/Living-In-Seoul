package com.spring.myapp.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.spring.myapp.advice.ErrorCode;
import com.spring.myapp.dto.Member;
import com.spring.myapp.dto.Wdraw;

public interface MemberService {
	//회원가입
	ErrorCode insert(Member member, HttpSession session);
	//로그인
	ErrorCode loginCheck(String email, String passwd);
	//탈퇴
	ErrorCode wdrawinsert(Wdraw wdraw, HttpSession session);
	Wdraw wdrawselectOne(String email);
	List<Wdraw> selectList(Map<String, String> wmap);
	//정보
	Member selectOne(String email);
	//이메일 중복확인
	ErrorCode duplCheck(String email);
	//이메일 찾기
	String id_selectOne(Member member);
	//비밀번호 찾기
	ErrorCode pw_selectOne(Member member);
	//비밀번호 수정
	ErrorCode passwd_update(Member member);
	//내정보 수정
	ErrorCode update(Member member);

	
}
