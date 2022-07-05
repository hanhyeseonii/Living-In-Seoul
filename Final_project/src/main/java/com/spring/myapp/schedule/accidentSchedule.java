package com.spring.myapp.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.myapp.service.AccidentService;

@Component
public class accidentSchedule {
	@Autowired
	AccidentService as;
	

	@Scheduled(cron="0 0/15 * * * *")
	public void apiUpdate() {
		as.insert();
	}
	
	@Scheduled(cron="0 0 0/3 * * *")
	public void apiDelete() {
		as.delete();
	}
	
	
}
