package com.example.first_spring;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.services.HelloWord;

@RestController
@RequestMapping("/test")
public class Testing {

	@Autowired
	private HelloWord helloWord;

	@GetMapping
	public String testing(String name) {
		return helloWord.test("Jao");
	}
	
	@PostMapping
	public String helloPost(@RequestBody User body) {
		return "Hello post " + body.getName();
	}
}