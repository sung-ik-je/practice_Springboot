package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.domain.Peoples;
import com.example.demo.service.PeoplesService;

@RestController		// view 반환 X, data 그대로 반환
public class PeoplesController {
	
	@Autowired			
	PeoplesService peoplesservice;
	
	
	/*
	 * Create 
	 * input : name
	 */
	

	// @RequestParam 사용한 경우
	@PostMapping(value ="add")
	public String addPeoplesUseParam(@RequestParam String name) {
		
		peoplesservice.putPeople(name);
		
		return "추가 성공";
	}
	
	//@PathVariable 애너테이션 이용한 경우
	@PostMapping(value ="add/{name}")
	public String addPeoplesUsePath(@PathVariable("name") String name) {
		
		peoplesservice.putPeople(name);
		
		return "추가 성공";
	}
	
	
	
	/*
	 * Read(전체 조회) 
	 * input : X
	 */
	@GetMapping(value = "search")
	
	public List<Peoples> searchPeoples() {
		return peoplesservice.getPeoples();
	}
	
	
	/*
	 * Update 
	 * input : id, 이름
	 * 특정 id 이름 update
	 */
	@PutMapping(value = "update")
	public String updatePeoples(@RequestParam long id, String name) {
		
		peoplesservice.updateName(id, name);
		
		return "업데이트 성공";
	}
	
	
	/*
	 * Delete 
	 * input : id
	 */
	
	@DeleteMapping(value = "delete")
	public String deletePeoples(Long id) {
		
		return peoplesservice.deleteId(id);
	}
}