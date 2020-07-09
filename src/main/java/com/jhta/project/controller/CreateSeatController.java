package com.jhta.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.SeatVo;

@Controller
public class CreateSeatController {
	
	@Autowired
	private RestService service;
	
	@RequestMapping("/room/seat/create.do")
	public String create() {
		return ".room.seat.create";
	}
	
	@RequestMapping("/room/seat/createOk.do")
	public String createSeat(int[] seatSale,int[] seatX,int[] seatY) throws JsonProcessingException {
		ArrayList<SeatVo> list=new ArrayList<SeatVo>();
		for(int i=0;i<seatSale.length;i++) {
			list.add(new SeatVo(0, 0, seatX[i], seatY[i], seatSale[i]));
		}
		String url="http://localhost:9090/projectdb/room/seat/createOk.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString=mapper.writeValueAsString(list);
		String code=service.post(url, jsonString).trim();
		return "home";
	}
	@RequestMapping("/room/seat/theather.do")
	public String createSeat(int branchNum) throws JsonProcessingException {
		String url="http://localhost:9090/projectdb/room/seat/theather.do?branchNum="+branchNum;
		String code=service.get(url).trim();
		return "home";
	}
	
	
}
