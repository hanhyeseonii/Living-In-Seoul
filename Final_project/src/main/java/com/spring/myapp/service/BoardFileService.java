package com.spring.myapp.service;

import java.util.List;

import com.spring.myapp.dto.BoardFile;

public interface BoardFileService {
	//boardfile db에 접근
	List<BoardFile> selectList(int bnum);
	
}
