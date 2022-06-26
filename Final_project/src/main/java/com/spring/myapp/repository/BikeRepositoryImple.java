package com.spring.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.myapp.dto.BikeStation;
import com.spring.myapp.dto.RealTimeStationInfo;

@Repository
public class BikeRepositoryImple implements BikeRepository {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(List<RealTimeStationInfo> blist) {
		return sqlSession.insert("com.spring.myapp.BikeMapper.insert", blist);
	}
	
	@Override
	public int update(List<RealTimeStationInfo> blist) {
		return sqlSession.update("com.spring.myapp.BikeMapper.update", blist);
	}
	
	@Override
	public BikeStation selectBikeStation(String stationId) {
		return sqlSession.selectOne("com.spring.myapp.BikeMapper.selectBikeStation", stationId);
	}
	
	@Override
	public RealTimeStationInfo selectRealTimeStationInfo(String stationId) {
		return sqlSession.selectOne("com.spring.myapp.BikeMapper.selectRealTimeStationInfo", stationId);
	}
	
	@Override
	public List<RealTimeStationInfo> selectList(BikeStation bikeStation) {
		return sqlSession.selectList("com.spring.myapp.BikeMapper.selectList", bikeStation);
	}

	@Override
	public List<BikeStation> autocomplete(String value) {
		return sqlSession.selectList("com.spring.myapp.BikeMapper.autocomplete", value);
	}

	

}
