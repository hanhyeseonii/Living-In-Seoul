package com.spring.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.spring.myapp.dto.Accident;
import com.spring.myapp.repository.AccidentRepository;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class AccidentServiceImpl implements AccidentService {
	
	@Autowired
	private AccidentRepository accidentRepository;
	
	@Override
	public void insert() {
		Accident check = accidentRepository.selectOne();
		try {
			String serviceKey = "455544657a64627335314a614a466b";
			StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
			urlBuilder.append("/" +  URLEncoder.encode(serviceKey,"UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
			urlBuilder.append("/" +  URLEncoder.encode("xml","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
			urlBuilder.append("/" + URLEncoder.encode("AccInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
			urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
			urlBuilder.append("/" + URLEncoder.encode("5","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
			System.out.println(urlBuilder);
			
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
            NodeList nlist = doc.getElementsByTagName("item");
            
            if(nlist!=null) {
            	loop:
    			for(int i=0; i < nlist.getLength(); i++) {
    				NodeList alist =  nlist.item(i).getChildNodes(); 
    				Accident accident = new Accident();
    				for(int j=0; j<alist.getLength(); j++) {
    					Node node = alist.item(j);
						if(j==0){
							accident.setAccId(Integer.parseInt(node.getTextContent()));
						}else if(j==10) {
							accident.setAccInfo(node.getTextContent());
						}
    				}
    				if(check!=null&&accident.getAccId()==check.getAccId()) {
    					break loop;
    				}else {
    					accidentRepository.insert(accident);
    				}
    			}
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		accidentRepository.delete();
	}

	@Override
	public Accident selectOne() {
		return accidentRepository.selectOne();
	}

	@Override
	public List<Accident> selectList() {
		return accidentRepository.selectList();
	}
	
}
