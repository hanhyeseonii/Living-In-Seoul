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

import com.spring.myapp.dto.Wdraw;
import com.spring.myapp.repository.WdrawRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTest_wdraw {
	
	@Autowired
	private WdrawRepository wdrawRepository;

	@Test
	public void testInsert() {
		Wdraw wdraw = new Wdraw();
		wdraw.setEmail("tbxl67@naver.com");
		wdraw.setWdrawrs("그냥");
		
		int cnt = wdrawRepository.insert(wdraw);
		System.out.println(cnt+"건 추가");
		assertEquals(1, cnt); //cnt가 1일때 성공
	}
	
	@Test
	public void testSelectOne() {
		Wdraw wdraw = wdrawRepository.selectOne("tbxl67@naver.com");
		System.out.println(wdraw);
		assertNotNull(wdraw); //wdraw가 null이 아니면 성공
	}
	
	@Test
	public void testSelectList() {
		Map<String, String> wmap = new HashMap<String, String>();
		wmap.put("findkey", "email");
		wmap.put("findvalue", "tbxl67@naver.com");
		List<Wdraw> wlist = wdrawRepository.selectList(wmap);
		System.out.println(wlist);
		assertNotEquals(0, wlist.size());//wlist의 사이즈가 0과 같지 않을 때 성공
	}

}
