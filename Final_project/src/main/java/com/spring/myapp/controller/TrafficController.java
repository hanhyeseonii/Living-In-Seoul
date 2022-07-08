package com.spring.myapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.myapp.dto.BikeStation;
import com.spring.myapp.dto.FavoriteBikeStation;
import com.spring.myapp.dto.RealTimeStationInfo;
import com.spring.myapp.service.BikeService;

@Controller
@RequestMapping("traffic")
public class TrafficController {
	@Autowired
	BikeService bikeService;

	// 대여소 조회 페이지 이동
	@GetMapping("bikeList")
	public void bikeList() {
	}

	@ResponseBody
	@GetMapping("serch")
	public List<RealTimeStationInfo> serch(@RequestParam("stationId") String stationId)
			throws IOException, ParseException {
		return bikeService.serchRealTimeStationInfo(stationId);
	}

	@ResponseBody
	@GetMapping("autocomplete")
	public List<BikeStation> autocomplete(@RequestParam String value) throws IOException, ParseException {
		return bikeService.autocomplete(value);
	}

	// 따릉이 이용방법 페이지 이동
	@GetMapping("bikeManual")
	public void bikeManual() {
	}

	// 도로교통상황 페이지 이동
	@GetMapping("traffic")
	public void traffic() {
	}

	@ResponseBody
	@GetMapping("favorite")
	public List<FavoriteBikeStation> favorite(@RequestParam("email") String email) {
		return bikeService.FavoriteList(email);
	}

	@ResponseBody
	@PostMapping("addfavorite")
	public FavoriteBikeStation favorite(@RequestBody FavoriteBikeStation favoriteBikeStation, HttpSession session) {
		String StationId = favoriteBikeStation.getStationId();
		
		RealTimeStationInfo rStationInfo = bikeService.selectROne(StationId);
		
		favoriteBikeStation.setStationName(rStationInfo.getStationName());
		favoriteBikeStation.setStationLatitude(rStationInfo.getStationLatitude());
		favoriteBikeStation.setStationLongitude(rStationInfo.getStationLongitude());
		bikeService.insertFavorite(favoriteBikeStation);
		
		return bikeService.selectFavorite(StationId);
	}
}
