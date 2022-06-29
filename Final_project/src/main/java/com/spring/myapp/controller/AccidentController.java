package com.spring.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("list")
	public void list() {
	
	}
	
	@GetMapping("search")
	public String search(Model model) {
		model.addAttribute("accidentList",as.selectList());
		return "accident/list";
	}
	
	@ResponseBody
	@GetMapping("wizet")
	public Accident wizet() {
		return as.selectOne();
	}
}
