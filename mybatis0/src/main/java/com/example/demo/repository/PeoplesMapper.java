package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.domain.PeoplesDTO;

@Repository
@Mapper
public interface PeoplesMapper {
	
	
	public List<PeoplesDTO> findAll();
	
	public void putName(String name);

	public void updateName(long id, String name);

	public void deletePeople(Long id);
}
