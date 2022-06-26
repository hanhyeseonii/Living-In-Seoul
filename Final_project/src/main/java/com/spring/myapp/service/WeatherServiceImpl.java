package com.spring.myapp.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


@Service
public class WeatherServiceImpl implements WeatherService {
	@Override
	public Map<String, String> classification(String region){
		Map<String, String> xy = new HashMap<>();
		switch(region) {
			case "구로구" : 
				xy.put("x", "58");
				xy.put("y", "125");	
				break;
			case "양천구" :
			case "강서구" : 
			case "영등포구" :
				xy.put("x", "58");
				xy.put("y", "126");	
				break;
			case "금천구" : 
				xy.put("x", "59");
				xy.put("y", "124");	
				break;
			case "동작구" : 
			case "관악구" :
				xy.put("x", "59");
				xy.put("y", "125");	
				break;
			case "은평구" : 
			case "서대문구" :
			case "마포구" :
				xy.put("x", "59");
				xy.put("y", "127");	
				break;
			case "용산구":
				xy.put("x", "60");
				xy.put("y", "126");
				break;
			case "서초구" : 
				xy.put("x", "61");
				xy.put("y", "125");	
				break;
			case "강남구" :
				xy.put("x", "61");
				xy.put("y", "126");	
				break;
			case "성동구":
			case "성북구":
			case "동대문구":
				xy.put("x", "61");
				xy.put("y", "127");	
				break;
			case "강북구" : 
				xy.put("x", "61");
				xy.put("y", "128");	
				break;
			case "도봉구" : 
			case "노원구" :
				xy.put("x", "61");
				xy.put("y", "129");	
				break;
			case "중랑구" : 
				xy.put("x", "62");
				xy.put("y", "128");	
				break;
			case "송파구" : 
			case "강동구" : 
			case "광진구" : 
				xy.put("x", "62");
				xy.put("y", "126");	
				break;
			case "종로구" : 
			case "중구" :
			default : 
				xy.put("x", "60");
				xy.put("y", "127");
				break;
		}
		return xy;
	}
	
	
	@Override
    public List<Map<String, String>> weatherService(String x, String y){
		
        List<Map<String, String>> weatherList = new ArrayList<>(); 
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		
		
		switch(hour) {
			case 0 :case 1 :case 2 :
		        cal.set(day, day-1);
		        day = cal.get(Calendar.DATE);
		        month = cal.get(Calendar.MONTH)+1;
		        year = cal.get(Calendar.YEAR);
		        hour = 23;
				break;
			case 3 :case 4 :case 5: 
				hour=2;
				break;
			case 6:case 7: case 8:
				hour=5;
				break;
			case 9: case 10: case 11:
				hour = 8;
				break;
			case 12: case 13: case 14:
				hour = 11;
				break;
			case 15:case 16:case 17:
				hour=14;
				break;
			case 18:case 19:case 20:
				hour=17;
				break;
			case 21:case 22:case 23:
				hour=20;
				break;
		}
		
		String s_hour = hour+"";
		String s_month = month+"";
		String s_year = year+"";
		String s_day = day+"";
		
		if(hour < 10) {
		   s_hour = '0'+s_hour;
		}
		if(month < 10) {
		    s_month = '0' + s_month;
		}    
		if(day < 10) {
		    s_day = '0'+s_day;
		}
		String today = s_year+s_month+s_day;
		s_hour += "00";
		
    	try {
    		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + "pE7DnZF8gkLfw8SzJY8g8W%2BiXnIpvnCLwCOpYH%2FuHqU6khdabBhMkXTkPkPGnnx6rLeeyut1NaYdULXoeKtxbQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(today, "UTF-8")); /*‘21년 6월 28일발표*/
            urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(s_hour, "UTF-8")); /*05시 발표*/
            urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(x, "UTF-8")); /*예보지점의 X 좌표값*/
            urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(y, "UTF-8")); /*예보지점의 Y 좌표값*/

			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
			NodeList nlist = doc.getElementsByTagName("item");
			
			
			for(int i=0; i < nlist.getLength(); i++) {
				NodeList wlist =  nlist.item(i).getChildNodes(); //자식노드들
				Map<String,String> weatherInfo = new HashMap<>();

				for(int j=0; j<wlist.getLength(); j++) {
					Node node = wlist.item(j);
					if(i==0||i==4||i==5||i==6||i==7||i==9||i==10) {
						if(j==2||j==5){
							weatherInfo.put(node.getNodeName(),node.getTextContent() );
							
						}
						
					}
					
				}
				if(i==0||i==4||i==5||i==6||i==7||i==9||i==10) {
					weatherList.add(weatherInfo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return weatherList;

    }
	

	
}