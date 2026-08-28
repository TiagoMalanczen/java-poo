package com.example.first_spring.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWord {

	public String test(String name) {
		return "Hello World " + name;
	}
}