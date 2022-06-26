package com.spring.myapp.service;

import java.util.List;

import com.spring.myapp.advice.ErrorCode;
import com.spring.myapp.advice.ErrorCode1;
import com.spring.myapp.dto.Board;
import com.spring.myapp.dto.Page;

public interface BoardService {
	List<Board> selectList(Page page);
	Board selectOne(int bnum);
	//열거형 반환
	ErrorCode1 insert(Board board) throws Exception;
	ErrorCode1 update(Board board,List<Integer> removeFiles) throws Exception;
	ErrorCode1 updateRemoveyn(int bnum);
	
	//조회수+1
	int updateReadCnt(int bnum);
	//좋아요+1
	int updateLikeCnt(int bnum);
	//싫어요+1
	int updateDisLikeCnt(int bnum);
}
