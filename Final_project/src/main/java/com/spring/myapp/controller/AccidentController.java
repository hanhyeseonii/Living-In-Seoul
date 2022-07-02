package com.spring.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.myapp.dto.Accident;
import com.spring.myapp.service.AccidentService;

@Controller
@RequestMapping("accident")
public class AccidentController {
	@Autowired
	AccidentService as;

	
	@GetMapping("search")
	public String search(Model model) {
		model.addAttribute("accidentList",as.selectList());
		return "accident/accident";
	}
	
	@ResponseBody
	@GetMapping(value="wizet", produces = "application/text; charset=utf8")
	public String wizet() {
		return as.selectOne().getAccInfo();
	}
	
	@Scheduled(cron="0 */5 * * * *")
	public void apiUpdate() {
		as.insert();
	}
	

}
