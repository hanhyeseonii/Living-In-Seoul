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

import com.spring.myapp.dto.Accident;
import com.spring.myapp.dto.Member;
import com.spring.myapp.repository.AccidentRepository;
import com.spring.myapp.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTest_accident {

	@Autowired
	private AccidentRepository ar;
	
	@Test
	public void testInsert() {
		Accident ac = new Accident();
		ac.setAccId(1);
		ac.setAccInfo("테스트");
		ar.insert(ac);		
	}
}