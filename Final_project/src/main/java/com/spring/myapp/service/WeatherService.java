package com.spring.myapp.service;

import java.util.List;
import java.util.Map;

public interface WeatherService {
	public List<Map<String, String>> weatherService(String x, String y);

	Map<String, String> classification(String region);
}
