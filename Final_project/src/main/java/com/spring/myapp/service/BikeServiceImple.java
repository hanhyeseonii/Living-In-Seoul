package com.spring.myapp.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myapp.dto.BikeStation;
import com.spring.myapp.dto.FavoriteBikeStation;
import com.spring.myapp.dto.RealTimeStationInfo;
import com.spring.myapp.repository.BikeRepository;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class BikeServiceImple implements BikeService{
	private static final Logger LOGGER = LoggerFactory.getLogger(BikeServiceImple.class);
	@Autowired
	BikeRepository bikeRepository;
	
	@Override
	public List<RealTimeStationInfo> serchRealTimeStationInfo(String stationId) {
		BikeStation bikeStation = bikeRepository.selectBikeStation(stationId);
		return bikeRepository.selectList(bikeStation);
	}
	
	//api조회후 대여소 정보 DB update(스케쥴러이용 30분마다 업데이트)
	//@Scheduled(cron = "0 0/10 * * * ?")
	@Transactional
	public void updateStationInfo() throws IOException, ParseException {
		//데이터 약2900개 한번에 호출할 수 있는 데이터 1000개 이므로 반복문 사용
		//총 데이터는 약5800개 2800개 이상부터는 전부 중복데이터
		for(int i=0;i<3;i++) {
			StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); //URL
			urlBuilder.append("/" +  URLEncoder.encode("477a6e4e6f746b723735466c615a50","UTF-8") ); //인증키
			urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); //요청파일타입 (xml,xmlf,xls,json)
			urlBuilder.append("/" + URLEncoder.encode("bikeListHist","UTF-8")); //서비스명
			urlBuilder.append("/" + URLEncoder.encode(i*1000+1+"","UTF-8")); //요청시작위치 
			if(i<2) {
				urlBuilder.append("/" + URLEncoder.encode((i+1)*1000+"","UTF-8")); //요청종료위치
			}else {
				urlBuilder.append("/" + URLEncoder.encode(2880+"","UTF-8")); //요청종료위치
			}
			//상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
			
			//현재 날짜와 시간을 입력
			LocalDateTime now = LocalDateTime.now();
			String NowDate = now.format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
			
			// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
			urlBuilder.append("/" + URLEncoder.encode(NowDate,"UTF-8")); //서비스별 추가 요청인자들
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			LOGGER.info("Response code: " + conn.getResponseCode()); //연결 자체에 대한 확인이 필요하므로 추가합니다.
			BufferedReader rd;
			
			//서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			
			//api에서 받아온 정보 파싱 후 dto에 저장
			JSONObject object = (JSONObject)new JSONParser().parse(sb.toString());
			object = (JSONObject)object.get("getStationListHist");
			JSONArray arr = (JSONArray)object.get("row");
			
			List<RealTimeStationInfo> blist = new ArrayList<RealTimeStationInfo>();
			for(int j=0;j<arr.size();j++) {
				RealTimeStationInfo stationInfo = new RealTimeStationInfo();
				object = (JSONObject)arr.get(j);
				stationInfo.setStationId((String)object.get("stationId"));
				stationInfo.setRackTotCnt((String)object.get("rackTotCnt"));
				stationInfo.setStationName((String)object.get("stationName"));
				stationInfo.setParkingBikeTotCnt((String)object.get("parkingBikeTotCnt"));
				stationInfo.setShared((String)object.get("shared"));
				stationInfo.setStationLatitude((String)object.get("stationLatitude"));
				stationInfo.setStationLongitude((String)object.get("stationLongitude"));
				if(bikeRepository.selectBikeStation(stationInfo.getStationId())!=null) // BikeStation테이블에 있는 데이터만 넣기
//					if(bikeRepository.selectRealTimeStationInfo(stationInfo.getStationId())==null) // 중복된 데이터 빼기(insert에만 사용)
						blist.add(stationInfo);	
			}
			if(blist.size()!=0) bikeRepository.update(blist);
		}
	}
	
	//자동완성 목록 불러오기
	@Override
	public List<BikeStation> autocomplete(String value){
		return bikeRepository.autocomplete(value);
	}

	@Override
	public List<FavoriteBikeStation> FavoriteList(String email) {
		List<FavoriteBikeStation> flist = bikeRepository.selectFavoriteList(email);
		return flist;
	}
	
	@Override
	public int insertFavorite(FavoriteBikeStation favoriteBikeStation) {
		return bikeRepository.insertFavorite(favoriteBikeStation);
	}

	@Override
	public RealTimeStationInfo selectROne(String stationId) {
		return bikeRepository.selectRealTimeStationInfo(stationId);
	}

	@Override
	public FavoriteBikeStation selectFavorite(String stationId) {
		return bikeRepository.selectFavorite(stationId);
	}
}

