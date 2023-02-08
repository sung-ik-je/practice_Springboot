package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.domain.PeoplesDTO;
import com.example.demo.repository.PeoplesMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeoplesService {
	
	@Autowired
	private PeoplesMapper peopleMapper;
	
	
	public List<PeoplesDTO> getAll() {
		return peopleMapper.findAll();
	}


	public void putPeople(String name) {
		peopleMapper.putName(name);
	}
	
	public void updateName(long id, String name) {
		
		peopleMapper.updateName(id, name);
		
	}

	public void deleteId(Long id) {
		peopleMapper.deletePeople(id);
	}


	
	
}