package com.spring.myapp.repository;

import java.util.List;

import com.spring.myapp.dto.Accident;

public interface AccidentRepository {
	void insert(Accident accident);
	void delete();
	Accident selectOne();
	List<Accident> selectList();
}
