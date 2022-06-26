package com.spring.myapp;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.myapp.dto.Member;
import com.spring.myapp.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTest_member {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setEmail("tbxl67@naver.com");
		member.setName("한혜선");
		member.setPasswd("1111");
		member.setBirthdate("1999-05-07");
		member.setAddress("서울시 구로구");
		
		int cnt = memberRepository.insert(member);
		System.out.println(cnt+"건 추가");
		assertEquals(1, cnt); //cnt가 1일때 성공
	}
	
	@Test
	public void testUpdate() {
		Member member = new Member();
		member.setName("강동원");
		member.setPasswd("2222");
		member.setBirthdate("1998-05-07");
		member.setAddress("서울시 강서구");
		member.setEmail("tbxl67@naver.com");
		
		int cnt = memberRepository.update(member);
		System.out.println(cnt+"건 수정");
		assertEquals(1, cnt); //cnt가 1일때 성공
	}
	
	@Test
	public void testDelete() {
		int cnt = memberRepository.delete("tbxl67@naver.com");
		System.out.println(cnt+"건 삭제");
		assertEquals(1, cnt); //cnt가 1일때 성공
	}
	
	@Test
	public void testSelectOne() {
		
		Member member = memberRepository.selectOne("tbxl67@naver.com");
		System.out.println(member);
		assertNotNull(member); //member가 null이 아니면 성공
	}
	
	@Test
	public void testSelectList() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("findkey", "email");
		map.put("findvalue", "tbxl67");
		List<Member> mlist = memberRepository.selectList(map);
		System.out.println(mlist);
		assertNotEquals(0, mlist.size());//mlist의 사이즈가 0과 같지 않을 때 성공
	}

}
