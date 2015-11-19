package com.yoursite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoursite.model.Person;
import com.yoursite.repository.PersonDataRepository;
import com.yoursite.service.PersonService;

@RestController
public class GreetingController {
	
	private final PersonService personService;

	@Autowired
	private PersonDataRepository personDataRepository;
	
	@Autowired
	public GreetingController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/greeting")
	public Person greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return personDataRepository.getOne(1L);		
	}
}
