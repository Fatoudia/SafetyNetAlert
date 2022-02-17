package com.formation.safetyNets2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.safetyNets2.model.Person;
import com.formation.safetyNets2.repository.PersonCRUDInterface;
import com.formation.safetyNets2.service.PersonServiceImpl;


@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonCRUDInterface ps;
	
	
	@GetMapping
	public List<Person> getList() {
		return this.ps.readEntities();
	}

	@PostMapping
    public List<Person> createPerson(@RequestBody Person p) {
		return this.ps.createEntity(p);
	}
	
	@DeleteMapping
	public void deletePerson(@RequestBody Person p) {
		this.ps.deleteEntity(p);
	}
	
	@PutMapping
	public void updatePerson(@RequestBody Person p) {
		this.ps.updateEntity(p);
	}
	

	// utilisation des méthodes de tri pour affichage dans URLs secondaires à /person

	@GetMapping("/emails")
	public List<String> getEmails(@RequestParam String city) {
		return PersonServiceImpl.emailListByCity(city);
	}
//
//	@GetMapping("/byLastName")
//	public List<Persons> getPersonsWithSameLastName(@RequestParam String lastName) {
//		return this.personServiceImpl.personListByLastName(lastName);
//	}
//
//	@GetMapping("/byFullName")
//	public Persons getOnePerson(@RequestParam String firstName, @RequestParam String lastName) {
//		return this.personServiceImpl.getByFullName(firstName, lastName);
//	}
//	
//	@GetMapping("/byName")
//	public String selectPerson(@RequestParam String firstName, @RequestParam String lastName) {
//		return this.personServiceImpl.onePersonByFullName(firstName, lastName).toString();
//	}
}
