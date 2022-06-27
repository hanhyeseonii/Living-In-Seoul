package com.spring.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.myapp.service.WeatherService;


@Controller
@RequestMapping("weather")
public class WeatherController {
	
	@Autowired
	WeatherService ws;
	
	@GetMapping("weather")
	public void weather() {
	}
	
	@ResponseBody
	@PostMapping("weatherDetail")
	public List<Map<String, String>> weather(@RequestParam(value="id", required=false) String region) {
		Map<String, String> xy = new HashMap<>();
		if (region==null){
			xy = ws.classification("seoul");
		}else {
			xy = ws.classification(region);
		}		
		return ws.weatherService(xy.get("x"), xy.get("y"));
	}
}
