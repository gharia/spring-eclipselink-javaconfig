package com.yoursite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoursite.model.Person;
import com.yoursite.repository.PersonDataRepository;
import com.yoursite.service.PersonService;

/**
 * Sample REST Controller
 * @author Hemrajsinh Gharia
 *
 */
@RestController
public class GreetingController {
	
	private final PersonService personService;

	@Autowired
	private PersonDataRepository personDataRepository;
	
	@Autowired
	public GreetingController(PersonService personService) {
		this.personService = personService;
	}

	/*
	 * Returns JSON represents of Person object
	 */
	@RequestMapping("/greeting/{personId}")
	public Person greeting(@PathVariable Long personId) {
		return personDataRepository.getOne(personId);		
	}
}
