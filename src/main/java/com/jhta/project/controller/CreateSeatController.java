package com.jhta.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateSeatController {
	
	@RequestMapping("/room/seat/create.do")
	public String create() {
		return ".room.seat.create";
	}
}
