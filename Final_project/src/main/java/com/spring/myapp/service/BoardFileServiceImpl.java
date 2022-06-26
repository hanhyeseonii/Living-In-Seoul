package com.spring.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myapp.dto.BoardFile;
import com.spring.myapp.repository.BoardFileRepository;

@Service
public class BoardFileServiceImpl implements BoardFileService{
	
	@Autowired
	private BoardFileRepository boardFileRepository;
	
	@Override
	public List<BoardFile> selectList(int bnum) {
		// TODO Auto-generated method stub
		return boardFileRepository.selectList(bnum);
	}

}
