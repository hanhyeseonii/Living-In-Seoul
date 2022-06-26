package com.spring.myapp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myapp.advice.ErrorCode;
import com.spring.myapp.controller.MemberController;
import com.spring.myapp.dto.Member;
import com.spring.myapp.dto.Wdraw;
import com.spring.myapp.repository.MemberRepository;
import com.spring.myapp.repository.WdrawRepository;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private WdrawRepository wdrawRepository;
	
	//암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	//회원가입**
	
	@Override
	public ErrorCode insert(Member member, HttpSession session) {
		
		//1)중복 이메일 체크
		Member dbmember = memberRepository.selectOne(member.getEmail());
		if (dbmember != null) {
			return ErrorCode.ERROR_EXIST_EMAIL;
		}
		//2)비밀번호 암호화
		String cryptPasswd =bCryptPasswordEncoder.encode(member.getPasswd());
		member.setPasswd(cryptPasswd);
		System.out.println(member);
		
		//3)저장
		int cnt =memberRepository.insert(member);
		logger.info(cnt+"건 추가");
		
		return ErrorCode.SIGNUP_SUCESS;
	}
	
	//로그인**
	Member member = new Member();
	
	@Override
	public ErrorCode loginCheck(String email, String passwd) {
		
		//한건 조회
		Member member = memberRepository.selectOne(email);
		//1)이메일이 없다면
		if (member == null) {
			return ErrorCode.ERROR_NONEXIST_EMAIL;
		}
		//2)비밀번호
		//평문과 암호문을 비교(평문, 암호문)
		boolean match = bCryptPasswordEncoder.matches(passwd, member.getPasswd());
		if(!match) {
			return ErrorCode.ERROR_NONMATCH_PASSWD;
		}
		//성공
		return ErrorCode.LOGIN_SUCCESS;
	}
	
	
	//탈퇴**
	//탈퇴 사유 입력
	@Transactional
	@Override
	public ErrorCode wdrawinsert(Wdraw wdraw) {

		//1)탈퇴사유를 입력하지 않았다면
		if(wdraw.getWdrawrs().equals("")) {
			return ErrorCode.ERROR_NONINSERT_WDRS;
		}
		//2)비밀번호가 일치하지 않는다면
		//평문과 암호문을 비교(평문, 암호문)
		Member member = memberRepository.selectOne(wdraw.getEmail());
		boolean match = bCryptPasswordEncoder.matches(wdraw.getPasswd(), member.getPasswd());
		if(!match) {
			return ErrorCode.ERROR_NONMATCH_PASSWD;
		}
		//성공
		wdrawRepository.insert(wdraw); //탈퇴사유를 insert
		memberRepository.delete(wdraw.getEmail()); //탈퇴회원을 지우기
		return ErrorCode.WDRAW_SUCCESS;
		
	}

	//한건조회
	@Override
	public Wdraw wdrawselectOne(String email) {
		Wdraw wdraw = wdrawRepository.selectOne(email);
		return wdraw;
	}

	//전체조회
	@Override
	public List<Wdraw> selectList(Map<String, String> wmap) {
		List<Wdraw> wlist = wdrawRepository.selectList(wmap);
		return wlist;
	}

	//정보**
	@Override
	public Member selectOne(String email) {
		// TODO Auto-generated method stub
		return memberRepository.selectOne(email);
	}
	
	//이메일 찾기**
	@Override
	public String id_selectOne(Member member) {
		Member dbmember = memberRepository.id_selectOne(member);
		if(dbmember != null) {
			return dbmember.getEmail();
		}
		return "일치하는 회원이 없습니다."; 
	}

	//비밀번호 찾기**
	@Override
	public ErrorCode pw_selectOne(Member member) {
		Member dbmember = memberRepository.pw_selectOne(member);
		if(dbmember != null) {
			return ErrorCode.SUCCESS_MATCH_PWINFO;
		}
		return ErrorCode.ERROR_NONMATCH_PWINFO; 
	}

	//내정보 수정**
	@Override
	public ErrorCode update(Member member) {
		//한건조회
		Member dbmember = memberRepository.selectOne(member.getEmail());
		//저장
		memberRepository.update(member);
		return ErrorCode.SUCCESS_INFOMODIFY;
	}

	//이메일 중복확인**
	@Override
	public ErrorCode duplCheck(String email) {
		//이메일 존재체크
		Member member = memberRepository.selectOne(email);
		if (member == null) { //이메일이 존재하지 않는다면
			return ErrorCode.SUCCESS_NONEXIST_EMAIL;
		}
		//이메일이 존재할 경우
		return ErrorCode.ERROR_ALREADY_EMAIL;
	}

}
