package com.udemy.component;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
public class TaskComponent {

	@Scheduled(fixedDelay = 5000)
	public void doTask() {
		log.info("TIME IS: "+ new Date());
	}
	
}
