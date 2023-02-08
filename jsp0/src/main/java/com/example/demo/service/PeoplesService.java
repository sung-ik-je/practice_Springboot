package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.domain.Peoples;
import com.example.demo.repository.PeoplesRepository;

@Service
public class PeoplesService {
	
	@Autowired
	private PeoplesRepository peoplesRepository;
	
	
	public void getPeopleId(long n){
		if(peoplesRepository.findById((long) 2) != null) {
			System.out.println(peoplesRepository.findById((long) 2));
		}
		else {
			System.out.println("없다 그런 사람");
		}
	}
	
	
	
	
	public void getAllPeoples(){
		List<Peoples> peoples = peoplesRepository.findAll();		
		for(int i = 0; i< peoples.size(); i++) {
			System.out.println(peoples.get(i));
		}
		
	}
}