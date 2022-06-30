package com.spring.myapp.service;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class CovidServcieImpl implements CovidService{

	@Override
	public List<Map<String, String>> covidInfo() {
        //맵의 리스트 생성(반환값) 
        List<Map<String, String>> covidList = new ArrayList<>();
        Date date = new Date(new Date().getTime()+(1000*60*60*24*-1));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String yesterday = sdf.format(date);
    	try {
        	String serviceKey = "pE7DnZF8gkLfw8SzJY8g8W%2BiXnIpvnCLwCOpYH%2FuHqU6khdabBhMkXTkPkPGnnx6rLeeyut1NaYdULXoeKtxbQ%3D%3D";
            StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+serviceKey); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(yesterday, "UTF-8")); /*검색할 생성일 범위의 시작*/
            urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(yesterday, "UTF-8")); /*검색할 생성일 범위의 종료*/

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
            NodeList nlist = doc.getElementsByTagName("item");
            
			for(int i=0; i < nlist.getLength(); i++) {
				NodeList clist =  nlist.item(i).getChildNodes(); //자식노드들
				Map<String,String> covidInfo = new HashMap<>();

				for(int j=0; j<clist.getLength(); j++) {
					Node node = clist.item(j);
					if(i==17) {
						if(j==1||j==7){
							covidInfo.put(node.getNodeName(),node.getTextContent() );
						}
					}
				}
				if(i==17) {
					covidList.add(covidInfo);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

    	
    	return covidList;
	}
	
}
