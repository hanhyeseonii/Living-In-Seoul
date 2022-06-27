package com.spring.myapp;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.myapp.dto.BikeStation;
import com.spring.myapp.dto.RealTimeStationInfo;
import com.spring.myapp.repository.BikeRepository;
import com.spring.myapp.service.BikeService;

@RunWith(SpringJUnit4ClassRunner.class)
//스프링에서 junitTest할때 db와 연결할 수 있도록 정보의 위치를 작성하는 어노테이션 
//root-context.xml의 위치, servlet-context.xml의 위치
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTest_traffic {
	@Autowired
	BikeService bikeService;
	@Autowired
	BikeRepository bikerepository;
	
	@Test
	public void testBikeList() {
		try {
			bikeService.updateStationInfo();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testBikeInfoUpdate() {
//		BikeStationInfo bikeStationInfo = new BikeStationInfo();
//		
//		bikeStationInfo.setStationId("ST-10");
//		bikeStationInfo.setStationName("108. 서교동 사거리수정");
//		bikeStationInfo.setRackTotCnt("10");
//		bikeStationInfo.setParkingBikeTotCnt("10");
//		bikeStationInfo.setShared("100");
//		bikeStationInfo.setStationLatitude("37.373737");
//		bikeStationInfo.setStationLongitude("127.272727");
//		
//		int cnt = bikerepository.update(bikeStationInfo);
//		System.out.println(cnt);
//	}
	
	@Test
	public void testSelectList() {
		BikeStation bikeStation = new BikeStation();
		bikeStation.setStationLatitude(37.51678085);
		bikeStation.setStationLongitude(127.09049225);
		
		List<RealTimeStationInfo> rlist = bikerepository.selectList(bikeStation);
		System.out.println(rlist);
	}
	
	@Test
	public void testBikeselectOne() {
		String staionId = "ST-1267";
		
		BikeStation bikeStation = bikerepository.selectBikeStation(staionId);
		System.out.println(bikeStation);
	}
	
	@Test
	public void testBikeselectList() {
		String stationId = "ST-10";
		List<RealTimeStationInfo> ilist = bikeService.serchRealTimeStationInfo(stationId);
		
		System.out.println(ilist);
	}
	
	@Test
	public void testBikeselectSerchList() {
		String findvalue = "신림";
		List<BikeStation> blist = bikerepository.autocomplete(findvalue);
		System.out.println(blist);
	}
	
}
