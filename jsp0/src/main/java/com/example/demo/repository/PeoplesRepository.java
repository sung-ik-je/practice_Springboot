package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.domain.Peoples;

@Repository
public interface PeoplesRepository extends JpaRepository<Peoples, Long> {
	
	public List<Peoples> findAll();
	
	public List<Peoples> findAllById(Long id);
}
