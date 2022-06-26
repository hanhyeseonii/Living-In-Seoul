package com.spring.myapp.repository;

import java.util.List;

import com.spring.myapp.dto.Board;
import com.spring.myapp.dto.Page;
import com.spring.myapp.dto.Tourism;

public interface TourismRepository {

	Tourism selectOne(int tnum);
	List<Tourism> selectList(Page page); //page는 페이징처리위한 정보
	//전체게시물수 구하기
	int selectTotalCnt(Page page);
	
	//조회수+1
	int updateReadCnt(int tnum);
	//좋아요+1
	int updateLikeCnt(int tnum);
	//싫어요 + 1
	int updateDisLikeCnt(int tnum);
	
	//삭제여부변경
	int updateRemoveyn(int tnum);
	
	
	
}
