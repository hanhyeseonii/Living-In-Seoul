package com.spring.myapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.myapp.service.CovidService;

@Controller
@RequestMapping("covid")
public class CovidController {
	@Autowired
	CovidService cs;
	
	@ResponseBody
	@PostMapping("covidInfo")
	public List<Map<String, String>> covid() {
		
		
		return cs.covidInfo();
	}
	
}
