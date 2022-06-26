package com.spring.myapp.repository;

import java.util.List;
import java.util.Map;

import com.spring.myapp.dto.Wdraw;

public interface WdrawRepository {
	int insert(Wdraw wdraw);
	Wdraw selectOne(String email);
	List<Wdraw> selectList(Map<String, String> wmap);
}
