package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.domain.PeoplesDTO;
import com.example.demo.service.PeoplesService;

@RestController		
public class PeoplesController {
	
	@Autowired
	private PeoplesService peoplesService;
	
	@GetMapping("/searchAll")
	public List<PeoplesDTO> searchAll() {
		
		return peoplesService.getAll();
	}
	
	
	@PostMapping(value ="add")
	public void addPeoplesUseParam(@RequestParam String name) {
		
		peoplesService.putPeople(name);
		
	}
	
	@PutMapping(value = "update")
	public void updatePeoples(@RequestParam long id, String name) {
		
		peoplesService.updateName(id, name);
		
	}
	
	
	@DeleteMapping(value = "delete")
	public void deletePeoples(Long id) {
		
		peoplesService.deleteId(id);
	}
}