package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.domain.Peoples;
import com.example.demo.repository.PeoplesRepository;

@Service
public class PeoplesService {
	
	@Autowired
	private PeoplesRepository peoplesRepository;
	
	/*
	 *  CRUD logic 구현을 우선으로 추후에 여러가지 비즈니스 로직들 운용하면 될듯
	 */
	
	
	//Create
	public Peoples putPeople(String name) {
		
		Peoples newPeople = new Peoples(name);
		
		return peoplesRepository.save(newPeople);
	}
	
	
	
	//Read all
	public ModelAndView getPeoples(ModelAndView model) {
		
		List<Peoples> peoples = peoplesRepository.findAll();
		model.addObject("peoples", peoples);
//		for(int i=0; i<peoples.size(); i++) {
//			model.addObject(Long.toString(peoples.get(i).getId()), peoples.get(i).getName());
//		}
		
		return model;
	}
	
	
	//Update
	public Peoples updateName(long id, String name) {
		
		Peoples people = peoplesRepository.getById(id);
		
		if(people == null) {
			System.out.println("공백");
		}
		
		people.setName(name);
		
		return peoplesRepository.save(people);
		
	}


	// Delete
	public String deleteId(Long id) {
		
		peoplesRepository.deleteById(id);
		
		return "삭제 성공";
	}
	
	
}



