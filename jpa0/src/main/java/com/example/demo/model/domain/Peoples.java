package com.example.demo.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Peoples {

	@Id		//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//column 생성 조건, auto_increment
	private long id;
	private String name;
}
