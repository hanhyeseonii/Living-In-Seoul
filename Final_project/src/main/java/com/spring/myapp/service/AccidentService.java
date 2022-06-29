package com.spring.myapp.service;

import java.util.List;

import com.spring.myapp.dto.Accident;

public interface AccidentService {
	void insert();
	void delete();
	Accident selectOne();
	List<Accident> selectList();
	
}
