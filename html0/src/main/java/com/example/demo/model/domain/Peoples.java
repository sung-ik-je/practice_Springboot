package com.example.demo.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Peoples {

	
	@Id		//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private long id;
	private String name;
	
	
	public Peoples(String name) {
		this.name = name;
	}
}
