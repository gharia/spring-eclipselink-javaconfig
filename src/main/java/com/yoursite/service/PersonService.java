package com.yoursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yoursite.repository.PersonDataRepository;


/**
 * @author Hemrajsinh Gharia
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class PersonService {

	@Autowired
	private PersonDataRepository personDataRepository;
	
	/*public void addPerson(Person person) {
		personDao.persist(person);
	}
	
	public void updatePerson(Person person) {
		personDao.merge(person);		
	}

	public Person getPerson(int id) {
		return personDao.findById(id);		
	}
	
	public void deletePerson(int id) {
		personDao.deleteById(id);
	}
	
	public List<Person> getPersons(int first, int rows){
		ReadAllQuery readAllQuery = new ReadAllQuery(Person.class);
		readAllQuery.setJPQLString("SELECT OBJECT(per) FROM Person per");
		return personDao.executeReadAllQuery(readAllQuery, first, rows);
	}*/
}
