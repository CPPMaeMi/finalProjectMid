package com.jhta.project.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
					/* 초 분 시 일 월 년  */
	@Scheduled(cron = "0 0 00 * * *")
	public void autoUpdate() {
		System.out.println("스케쥴러 테스트````````");
	}
}
