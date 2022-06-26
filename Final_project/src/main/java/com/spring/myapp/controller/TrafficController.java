package com.spring.myapp.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.myapp.dto.BikeStation;
import com.spring.myapp.dto.RealTimeStationInfo;
import com.spring.myapp.service.BikeService;

@Controller
@RequestMapping("traffic")
public class TrafficController {
	@Autowired
	BikeService bikeService;

	@GetMapping("bikeList")
	public void bikeList() {
	}
	
	@ResponseBody
	@GetMapping("serch/{stationId}")
	public List<RealTimeStationInfo> serch(@PathVariable String stationId) throws IOException, ParseException {
		return bikeService.serchRealTimeStationInfo(stationId);
	}
	
	@ResponseBody
	@GetMapping("autocomplete")
	public List<BikeStation> autocomplete(@RequestParam String value) throws IOException, ParseException {
		return bikeService.autocomplete(value);
	}
	
}
