package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo.repository"})	//bean 못찾아서 못찾는 위치 지나게 등록
//@ComponentScan(basePackages = {"com.example.demo.controller"})
public class Jpa0Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpa0Application.class, args);
	}

}
