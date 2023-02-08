package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PeoplesService;

@Controller
public class HtmlController {

	@Autowired			
	PeoplesService peoplesservice;
	
	/*
	 * @RestController 사용하면 ModelAndView 사용해서 return 해줘야
	 * .html file로 넘어갈 수 있다
	 */
//	@RequestMapping("/")
//	public ModelAndView startPage() {
//		
//		ModelAndView mav = new ModelAndView("index");
//		
//		return mav;
//	}
	
	
	@RequestMapping("/")
	public String startPage() {
		return "index";
	}
	
	
	
	@PostMapping(value ="add")
	public String addPeoplesUseParam(@RequestParam("name") String name) {
		
		peoplesservice.putPeople(name);
		
		return "success";
	}
	
	
	
	@PostMapping(value ="add/{name}")
	public String addPeoplesUsePath(@PathVariable("name") String name) {
		
		peoplesservice.putPeople(name);
		
		return "success";
	}
	
	
	
	// 정보를 화면에 어떻게 표시할지 확인 필요
	@GetMapping(value = "search")
	public ModelAndView searchPeoples(ModelAndView model) {
		
		model = peoplesservice.getPeoples(model);
		model.setViewName("allSearch.html");
		
		System.out.println("체크 : "+model);
		
		return model;
	}
	
	
	
	@PutMapping(value = "update")
	public String updatePeoples(@RequestParam("id") long id, @RequestParam("name") String name) {
		
		peoplesservice.updateName(id, name);
		
		return "success";
	}
	
	
	
	// 손봐야됨
	@DeleteMapping(value = "delete")
	public void deletePeoples(Long id) {
		
		peoplesservice.deleteId(id);
	}
	
	
}
