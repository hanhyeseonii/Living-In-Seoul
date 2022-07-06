package com.spring.myapp.repository;

import java.util.List;

import com.spring.myapp.dto.BikeStation;
import com.spring.myapp.dto.FavoriteBikeStation;
import com.spring.myapp.dto.RealTimeStationInfo;

public interface BikeRepository {
	int insert(List<RealTimeStationInfo> blist);
	int update(List<RealTimeStationInfo> blist);
	BikeStation selectBikeStation(String stationId);
	List<RealTimeStationInfo> selectList(BikeStation bikeStation); 
	List<BikeStation> autocomplete(String value); //자동완성 검색어를 위한 리스트 불러오기
	RealTimeStationInfo selectRealTimeStationInfo(String stationId);
	List<FavoriteBikeStation> selectFavoriteList(String email);
	int insertFavorite(FavoriteBikeStation favoriteBikeStation);
}
