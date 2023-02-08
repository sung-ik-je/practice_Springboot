package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PeoplesService;

@RestController		// view 반환 X, data 그대로 반환
public class PeoplesController {
	
	@Autowired			// 의존 객체의 타입에 해당하는 빈을 찾아 주입
	PeoplesService peoplesservice;
	
	
	
	
	@RequestMapping(value = "/all")
	public void getAllPeoples() {
		peoplesservice.getAllPeoples();
	}
	
	
	@RequestMapping(value = "/2")
	public void findPeople() {
		peoplesservice.getPeopleId(2);
	}
	
	@GetMapping(value = "/home")
	public String check() {
		System.out.println("연결은 ㅇㅋㅋ");
		return "연결 ㅇㅋ";
	}
	
//	@GetMapping(value = "/")
//	public String checkStartPage() {
//	
//		return "check";
//	}
}