package com.spring.myapp.service;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.spring.myapp.dto.BikeStation;
import com.spring.myapp.dto.RealTimeStationInfo;

public interface BikeService {
	public List<RealTimeStationInfo> serchRealTimeStationInfo(String stationId);
	public void updateStationInfo() throws IOException, ParseException;
	public List<BikeStation> autocomplete(String value);
}
