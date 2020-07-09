package com.jhta.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.project.vo.SeatVo;

@Controller
public class CreateSeatController {
	
	@Autowired
	
	
	@RequestMapping("/room/seat/create.do")
	public String create() {
		return ".room.seat.create";
	}
	
	@RequestMapping("/room/seat/createOk.do")
	public String createSeat(int[] seatSale,int[] seatX,int[] seatY) {
		ArrayList<SeatVo> list=new ArrayList<SeatVo>();
		for(int i=0;i<seatSale.length;i++) {
			list.add(new SeatVo(0, 0, seatX[i], seatY[i], seatSale[i]));
		}
		return "home";
	}
	
}
