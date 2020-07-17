package com.jhta.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.SeatVo;
import com.jhta.project.vo.TheatherVo;

@Controller
public class CreateSeatController {
	
	@Autowired
	private RestService service;
	
	@RequestMapping("/room/seat/theatherInsert.do")
	public String theatherinsert(int branchNum,Model model) {
		model.addAttribute("branchNum",branchNum);
		return ".room.seat.theatherinsert";
	}
	
	@RequestMapping("/room/seat/create.do")
	public String create(int theatherNum,Model model) {
		String url="http://localhost:9090/projectdb/room/seat/getinfo.do?theatherNum="+theatherNum;
		String code=service.get(url).trim();
		Gson gson=new Gson();
		TheatherVo vo=gson.fromJson(code, TheatherVo.class);
 		model.addAttribute("vo",vo);
		return ".room.seat.create";
	}
	
	@RequestMapping("/room/seat/createOk.do")
	public String createSeat(int[] seatSale,int[] seatX,int[] seatY,String[] seatName,int theatherNum) throws JsonProcessingException {
		ArrayList<SeatVo> list=new ArrayList<SeatVo>();
		for(int i=0;i<seatSale.length;i++) {
			list.add(new SeatVo(0, theatherNum, seatX[i], seatY[i], seatSale[i], seatName[i]));
		}
		String url="http://localhost:9090/projectdb/room/seat/createOk.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString=mapper.writeValueAsString(list);
		String code=service.post(url, jsonString).trim();
		if(code.equals("success")) {
			return "redirect:/room/seat/theather.do";
		}else {
			return "error";
		}
	}
	@RequestMapping("/room/seat/createUpdate.do")
	public String createSeatUpdate(int[] seatSale,int[] seatNum,int theatherNum) throws JsonProcessingException {
		ArrayList<SeatVo> list=new ArrayList<SeatVo>();
		for(int i=0;i<seatSale.length;i++) {
			System.out.println(i+"번째"+seatSale[i]+","+seatNum[i]+","+theatherNum);
			list.add(new SeatVo(seatNum[i], 0, 0, 0, seatSale[i], null));
		}
		String url="http://localhost:9090/projectdb/room/seat/createUpdate.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString=mapper.writeValueAsString(list);
		String code=service.post(url, jsonString).trim();
		if(code.equals("success")) {
			return "redirect:/room/seat/theather.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/room/seat/theather.do")
	public String createSeat(@RequestParam(value="branchNum",defaultValue = "21") int branchNum,Model model) throws JsonProcessingException {
		String url="http://localhost:9090/projectdb/room/seat/theather.do?branchNum="+branchNum;
		String code = "";
		try {
			code=service.get(url).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson=new Gson();
 		TheatherVo[] array=gson.fromJson(code, TheatherVo[].class);
 		List<TheatherVo> list =Arrays.asList(array);
 		ArrayList<Integer> alist=new ArrayList<Integer>();
 		for(int i=0;i<list.size();i++) {
 			alist.add(list.get(i).getTheatherNum());
 		}
 		String url1="http://localhost:9090/projectdb/room/seat/seatCheck.do";
 		ObjectMapper mapper=new ObjectMapper();
		String jsonString=mapper.writeValueAsString(alist);
		String code1= service.post(url1, jsonString);
		Boolean[] array1=gson.fromJson(code1, Boolean[].class);
 		model.addAttribute("list",list);
 		model.addAttribute("blist",Arrays.asList(array1));
 		model.addAttribute("branchNum",branchNum);
		return ".room.seat.theather";
	}
	
	@RequestMapping("/room/seat/delete.do")
	public String deleteSeat(int theatherNum) {
		String url="http://localhost:9090/projectdb/room/seat/delete.do?theatherNum="+theatherNum;
		String code = "";
		try {
			code=service.get(url).trim();
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(code.equals("success")) {
			return "redirect:/room/seat/theather.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/room/seat/search.do")
	public String search(int theatherNum,Model model) {
		String url="http://localhost:9090/projectdb/room/seat/search.do?theatherNum="+theatherNum;
		String code=service.get(url).trim();
		Gson gson=new Gson();
		SeatVo[] array=gson.fromJson(code, SeatVo[].class);
		List<SeatVo> list=Arrays.asList(array);
		model.addAttribute("list",list);
		model.addAttribute("theatherNum",theatherNum);
		return ".room.seat.screen";
	}
	
	@RequestMapping("/room/seat/update.do")
	public String updateTheather(int theatherNum,Model model) {
		String url="http://localhost:9090/projectdb/room/seat/getinfo.do?theatherNum="+theatherNum;
		String code=service.get(url).trim();
		Gson gson=new Gson();
 		TheatherVo vo=gson.fromJson(code, TheatherVo.class);
 		model.addAttribute("vo",vo);
 		return ".room.seat.theatherupdate";
	}
	
	@RequestMapping("/room/seat/updateOk.do")
	public String updateOkTheather(TheatherVo vo,Model model) throws JsonProcessingException {
		String url="http://localhost:9090/projectdb/room/seat/updateOk.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(vo);
		String code = "";
		try {
			code=service.post(url,jsonString).trim();
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(code.equals("success")) {
			return "redirect:/room/seat/theather.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/room/seat/insert.do")
	public String insertSeat() throws JsonProcessingException {
		return ".room.seat.insert";
	}
	
	@RequestMapping("/room/seat/insertOk.do")
	public String insertOkSeat(TheatherVo vo,Model model) throws JsonProcessingException {
		String url="http://localhost:9090/projectdb/room/seat/insertOk.do";
		vo.setBranchNum(1);
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(vo);
		String code=service.post(url,jsonString).trim();
		if(code.equals("success")) {
			return "redirect:/room/seat/theather.do";
		}else {
			return "error";
		}
	}
}
