package com.yoursite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yoursite.model.Person;
import com.yoursite.repository.PersonDataRepository;
import com.yoursite.service.PersonService;

/**
 * Sample Controller with insert, update, fetch operations
 * @author Hemrajsinh Gharia
 *
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	private final PersonService personService;
	
	@Autowired
	private PersonDataRepository personDataRepository;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model, @RequestParam("startIndex") int startIndex, @RequestParam("limit") int limit) {
		Pageable pageable = new PageRequest(startIndex, limit);		
		model.addAttribute("title", "People ALl");
		model.addAttribute("peopleList", personDataRepository.findAll(pageable).iterator());
		return "people";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPerson(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("submitAction", "add");
		model.addAttribute("submitBtnText", "Create");
		model.addAttribute("title", "Add Person");
		return "addpeople";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@Valid Person person, BindingResult result, Model model) {
		if (result.hasErrors()) {			
			model.addAttribute("submitAction", "add");
			model.addAttribute("submitBtnText", "Create");
			model.addAttribute("title", "Add Person");
			return "addpeople";
		}
		personDataRepository.save(person);		
		return "redirect:/person?startIndex=0&limit=10";
	}
	
	@RequestMapping(value="/view/{personId}", method=RequestMethod.GET)
	public String updatePerson(@PathVariable int personId, Model model) {
		Person person = personDataRepository.getOne(new Long(personId));	    
	    model.addAttribute("person", person);
	    model.addAttribute("submitAction", "update");
	    model.addAttribute("submitBtnText","Update");
	    model.addAttribute("title","Update Person");
	    return "addpeople";
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
    public String update(@Valid Person person, BindingResult result, Model model) {    	
        if (result.hasErrors()) {
        	model.addAttribute("submitAction", "person/update");
    	    model.addAttribute("submitBtnText","Update");
    	    model.addAttribute("title","Update Person");
            return "addpeople";            
        }
        personDataRepository.save(person);       
        return "redirect:/person?startIndex=0&limit=10";
    }
}
